package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.DisqueraJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Disquera;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DisqueraJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        List<Disquera> list = disqueraJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setNombre("ijgiptr");
        assertTrue(disqueraJdbc.save(disquera));
    }

    @Test
    void update() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setNombre("jdoiendi");
        disquera.setId(1);
        assertTrue(disqueraJdbc.update(disquera));
    }

    @Test
    void delete() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        Disquera disquera = new Disquera();
        disquera.setId(5);
        assertTrue(disqueraJdbc.delete(disquera));
    }

    @Test
    void findById() {
        DisqueraJdbc disqueraJdbc = DisqueraJdbcImpl.getInstance();
        Disquera disquera = disqueraJdbc.findById( 1 );
        assertNotNull(disquera);
        System.out.println(disquera);
    }
}