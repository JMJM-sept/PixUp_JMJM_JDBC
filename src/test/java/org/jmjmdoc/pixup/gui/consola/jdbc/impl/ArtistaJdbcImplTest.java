package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.ArtistaJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Artista;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArtistaJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(ArtistaJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        List<Artista> list;
        list = artistaJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        Artista artista = new Artista();
        artista.setNombreArt("MALILLA");
        assertTrue(artistaJdbc.save(artista));
    }

    @Test
    void update() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        Artista artista = new Artista();
        artista.setNombreArt("JuanPa");
        artista.setId(1);
        assertTrue(artistaJdbc.update(artista));
    }

    @Test
    void delete() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        Artista artista = new Artista();

        artista.setId(5);
        assertTrue(artistaJdbc.delete(artista));
    }

    @Test
    void findById() {
        ArtistaJdbc artistaJdbc = ArtistaJdbcImpl.getInstance();
        Artista artista = artistaJdbc.findById( 1 );
        assertNotNull(artista);
        System.out.println( artista );
    }
}