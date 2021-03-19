/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.ClienteBD;
import Modelo.Cliente;

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
        sCliente.insertarCliente(cliente);
    }
    /*************************MODIFICAR CLIENTE*****************/
    public void modificarCliente(Cliente cliente){
        sCliente.modificarCliente(cliente);
    }
    
    /*************************ELIMINAR CLIENTE*****************/
    public void eliminarCliente(String idCliente){
        sCliente.eliminarCliente(idCliente);
    }
    
}
