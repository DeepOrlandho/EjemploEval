package com.eval.dao;

import com.eval.modelo.Cliente;
import com.eval.modelo.Usuario;
import java.util.ArrayList;

public class pruebas {

    public static void main(String[] args) {

      /*Buscar por Id
        ClienteDao clientedao = new ClienteDao();
        Cliente recibir = new Cliente();
        recibir = clientedao.buscarCodigo(3);
        
        System.out.println(recibir.toString());
         */
      
      /* Buscar por Nombre
      ClienteDao clientedao = new ClienteDao();
      Cliente recibir = new Cliente();
      recibir = clientedao.buscarNombre("Anaite");
      System.out.println(recibir.toString());
      */
      
 /*El buscar con 
       ClienteDao clientedao = new ClienteDao();
       Cliente envia = new Cliente();
       envia.setId(2);
       Cliente recibir = new Cliente();
       
        System.out.println(recibir.toString());*/
 /*EliminarUsuario 
       UsuarioDao usuariodao = new UsuarioDao();
        System.out.println(usuariodao.eliminarUsuario(3));
         */
 /*Conexion conex = new Conexion();
        conex.conectar();
         */
 /*Elimina cliente 
       ClienteDao clientedao = new ClienteDao();
       Cliente cliente0 = new Cliente();
       cliente0.setId(1);
       String r =(clientedao.eliminarCliente(cliente0));
       System.out.println(r);
         */
 /*usu.setNombre("prueba");
       usu.setUsuario("123");
       usu.setContrasenia("123");*/
 /*usu.setUsuario("Orlandho");
       usu.setContrasenia("prueba123");
       usuariodao.iniciarSesion(usu);
         */
 /* para mostrar usuario
       UsuarioDao usuariodao = new UsuarioDao();
       ArrayList<Usuario> tabla = new ArrayList();
       tabla = usuariodao.mostrarTodos();
        for (int i = 0; i < tabla.size(); i++) {
            System.out.println("Codigo: "+ tabla.get(i).getId());
            System.out.println("Nombre: "+ tabla.get(i).getNombre());
            System.out.println("");
            
        }
         */
 /*     para mostrar varios datos
       ClienteDao clientedao = new ClienteDao();
       ArrayList<Cliente> tabla = new ArrayList();
       tabla = clientedao.mostrarClientes();
       for (int i = 0; i < tabla.size(); i++){
           System.out.println("Id: "+tabla.get(i).getId());
           System.out.println("Nombre: "+tabla.get(i).getNombre());
           System.out.println("Apellido: "+tabla.get(i).getApellido());
           System.out.println("nit: "+tabla.get(i).getNit());
       } */
    }

}
