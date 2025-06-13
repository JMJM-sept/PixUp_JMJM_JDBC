package org.jmjmdoc.pixup.gui.consola.model;

public class Disco extends Catalogo {
    private String titulo;
    private float precio;
    private Integer existencia;
    private   float descuento;
    private String fechaLan;
    private   String imagen;

    public Disco()
    {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrecio() {
        return (int) precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Integer getExistencia() {
        return existencia;
    }

    public void setExistencia(Integer existencia) {
        this.existencia = existencia;
    }

    public int getDescuento() {
        return (int) descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getFechaLan() {
        return fechaLan;
    }

    public void setFechaLan(String fechaLan) {
        this.fechaLan = fechaLan;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Disco{" +
                ", id= " + id + '\'' +
                "titulo= '" + titulo + '\'' +
                ", precio= " + precio +
                ", existencia= " + existencia +
                ", descuento= " + descuento +
                ", fechaLan= '" + fechaLan + '\'' +
                ", imagen= '" + imagen + '\'' +
                '}';
    }
}
