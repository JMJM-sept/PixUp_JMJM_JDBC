package org.jmjmdoc.pixup.gui.consola.jdbc;

import org.jmjmdoc.pixup.gui.consola.model.Cancion;

import java.util.List;

public interface CancionJdbc {
    List<Cancion> findAll();
    boolean save (Cancion cancion);
    boolean update (Cancion cancion);
    boolean delete (Cancion cancion);
    Cancion findById (Integer id);
}
