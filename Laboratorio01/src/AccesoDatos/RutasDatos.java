/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.RutaBD;
import Modelo.Ruta;

/**
 *
 * @author jorge
 */
public class RutasDatos {
    
    private static RutasDatos mInstance;
    private final RutaBD sRuta;
    
    
    public static RutasDatos getInstance() {
        if (mInstance == null) {
            mInstance = new RutasDatos();
        }
        return mInstance;
    }
 
    private RutasDatos() {
        sRuta = new RutaBD();
    }
    
    
        /*************************INSERTAR RUTA*****************/
    public void insertarRuta(Ruta ruta){
        sRuta.insertarRuta(ruta);
    }
    /*************************MODIFICAR RUTA*****************/
    public void modificarRuta(Ruta ruta){
        sRuta.modificarRuta(ruta);
    }
    
    /*************************ELIMINAR RUTA*****************/
    public void eliminarRuta(String idRuta){
        sRuta.eliminarRuta(idRuta);
    }
    
    
}
