package org.jmjmdoc.pixup.gui.consola.model;

public abstract class Catalogo
{
    protected Integer id;

    public Catalogo()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Catalogo{" +
                "id=" + id +
                '}';
    }
}
