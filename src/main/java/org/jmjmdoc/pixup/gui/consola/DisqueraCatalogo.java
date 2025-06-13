package org.jmjmdoc.pixup.gui.consola;

import org.jmjmdoc.pixup.gui.consola.Util.ReadUtil;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

public class DisqueraCatalogo extends Catalogos<Disquera>
{
    public static DisqueraCatalogo disqueraCatalogo;
    private DisqueraCatalogo( )
    {
        super();
    }

    public static DisqueraCatalogo getInstance( )
    {
        if(disqueraCatalogo==null)
        {
            disqueraCatalogo = new DisqueraCatalogo();
        }
        return disqueraCatalogo;
    }

    @Override
    public Disquera newT()
    {
        return new Disquera( );
    }

    @Override
    public boolean processNewT(Disquera disquera)
    {
        System.out.println("Teclee una disquera" );
        disquera.setNombre( ReadUtil.read( ) );
        return true;
    }

    @Override
    public void processEditT(Disquera disquera)
    {
        System.out.println("Id de la disquera " + disquera.getId( ) );
        System.out.println("Disquera a editar: " + disquera.getNombre( ) );
        System.out.println("Teclee el valor nuevo de la nueva disquera" );
        disquera.setNombre( ReadUtil.read( ) );
    }

}