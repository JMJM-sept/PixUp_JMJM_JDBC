package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.CancionJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Cancion;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CancionJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(ArtistaJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        List<Cancion> list = cancionJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        Cancion cancion = new Cancion();
        cancion.setTituloC("FEO");
        cancion.setDuracion(Integer.parseInt("21"));
        assertTrue(cancionJdbc.save(cancion));
    }

    @Test
    void update() {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        Cancion cancion = new Cancion();
        cancion.setTituloC("JuanPa");
        cancion.setDuracion(Integer.parseInt("09"));
        cancion.setId(1);
        assertTrue(cancionJdbc.update(cancion));
    }

    @Test
    void delete() {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        Cancion cancion = new Cancion();

        cancion.setId(5);
        assertTrue(cancionJdbc.delete(cancion));
    }

    @Test
    void findById() {
        CancionJdbc cancionJdbc = CancionJdbcImpl.getInstance();
        Cancion cancion = cancionJdbc.findById( 1 );
        assertNotNull(cancion);
        System.out.println(cancion);
    }
}