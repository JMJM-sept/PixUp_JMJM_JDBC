package org.jmjmdoc.pixup.gui.consola.model;

public class GeneroMusical extends Catalogo{
    private String descripcion;

    public GeneroMusical()
    {
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    @Override
    public String toString()
    {
        return "Género Musical{" +
                "Descripción='" + descripcion + '\'' +
                ", id=" + id +
                '}';
    }
}
