package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.ArtistaJdbc;
import org.jmjmdoc.pixup.gui.consola.jdbc.Conexion;
import org.jmjmdoc.pixup.gui.consola.model.Artista;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ArtistaJdbcImpl extends Conexion<Artista> implements ArtistaJdbc {

    private static ArtistaJdbcImpl artistaJdbc;

    private ArtistaJdbcImpl( )
    {
        super( );
    }

    public static ArtistaJdbcImpl getInstance( )
    {
        if( artistaJdbc == null )
        {
            artistaJdbc = new ArtistaJdbcImpl();
        }
        return artistaJdbc;
    }

    @Override
    public List<Artista> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Artista> list = null;
        Artista artista = null;
        String sql ="Select * from TBL_ARTISTA";

        try
        {
            if (!openConnection()) {
                System.out.println("ERROR");
                return null;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(sql);
                if (resultSet == null) {
                    return null;
                }
                list = new java.util.ArrayList<Artista>();
                while (resultSet.next()) {
                    artista = new Artista();
                    artista.setId(resultSet.getInt("ID"));
                    artista.setNombreArt(resultSet.getString("DESCRIPCION"));
                    list.add(artista);
                }
                resultSet.close();
                closeConnection();
                return list;
            }
        }
        catch (SQLException e)
        {
            return null;
        }
    }

    @Override
    public boolean save(Artista artista) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_ARTISTA (DESCRIPCION) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, artista.getNombreArt());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Artista artista) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_ARTISTA SET DESCRIPCION = ? WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, artista.getNombreArt());
            preparedStatement.setInt(2, artista.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Artista artista) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_ARTISTA WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, artista.getNombreArt());
            preparedStatement.setInt(1, artista.getId());
            res = preparedStatement.executeUpdate();
            preparedStatement.close();
            closeConnection();
            return res == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Artista findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Artista artista = null;
        String sql ="Select * from TBL_ARTISTA where ID = %d";
        try
        {
            if( !openConnection() )
            {
                return null;
            }
            sql = String.format(sql, id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( !openConnection() )
            {
                return null;
            }
            sql = String.format(sql, id);

            while( resultSet.next( ) )
            {
                artista = new Artista();
                artista.setId( resultSet.getInt( "ID" ) );
                artista.setNombreArt( resultSet.getString( "DESCRIPCIÓN" ) );
            }
            resultSet.close( );
            closeConnection( );
            return artista;
        }
        catch (SQLException e)
        {
            return null;
        }    }
    }
