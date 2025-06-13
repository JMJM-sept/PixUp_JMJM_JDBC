package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.GeneroMusicalJdbc;
import org.jmjmdoc.pixup.gui.consola.model.GeneroMusical;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeneroMusicalJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(ArtistaJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        List<GeneroMusical> list = generoMusicalJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        GeneroMusical generoMusical = new GeneroMusical();
        generoMusical.setDescripcion("kmprmf");
        assertTrue(generoMusicalJdbc.save(generoMusical));
    }

    @Test
    void update() {
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        GeneroMusical generoMusical = new GeneroMusical();
        generoMusical.setDescripcion("gtrormoer");
        generoMusical.setId(1);
        assertTrue(generoMusicalJdbc.update(generoMusical));
    }

    @Test
    void delete() {
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        GeneroMusical generoMusical = new GeneroMusical();

        generoMusical.setId(5);
        assertTrue(generoMusicalJdbc.delete(generoMusical));
    }

    @Test
    void findById() {
        GeneroMusicalJdbc generoMusicalJdbc = GeneroMusicalJdbcImpl.getInstance();
        GeneroMusical generoMusical = generoMusicalJdbc.findById( 1 );
        assertNotNull(generoMusical);
        System.out.println(generoMusical);
    }
}