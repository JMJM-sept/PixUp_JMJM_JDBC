package org.jmjmdoc.pixup.gui.consola.inicio;

import org.jmjmdoc.pixup.gui.consola.ventana.ConsolaVentana;

public class Inicio
{
    public static void main( String[] args )
    {
        System.out.println( "Inicio PixUp" );
        ConsolaVentana.getInstance( ).run( );
        System.out.println( "Termino PixUp" );
    }
}
