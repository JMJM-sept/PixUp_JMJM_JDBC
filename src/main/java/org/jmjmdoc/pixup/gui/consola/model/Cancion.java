package org.jmjmdoc.pixup.gui.consola.model;

public class Cancion extends Catalogo {

    private String tituloC;
    private int duracion;

    public String getTituloC() {
        return tituloC;
    }

    public void setTituloC(String tituloC) {
        this.tituloC = tituloC;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion{" +
                ", id= " + id + '\'' +
                "tituloC= '" + tituloC + '\'' +
                ", duracion= " + duracion + " minutos" +
                '}';
    }
}
