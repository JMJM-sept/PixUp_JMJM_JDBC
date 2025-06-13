package org.jmjmdoc.pixup.gui.consola;

import org.jmjmdoc.pixup.gui.consola.Util.ReadUtil;
import org.jmjmdoc.pixup.gui.consola.model.Disco;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;

public class DiscoCatalogo extends Catalogos<Disco>
{
    public static DiscoCatalogo discoCatalogo;
    private DiscoCatalogo( )
    {
        super();
    }

    public static DiscoCatalogo getInstance( )
    {
        if(discoCatalogo==null)
        {
            discoCatalogo = new DiscoCatalogo();
        }
        return discoCatalogo;
    }

    @Override
    public Disco newT()
    {
        return new Disco( );
    }

    @Override
    public boolean processNewT(Disco disco)
    {
        System.out.println("Teclee el título del disco" );
        disco.setTitulo( ReadUtil.read( ) );
        System.out.println("Teclee el precio del disco");
        disco.setPrecio(ReadUtil.readInt());
        System.out.println("Teclee la cantidad en existencia");
        disco.setExistencia(ReadUtil.readInt());
        System.out.println("Teclee el descuento del disco");
        disco.setDescuento(ReadUtil.readInt());
        System.out.println("Teclee la fecha de lanzamiento del dico");
        disco.setFechaLan(ReadUtil.read());
        System.out.println("Teclee la imagen");
        disco.setImagen(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(Disco disco)
    {
        System.out.println("Id del disco " + disco.getId( ) );
        System.out.println("Disco a editar: " + disco.getTitulo( ) );
        System.out.println("Teclee el valor nuevo del disco: " );
        disco.setTitulo( ReadUtil.read( ) );
        System.out.println("Teclee el precio nuevo del disco: " );
        disco.setPrecio(ReadUtil.readInt());
        System.out.println("Teclee la existencia nueva del disco: " );
        disco.setExistencia(ReadUtil.readInt());
        System.out.println("Teclee el descuento nuevo del disco: " );
        disco.setDescuento(ReadUtil.readInt());
        System.out.println("Teclee la fecha de lanzamiento nuevo del disco: " );
        disco.setFechaLan(ReadUtil.read());
        System.out.println("Teclee la imagen nueva del disco: " );
        disco.setImagen(ReadUtil.read());
    }

}
