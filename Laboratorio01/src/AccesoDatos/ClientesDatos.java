/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.ClienteBD;
import Excepciones.GlobalException;
import Modelo.Cliente;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class ClientesDatos {
    private static ClientesDatos mInstance;
    private final ClienteBD sCliente;
    
    public static ClientesDatos getInstance() {
        if (mInstance == null) {
            mInstance = new ClientesDatos();
        }
        return mInstance;
    }
 
    private ClientesDatos() {
        sCliente = new ClienteBD();
    }
    
    /*************************INSERTAR CLIENTE*****************/
    public void insertarCliente(Cliente cliente){
        try {
            sCliente.insertarCliente(cliente);
        } catch (Exception ex) {
            Logger.getLogger(ClientesDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*************************MODIFICAR CLIENTE*****************/
    public void modificarCliente(Cliente cliente){
        sCliente.modificarCliente(cliente);
    }
    
    /*************************ELIMINAR CLIENTE*****************/
    public void eliminarCliente(String idCliente){
        try {
            sCliente.eliminarCliente(idCliente);
        } catch (GlobalException ex) {
            Logger.getLogger(ClientesDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*************************LISTAR CLIENTES*****************/
    private ArrayList<Cliente> listarClientes(){
        return sCliente.listarClientes();
    }
    
    /*************************CONSULTAR CLIENTE*****************/
    private Cliente consultarCliente(String idCliente){
        return sCliente.consultarCliente(idCliente);
    }
}
