
package com.eval.controlador;

import com.eval.dao.ClienteDao;
import com.eval.modelo.Cliente;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControladorCli {
    ArrayList<Cliente> listaCliente = new ArrayList();
    Cliente cliente = new Cliente();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
    public void cargarClientes(){
        ClienteDao clientedao = new ClienteDao();
        listaCliente = clientedao.mostrarClientes();
        
    }
    
    public void guardarCliente(){
        System.out.println("llegó a guardar cliente");
        ClienteDao clientedao = new ClienteDao();
        try {
            clientedao.GuardarCliente(cliente);
        } catch (Exception e) {
            System.out.println("Error en controlador cliente: "+e);
        }
    }
    
    public void buscarCodigoCliente(Cliente datos){
        ClienteDao clientedao = new ClienteDao();
        try {
            cliente = clientedao.buscarCodigo(datos.getId());
            System.out.println("Nombre: "+cliente.getNombre());
        } catch (Exception e) {
            System.out.println("Error en controlador: buscarCodigoCliente" +e);
        }
        
    }
    
    public void modificarCliente(Cliente datos){
        System.out.println("llegó al controlador modificarClientes");
        ClienteDao clientedao = new ClienteDao();
        try {
            clientedao.modificarCliente(cliente);
        } catch (Exception e) {
            System.out.println("Error en controlador: modificarCliente" +e);
        }
    }
    
    public void eliminarCliente(Cliente datos){
        ClienteDao clientedao = new ClienteDao();
        try {
            clientedao.eliminarCliente(cliente);
            
        } catch (Exception e) {
            System.out.println("Error en controlador: eliminarClietne" +e);
        }
    }
    
    
}
