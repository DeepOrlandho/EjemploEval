
package com.eval.controlador;

import com.eval.dao.UsuarioDao;
import com.eval.modelo.Usuario;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ControladorUsuario {
    ArrayList<Usuario> listaUsuario = new ArrayList();

    public ArrayList<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
    public void cargarUsuarios(){
        UsuarioDao usuariodao = new UsuarioDao();
        listaUsuario = usuariodao.mostrarTodos();
    }
    
    
    
}
