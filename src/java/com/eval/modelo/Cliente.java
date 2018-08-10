
package com.eval.modelo;


public class Cliente {
    //Clase entidad o entity class que es el reflejo de la database
    private int id;
    private String nombre;
    private String apellido;
    private int nit;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, int nit) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nit = nit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", nit=" + nit + '}';
    }
    
    
    
    
}
