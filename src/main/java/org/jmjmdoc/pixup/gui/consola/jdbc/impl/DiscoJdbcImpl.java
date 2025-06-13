package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.Conexion;
import org.jmjmdoc.pixup.gui.consola.jdbc.DiscoJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Disco;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DiscoJdbcImpl extends Conexion<Disco> implements DiscoJdbc
{
    private static DiscoJdbcImpl discoJdbc;

    private DiscoJdbcImpl( )
    {
        super( );
    }


    public static DiscoJdbcImpl getInstance( )
    {
        if( discoJdbc == null )
        {
            discoJdbc = new DiscoJdbcImpl();
        }
        return discoJdbc;
    }

    @Override
    public List<Disco> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Disco> list = null;
        Disco disco = null;
        String sql ="Select * from TBL_DISCO";


        try
        {
            if( !openConnection() )
            {
                System.out.println("ERROR");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            list =  new java.util.ArrayList<Disco>( );
            while( resultSet.next( ) )
            {
                disco = new Disco();
                disco.setId( resultSet.getInt( "ID" ) );
                disco.setTitulo( resultSet.getString( "TITULO" ) );
                disco.setPrecio(resultSet.getInt("PRECIO"));
                disco.setExistencia(resultSet.getInt("EXISTENCIA"));
                disco.setDescuento(resultSet.getInt("DESCUENTO"));
                disco.setFechaLan(resultSet.getString("FECHA_LANZAMINETO"));
                disco.setImagen(resultSet.getString("IMAGEN"));
                list.add( disco );
            }
            resultSet.close( );
            closeConnection( );
            return list;
        }
        catch (SQLException e)
        {
            return null;
        }
    }

    @Override
    public boolean save(Disco disco) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_DISCO (TITULO) VALUES (?)";
         query = "INSERT INTO TBL_DISCO (PRECIO) VALUES (?)";
         query = "INSERT INTO TBL_DISCO (EXISTENCIA) VALUES (?)";
         query = "INSERT INTO TBL_DISCO (DESCUENTO) VALUES (?)";
         query = "INSERT INTO TBL_DISCO (FECHA_LANZAMIENTO) VALUES (?)";
         query = "INSERT INTO TBL_DISCO (IMAGEN) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disco.getTitulo());
            preparedStatement.setInt(1, disco.getPrecio());
            preparedStatement.setInt(1, disco.getExistencia());
            preparedStatement.setInt(1, disco.getDescuento());
            preparedStatement.setString(1, disco.getFechaLan());
            preparedStatement.setString(1, disco.getImagen());

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
    public boolean update(Disco disco) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_DISCO SET TITULO = ? WHERE ID = ?";
        query = "UPDATE TBL_DISCO SET PRECIO = ? WHERE ID = ?";
        query = "UPDATE TBL_DISCO SET EXISTENCIA = ? WHERE ID = ?";
        query = "UPDATE TBL_DISCO SET DESCUENTO = ? WHERE ID = ?";
        query = "UPDATE TBL_DISCO SET FECHA_LANZAMIENTO = ? WHERE ID = ?";
        query = "UPDATE TBL_DISCO SET IMAGEN = ? WHERE ID = ?";

        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, disco.getId());
            preparedStatement.setString(2, disco.getTitulo());
            preparedStatement.setInt(3, disco.getPrecio());
            preparedStatement.setInt(4, disco.getExistencia());
            preparedStatement.setInt(5, disco.getDescuento());
            preparedStatement.setString(6, disco.getFechaLan());
            preparedStatement.setString(7, disco.getImagen());
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
    public boolean delete(Disco disco) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_DISCO WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, disco.getId());
            preparedStatement.setString(1, disco.getTitulo());
            preparedStatement.setInt(1, disco.getPrecio());
            preparedStatement.setInt(1, disco.getExistencia());
            preparedStatement.setInt(1, disco.getDescuento());
            preparedStatement.setString(1, disco.getFechaLan());
            preparedStatement.setString(1, disco.getImagen());
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
    public Disco findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Disco disco = null;
        String sql ="Select * from TBL_DISCO where ID = %d";
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
                disco = new Disco();
                disco.setId( resultSet.getInt( "ID" ) );
                disco.setTitulo( resultSet.getString( "TITULO" ) );
                disco.setPrecio( resultSet.getInt( "PRECIO" ) );
                disco.setExistencia( resultSet.getInt( "EXISTENCIA" ) );
                disco.setDescuento( resultSet.getInt( "DESCUENTO" ) );
                disco.setFechaLan( resultSet.getString( "FECHA_LANZAMIENTO" ) );
                disco.setImagen( resultSet.getString( "IMAGEN" ) );

            }
            resultSet.close( );
            closeConnection( );
            return disco;
        }
        catch (SQLException e)
        {
            return null;
        }    }

}
