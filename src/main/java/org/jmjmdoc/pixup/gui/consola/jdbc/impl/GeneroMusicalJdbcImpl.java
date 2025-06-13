package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.Conexion;
import org.jmjmdoc.pixup.gui.consola.jdbc.GeneroMusicalJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;
import org.jmjmdoc.pixup.gui.consola.model.GeneroMusical;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class GeneroMusicalJdbcImpl extends Conexion<GeneroMusical> implements GeneroMusicalJdbc {

    private static GeneroMusicalJdbcImpl generoMusicalJdbc;

    private GeneroMusicalJdbcImpl( )
    {
        super( );
    }

    public static GeneroMusicalJdbcImpl getInstance( )
    {
        if( generoMusicalJdbc == null )
        {
            generoMusicalJdbc = new GeneroMusicalJdbcImpl();
        }
        return generoMusicalJdbc;
    }

    @Override
    public List<GeneroMusical> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<GeneroMusical> list = null;
        GeneroMusical generoMusical = null;
        String sql ="Select * from TBL_GENERO_MUSICAL";


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
            list =  new java.util.ArrayList<GeneroMusical>( );
            while( resultSet.next( ) )
            {
                generoMusical = new GeneroMusical();
                generoMusical.setId( resultSet.getInt( "ID" ) );
                generoMusical.setDescripcion( resultSet.getString( "DESCRIPCION" ) );
                list.add( generoMusical );
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
    public boolean save(GeneroMusical generoMusical) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO TBL_GENERO_MUSICAL (DESCRIPCION) VALUES (?)";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, generoMusical.getDescripcion());
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
    public boolean update(GeneroMusical generoMusical) {
        PreparedStatement preparedStatement = null;
        String query = "UPDATE TBL_GENERO_MUSICAL SET DESCRIPCION = ? WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, generoMusical.getDescripcion());
            preparedStatement.setInt(2, generoMusical.getId());
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
    public boolean delete(GeneroMusical generoMusical) {
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM TBL_GENERO_MUSICAL WHERE ID = ?";
        int res = 0;

        try {
            if (!openConnection()) {
                System.out.println("ERROR DE CONEXIÓN");
                return false;
            }
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, generoMusical.getDescripcion());
            preparedStatement.setInt(1, generoMusical.getId());
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
    public GeneroMusical findById(Integer id) {
        Statement statement = null;
        ResultSet resultSet = null;
        GeneroMusical generoMusical = null;
        String sql ="Select * from TBL_GENERO_MUSICAL where ID = %d";
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
                generoMusical = new GeneroMusical();
                generoMusical.setId( resultSet.getInt( "ID" ) );
                generoMusical.setDescripcion( resultSet.getString( "DESCRIPCION" ) );
            }
            resultSet.close( );
            closeConnection( );
            return generoMusical;
        }
        catch (SQLException e)
        {
            return null;
        }    }

}
