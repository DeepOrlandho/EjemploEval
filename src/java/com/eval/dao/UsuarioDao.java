package com.eval.dao;

import com.eval.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao extends Conexion {

    //atributos
    Usuario usu = new Usuario();
    ResultSet clonarTabla; //coiar el resultado de un select
    PreparedStatement ejecutarConsulta; //Permite ejecutar las consultas
    private String mensaje;
    private String codigoSql;

    //metodo para login
    public String iniciarSesion(Usuario datos) {
        try {
            this.mensaje = null;
            this.conectar();
            codigoSql = "select * from usuario WHERE usuario=? and contrasenia=MD5(?)";
            ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setString(1, datos.getUsuario());
            ejecutarConsulta.setString(2, datos.getContrasenia());

            System.out.println(codigoSql);

            clonarTabla = ejecutarConsulta.executeQuery();

            if (clonarTabla.next()) {
                mensaje = "Ingreso exitoso";
            } else {
                mensaje = "Ingrese datos correctos";
            }

        } catch (SQLException ex) {
            // Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: " + ex);
        } finally {
            this.cerrarConexion();
        }
        return mensaje;
    }

    public boolean ingresarUsuario(Usuario datos) {
        boolean respuesta = false;//Si esta falso no se guardó, si es true entonces se guardó.
        try {
            this.conectar();
            this.codigoSql = "INSERT INTO usuario(id, nombre, usuario, contrasenia) values(?,?,?,MD5(?))";
            this.ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            this.ejecutarConsulta.setInt(1, datos.getId());
            this.ejecutarConsulta.setString(2, datos.getNombre());
            ejecutarConsulta.setString(3, datos.getUsuario());
            ejecutarConsulta.setString(4, datos.getContrasenia());

            ejecutarConsulta.executeUpdate();//Este es el que ejecuta el código en la database.

            respuesta = true;

            ejecutarConsulta.close();//Cerrando el proceso

        } catch (Exception e) {
            respuesta = false;//no se guarda el proceso
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public boolean modificarUsuario(Usuario datos) {
        boolean respuesta = false;
        try {
            this.conectar();
            this.codigoSql = "UPDATE usuario SET (id, nombre, usuario, contrasenia) values(?,?,?,?)";
            this.ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            this.ejecutarConsulta.setInt(1, datos.getId());
            this.ejecutarConsulta.setString(2, datos.getNombre());
            this.ejecutarConsulta.setString(3, datos.getUsuario());
            this.ejecutarConsulta.setString(4, datos.getContrasenia());

            ejecutarConsulta.executeUpdate();
            respuesta = true;
            ejecutarConsulta.close();

        } catch (Exception e) {
            respuesta = false;
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public boolean eliminarUsuario(int id) {
        boolean respuesta = false;
        try {
            this.conectar();
            codigoSql = "DELETE FROM usuario WHERE id=?";
            ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, id);

            ejecutarConsulta.executeUpdate();
            respuesta = true;

            // mensaje= "Registro eliminado";
        } catch (SQLException ex) {

            respuesta = false;

            /*System.out.println("Error en conexion: "+ ex);
            mensaje = "error no se puedo eliminar el registro";*/
        } finally {
            this.cerrarConexion();
        }
        return respuesta;

        //return mensaje;
    }

    public ArrayList mostrarTodos() {
        ArrayList<Usuario> usuarios = new ArrayList();
        try {
            this.conectar();
            this.codigoSql = "select id, nombre, usuario, contrasenia from usuario";
            this.ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            //voy a trasladar el select al ResultSet
            this.clonarTabla = ejecutarConsulta.executeQuery();

            //recorre todos los registros de clonar tabla
            while (this.clonarTabla.next()) {
                Usuario usuario0 = new Usuario();
                usuario0.setId(this.clonarTabla.getInt("id"));
                usuario0.setNombre(this.clonarTabla.getString(2));
                usuario0.setUsuario(this.clonarTabla.getString(3));
                usuario0.setContrasenia(this.clonarTabla.getString(4));
                usuarios.add(usuario0);
            }

        } catch (Exception e) {
            System.out.println("Error en mostrar usuario" +e);
        } finally {
            this.cerrarConexion();
        }
        return usuarios;

    }
}
