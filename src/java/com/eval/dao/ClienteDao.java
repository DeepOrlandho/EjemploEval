package com.eval.dao;

import com.eval.modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDao extends Conexion {

    //atributos
    Cliente cliente0 = new Cliente();
    ResultSet clonarTabla; //copiar el resultado de un select}
    PreparedStatement ejecutarConsulta;

    Cliente cli = new Cliente();

    private String mensaje;
    private String codigoSql;

    public boolean GuardarCliente(Cliente datos) {
        System.out.println("llegój al DAO");
        boolean respuesta = false;
        try {
            this.conectar();
            this.codigoSql = "INSERT INTO cliente (id, nombre, apellido, nit) values(?,?,?,?)";
            this.ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, datos.getId());
            ejecutarConsulta.setString(2, datos.getNombre());
            ejecutarConsulta.setString(3, datos.getApellido());
            ejecutarConsulta.setInt(4, datos.getNit());

            ejecutarConsulta.executeUpdate();//Este ejecuta el código en la database

            respuesta = true;
            ejecutarConsulta.close();//Cerrando el proceso

        } catch (Exception e) {
            respuesta = false;
        } finally {
            this.cerrarConexion();
        }
        return respuesta;
    }

    public boolean modificarCliente(Cliente datos) {
        System.out.println("llegó al dao modificarCliente");
        boolean respuesta = false;
        try {
            this.conectar();
            this.codigoSql = "UPDATE cliente set nombre=?, apellido=?, nit=? WHERE id=?";
            this.ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(4, datos.getId());
            ejecutarConsulta.setString(1, datos.getNombre());
            ejecutarConsulta.setString(2, datos.getApellido());
            ejecutarConsulta.setInt(3, datos.getNit());

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

    public String eliminarCliente(Cliente datos) {
        try {
            this.conectar();
            codigoSql = "DELETE FROM cliente WHERE id=?";
            ejecutarConsulta = getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, datos.getId());

            ejecutarConsulta.executeUpdate();
            mensaje = "Eliminar";
        } catch (Exception ex) {
            System.out.println("Error en conexion: " + ex);
            mensaje = "Error, no se pudo eliminar el registro";
        }
        return mensaje;
    }

    //public Cliente buscarCodigo(Cliente dat) {public Cliente buscarCodigo(int codigo) {
    public Cliente buscarCodigo(int codigo) {
        //Busqueda por codigo, devuleve 1 ó ninugo.
        Cliente cli = new Cliente();//lo declare arriba para hacerlo global

        try {
            this.conectar();
            codigoSql = "select  nombre, apellido, nit, id from cliente where id=?";
            ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setInt(1, codigo);
            clonarTabla = ejecutarConsulta.executeQuery();

            if (clonarTabla.next()) {
                cli.setId(clonarTabla.getInt(4));
                cli.setNit(clonarTabla.getInt(3));
                cli.setApellido(clonarTabla.getString(2));
                //Se puede buscar por nombre de los campos o por posición
                cli.setNombre(clonarTabla.getString("nombre"));
            }

            //Cerrar el preparedstatement
            //Cerrar el ResultSet
            ejecutarConsulta.close();
            clonarTabla.close();

        } catch (Exception e) {
            System.out.println("Error en ClienteDao buscarCodigo: " + e);
        } finally {
            this.cerrarConexion();
        }
        return cli;
    }

    public Cliente buscarNombre(String nombre) {

        try {
            this.conectar();
            codigoSql = "SELECT * FROM cliente WHERE nombre =?";
            ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            ejecutarConsulta.setString(1, nombre);
            clonarTabla = ejecutarConsulta.executeQuery();

            if (clonarTabla.next()) {
                cli.setId(clonarTabla.getInt(1));
                cli.setNombre(clonarTabla.getString(2));
                cli.setApellido(clonarTabla.getNString(3));
                cli.setNit(clonarTabla.getInt(4));
            }

            ejecutarConsulta.close();
            clonarTabla.close();

        } catch (Exception e) {
            System.out.println("Erroe en mostrar clientes");
        } finally {
            this.cerrarConexion();
        }
        return cli;
    }

    public ArrayList<Cliente> mostrarClientes() {
        ArrayList<Cliente> cliente0 = new ArrayList();

        try {
            //Abrir la conexion
            this.conectar();
            codigoSql = "select * from cliente";
            ejecutarConsulta = this.getMiconexion().prepareStatement(codigoSql);
            //Esto lo recibe el resultSet(clonarTabla)
            clonarTabla = ejecutarConsulta.executeQuery();

            //Se posiciona en el primer registro el .next();
            while (clonarTabla.next()) {
                Cliente cli = new Cliente();
                cli.setId(clonarTabla.getInt("id"));
                cli.setNombre(clonarTabla.getString("nombre"));
                cli.setApellido(clonarTabla.getString("apellido"));
                cli.setNit(clonarTabla.getInt("nit"));

                cliente0.add(cli);
            }

        } catch (Exception e) {
            System.out.println("Error en mostrar clientes " + e);
        } finally {
            this.cerrarConexion();
        }
        return cliente0;
    }

}
