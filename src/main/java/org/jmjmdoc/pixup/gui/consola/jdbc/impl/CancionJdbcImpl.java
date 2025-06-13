package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.CancionJdbc;
import org.jmjmdoc.pixup.gui.consola.jdbc.Conexion;
import org.jmjmdoc.pixup.gui.consola.model.Cancion;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CancionJdbcImpl extends Conexion<Cancion> implements CancionJdbc {

    private static CancionJdbcImpl cancionJdbc;

    private CancionJdbcImpl( )
    {
        super( );
    }


    public static CancionJdbcImpl getInstance( )
    {
        if( cancionJdbc == null )
        {
            cancionJdbc = new CancionJdbcImpl();
        }
        return cancionJdbc;
    }

    @Override
    public List<Cancion> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Cancion> list = null;
        Cancion cancion = null;
        String sql ="Select * from TBL_CANCION";

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
            list =  new java.util.ArrayList<Cancion>( );
            while( resultSet.next( ) )
            {
                cancion = new Cancion();
                cancion.setId( resultSet.getInt( "ID" ) );
                cancion.setTituloC( resultSet.getString( "TÍTULO" ) );
                cancion.setDuracion(resultSet.getInt("DURACIÓN"));
                list.add( cancion );
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
    public boolean save(Cancion cancion) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_CANCION (TITULO) VALUES (?)";
        query = "INSERT INTO TBL_CANCION (DURACION) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cancion.getTituloC());
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
    public boolean update(Cancion cancion) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_CANCION SET TITULO = ? WHERE ID = ?";
        query = "UPDATE TBL_CANCION SET DURACION = ? WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cancion.getTituloC());
            preparedStatement.setInt(2, cancion.getId());
            preparedStatement.setInt(3, cancion.getDuracion());

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
    public boolean delete(Cancion cancion) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_CANCION WHERE ID = ?";
        int res = 0;

        try {
            if (openConnection()) {
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, cancion.getTituloC());
                preparedStatement.setInt(1, cancion.getId());
                preparedStatement.setInt(1, cancion.getDuracion());
                res = preparedStatement.executeUpdate();
                preparedStatement.close();
                closeConnection();
                return res == 1;
            } else {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Cancion findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Cancion cancion = null;
        String sql = "Select * from TBL_CANCION where ID = %d";
        try {
            if (!openConnection()) {
                return null;
            }
            sql = String.format(sql, id);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (!openConnection()) {
                return null;
            }
            sql = String.format(sql, id);

            while (resultSet.next()) {
                cancion = new Cancion();
                cancion.setId(resultSet.getInt("ID"));
                cancion.setTituloC(resultSet.getString("TITULO"));
                cancion.setDuracion(resultSet.getInt("DURACION"));
            }
            resultSet.close();
            closeConnection();
            return cancion;
        } catch (SQLException e) {
            return null;
        }
    }
}
