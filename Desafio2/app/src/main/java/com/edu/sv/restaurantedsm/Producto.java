package com.edu.sv.restaurantedsm;

public class Producto {
    //DECLARACIÓN DE VARIABLES
    private String nombre;
    private String descripcion;
    private int imagenID;
    private int precio ;

    public final static Producto refrescos[]={
            new Producto("Jugo de Melon","Extracto de melon",R.drawable.melon,1),
            new Producto("Batido", "Batido de fresa y banano",R.drawable.batido,2),
            new Producto("Coca Cola","Tipica Coca Cola en envase de vidrio",R.drawable.cola,1)
    };

    public final static Producto platos[]={
            new Producto("Pupusas","Tipicas pupusas Salvadoreñas",R.drawable.pupusas,1),
            new Producto("Tamales","Deliciosos Tamales de Elote Salvadoreños",R.drawable.tamal,2),
            new Producto("Churrasco","Churrasco típico completo",R.drawable.churrasco,5)
    };

    public Producto() {
    }

    /**
     *CONSTRUCTOR CON PARÁMETROS
     */
    public Producto(String nombre, String descripcion, int imagenID, int precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenID = imagenID;
        this.precio = precio;
    }

    //GETTERS Y SETTERS
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenID() {
        return imagenID;
    }

    public void setImagenID(int imagenID) {
        this.imagenID = imagenID;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String toString() {
        return nombre;
    }

    public static Producto[] getCervezas() {
        return refrescos;
    }

    public static Producto[] getPizzas() {
        return platos;
    }
}
