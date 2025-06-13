package org.jmjmdoc.pixup.gui.consola.jdbc;

import org.jmjmdoc.pixup.gui.consola.model.Disquera;
import org.jmjmdoc.pixup.gui.consola.model.GeneroMusical;

import java.util.List;

public interface GeneroMusicalJdbc {
    List<GeneroMusical> findAll();
    boolean save (GeneroMusical generoMusical);
    boolean update (GeneroMusical generoMusical);
    boolean delete (GeneroMusical generoMusical);
    GeneroMusical findById (Integer id);
}
