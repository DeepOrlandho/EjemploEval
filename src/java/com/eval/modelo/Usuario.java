
package com.eval.modelo;

public class Usuario {
    //Clase entidad o entity class es el reflejo de la dataBase 
    private int id;
    private String nombre;
    private String usuario;
    private String contrasenia;

    public Usuario() {
        //Estos no son tan necesarios
       /* this.id = 0;
        this.nombre=null;
        this.usuario=null;
        this.contrasenia=null;*/
    }

    public Usuario(int id, String nombre, String usuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", usuario=" + usuario + ", contrasenia=" + contrasenia + '}';
    }
    
    
    
    
    
}
