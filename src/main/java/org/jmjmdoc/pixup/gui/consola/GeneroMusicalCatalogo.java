package org.jmjmdoc.pixup.gui.consola;

import org.jmjmdoc.pixup.gui.consola.Util.ReadUtil;
import org.jmjmdoc.pixup.gui.consola.model.GeneroMusical;

public class GeneroMusicalCatalogo extends Catalogos<GeneroMusical> {

    public static GeneroMusicalCatalogo generoMusicalCatalogo;

    private GeneroMusicalCatalogo() {
        super();
    }

    public static GeneroMusicalCatalogo getInstance() {
        if(generoMusicalCatalogo == null) {
            generoMusicalCatalogo = new GeneroMusicalCatalogo();
        }
        return generoMusicalCatalogo;
    }
    @Override
    public GeneroMusical newT() {
        return new GeneroMusical();
    }

    @Override
    public boolean processNewT(GeneroMusical generoMusical) {
        System.out.println("Teclee un género musical");
        generoMusical.setDescripcion(ReadUtil.read());
        return true;
    }

    @Override
    public void processEditT(GeneroMusical generoMusical) {
        System.out.println("Id del género musical " +generoMusical.getId());
        System.out.println("Género musical a editar: " + generoMusical.getDescripcion());
        System.out.println("Teclee el valor nuevo del género musical: ");
        generoMusical.setDescripcion(ReadUtil.read());
    }


}
