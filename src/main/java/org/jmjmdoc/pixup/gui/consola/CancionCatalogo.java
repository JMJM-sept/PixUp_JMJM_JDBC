package org.jmjmdoc.pixup.gui.consola;

import org.jmjmdoc.pixup.gui.consola.Util.ReadUtil;
import org.jmjmdoc.pixup.gui.consola.model.Cancion;

public class CancionCatalogo extends Catalogos<Cancion> {

    public static CancionCatalogo cancionCatalogo;
    private CancionCatalogo( )
    {
        super();
    }

    public static CancionCatalogo getInstance( )
    {
        if(cancionCatalogo ==null)
        {
            cancionCatalogo = new CancionCatalogo();
        }
        return cancionCatalogo;
    }

    @Override
    public Cancion newT() {
        return new Cancion();
    }

    @Override
    public boolean processNewT(Cancion cancion) {
        System.out.println("Teclee una canción" );
        cancion.setTituloC( ReadUtil.read( ) );
        System.out.println("Teclee la duración");
        System.out.print("Minutos: ");
        cancion.setDuracion( ReadUtil.readInt( ) );
        return true;
    }

    @Override
    public void processEditT(Cancion cancion) {
        System.out.println("Id de la canción " + cancion.getId( ) );
        System.out.println("Canción a editar: " + cancion.getTituloC( ) );
        System.out.println("Teclee el valor nuevo de la canción" );
        cancion.setTituloC( ReadUtil.read( ) );
        System.out.println("Teclee el valor nuevo de la duración" );
        System.out.print("Minutos: ");
        cancion.setDuracion( ReadUtil.readInt( ) );
    }
}
