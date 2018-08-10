
package com.eval.dao;
//prepared statement prepara la consulta para mandarla a la base de datos
//cuenta con datos fundamentales 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    
    private Connection miconexion;
    private static final String URL = "jdbc:mysql://localhost:3306/java18_eval";
    private static final String USER ="root";
    private static final String PASSWORD = "";
    
    public Connection getMiconexion(){
        return miconexion;
    }

    public void setMiconexion(Connection miconexion) {
        this.miconexion = miconexion;
    }
    
    //encerrar en un try y catch
    public void conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            miconexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("conexion realizada exitosamente");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en Class.fooName: "+ex);//Agregar el throws o catch
           //No lo necesitamos: Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en el DriverManager:"+ex);
        }
    }
    public void cerrarConexion(){
        
            try {
                if(miconexion.isClosed()==false){
                    if (miconexion!=null){
                        miconexion.close();
                }
                }
            } catch (SQLException ex) {
                //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error al cerrar: "+ ex);
            }
        }
    }
    

