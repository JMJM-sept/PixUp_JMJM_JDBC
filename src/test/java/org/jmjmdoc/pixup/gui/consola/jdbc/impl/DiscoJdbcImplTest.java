package org.jmjmdoc.pixup.gui.consola.jdbc.impl;

import org.jmjmdoc.pixup.gui.consola.jdbc.DiscoJdbc;
import org.jmjmdoc.pixup.gui.consola.model.Disco;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DiscoJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(DiscoJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        List<Disco> list = discoJdbc.findAll();
        assertNotNull(list);
        assertTrue(list.size() >= 1);
        list.stream().forEach(System.out::println);
    }

    @Test
    void save() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        Disco disco = new Disco();
        disco.setTitulo("fheipf");
        disco.setPrecio(Float.parseFloat("2.2"));
        disco.setExistencia(Integer.valueOf("3"));
        disco.setDescuento(Float.parseFloat("0.10"));
        disco.setFechaLan("dweeoie");
        disco.setImagen("fjgea");
        assertTrue(discoJdbc.save(disco));
    }

    @Test
    void update() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        Disco disco = new Disco();
        disco.setTitulo("hjkrn");
        disco.setPrecio(Float.parseFloat("32.2"));
        disco.setExistencia(Integer.valueOf("23"));
        disco.setDescuento(Float.parseFloat("0.20"));
        disco.setFechaLan("deredd");
        disco.setImagen("defrwf");
        disco.setId(1);
        assertTrue(discoJdbc.update(disco));
    }

    @Test
    void delete() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        Disco disco = new Disco();

        disco.setId(5);
        assertTrue(discoJdbc.delete(disco));
    }

    @Test
    void findById() {
        DiscoJdbc discoJdbc = DiscoJdbcImpl.getInstance();
        Disco disco = discoJdbc.findById( 1 );
        assertNotNull(disco);
        System.out.println(disco);
    }
}