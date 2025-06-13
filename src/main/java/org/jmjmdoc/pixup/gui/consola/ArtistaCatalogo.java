package org.jmjmdoc.pixup.gui.consola;

import org.jmjmdoc.pixup.gui.consola.Util.ReadUtil;
import org.jmjmdoc.pixup.gui.consola.model.Artista;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

public class ArtistaCatalogo extends Catalogos<Artista> {

    public static ArtistaCatalogo artistaCatalogo;
    private ArtistaCatalogo( )
    {
        super();
    }

    public static ArtistaCatalogo getInstance( )
    {
        if(artistaCatalogo==null)
        {
            artistaCatalogo = new ArtistaCatalogo();
        }
        return artistaCatalogo;
    }

    @Override
    public Artista newT() {
        return new Artista( );
    }

    @Override
    public boolean processNewT(Artista artista) {
        System.out.println("Teclee un artista" );
        artista.setNombreArt( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Artista artista) {
        System.out.println("Id del artista " + artista.getId( ) );
        System.out.println("Artista a editar: " + artista.getNombreArt( ) );
        System.out.println("Teclee el valor nuevo del artista" );
        artista.setNombreArt( ReadUtil.read( ) );
    }
}
