package org.jmjmdoc.pixup.gui.consola.model;

public class Artista extends Catalogo {
    private String nombreArt;

    public Artista()
    {
    }

    public String getNombreArt()
    {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt)
    {
        this.nombreArt = nombreArt;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombreArt + '\'' +
                ", id=" + id +
                '}';
    }
}
