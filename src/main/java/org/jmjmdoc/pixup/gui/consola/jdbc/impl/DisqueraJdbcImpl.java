package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.Conexion;
import org.jmjmdoc.pixup.gui.consola.jdbc.DisqueraJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DisqueraJdbcImpl extends Conexion<Disquera> implements DisqueraJdbc
{
    private static DisqueraJdbcImpl disqueraJdbc;

    private DisqueraJdbcImpl( )
    {
        super( );
    }


    public static DisqueraJdbcImpl getInstance( )
    {
        if( disqueraJdbc == null )
        {
            disqueraJdbc = new DisqueraJdbcImpl();
        }
        return disqueraJdbc;
    }

    @Override
    public List<Disquera> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Disquera> list = null;
        Disquera disquera = null;
        String sql ="Select * from TBL_DISQUERA";


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
            list =  new java.util.ArrayList<Disquera>( );
            while( resultSet.next( ) )
            {
                disquera = new Disquera();
                disquera.setId( resultSet.getInt( "ID" ) );
                disquera.setNombre( resultSet.getString( "NOMBRE" ) );
                list.add( disquera );
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
    public boolean save(Disquera disquera) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_DISQUERA (NOMBRE) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disquera.getNombre());
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
    public boolean update(Disquera disquera) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_DISQUERA SET NOMBRE = ? WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disquera.getNombre());
            preparedStatement.setInt(2, disquera.getId());
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
    public boolean delete(Disquera disquera) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_DISQUERA WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, disquera.getNombre());
            preparedStatement.setInt(1, disquera.getId());
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
    public Disquera findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        Disquera disquera = null;
        String sql ="Select * from TBL_DISQUERA where ID = %d";
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
                disquera = new Disquera();
                disquera.setId( resultSet.getInt( "ID" ) );
                disquera.setNombre( resultSet.getString( "NOMBRE" ) );
            }
            resultSet.close( );
            closeConnection( );
            return disquera;
        }
        catch (SQLException e)
        {
            return null;
        }    }

}
