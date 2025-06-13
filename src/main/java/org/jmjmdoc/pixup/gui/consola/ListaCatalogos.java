package org.jmjmdoc.pixup.gui.consola;

import org.jmjmdoc.pixup.gui.consola.model.GeneroMusical;
import org.jmjmdoc.pixup.gui.consola.negocio.Ejecutable;
import org.jmjmdoc.pixup.gui.consola.ventana.LecturaAccion;

public class ListaCatalogos extends LecturaAccion
{
    public static ListaCatalogos listaCatalogos;
    private ListaCatalogos()
    {
    }
    public static ListaCatalogos getInstance( )
    {
        if(listaCatalogos==null)
        {
            listaCatalogos = new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu()
    {
        System.out.println( "Seleccione una opcion:" );
        System.out.println( "1.-Disquera");
        System.out.println( "2.-Género musical");
        System.out.println( "3.-Artista");
        System.out.println( "4.-Disco");
        System.out.println( "5.-Canción");
        System.out.println("6.- Salir");
    }
    @Override
    public int valorMinMenu()
    {
        return 1;
    }

    @Override
    public int valorMaxMenu()
    {
        return 6;
    }

    @Override
    public void procesaOpcion()
    {
        Ejecutable ejecutable = null;
        switch (opcion)
        {
            case 1:
                ejecutable = DisqueraCatalogo.getInstance();
                break;
            case 2:
                ejecutable = GeneroMusicalCatalogo.getInstance();
                break;
            case 3:
                ejecutable = ArtistaCatalogo.getInstance();
                break;
            case 4:
                ejecutable = DiscoCatalogo.getInstance();
                break;
            case 5:
                ejecutable = CancionCatalogo.getInstance();
                break;
        }
        ejecutable.setFlag( true );
        ejecutable.run( );

    }
}
