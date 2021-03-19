/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.AdministradorBD;
import Modelo.Administrador;

/**
 *
 * @author jorge
 */
public class AdministradorDatos {
    
    private static AdministradorDatos mInstance;
    private final AdministradorBD sAdmin;
    
    public static AdministradorDatos getInstance() {
        if (mInstance == null) {
            mInstance = new AdministradorDatos();
        }
        return mInstance;
    }
 
    private AdministradorDatos() {
        sAdmin = new AdministradorBD();
    }
    
    /*************************INSERTAR ADMINISTRADOR*****************/
    public void insertarAdministrador(Administrador admin){
        sAdmin.insertarAdministrador(admin);
    }
    /*************************MODIFICAR ADMINISTRADOR*****************/
    public void modificarAdministrador(Administrador admin){
        sAdmin.modificarAdministrador(admin);
    }
    
    /*************************ELIMINAR ADMINISTRADOR*****************/
    public void eliminarAdministrador(String idAdmin){
        sAdmin.eliminarAdministrador(idAdmin);
    }
    
    
    
    
}
