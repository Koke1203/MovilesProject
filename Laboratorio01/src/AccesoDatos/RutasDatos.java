/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.RutaBD;
import Excepciones.GlobalException;
import Modelo.Ruta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
            sRuta.insertarRuta(ruta);
        } catch (Exception ex) {
            Logger.getLogger(RutasDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*************************MODIFICAR RUTA*****************/
    public void modificarRuta(Ruta ruta){
        sRuta.modificarRuta(ruta);
    }
    
    /*************************ELIMINAR RUTA*****************/
    public void eliminarRuta(String idRuta){
        try {
            sRuta.eliminarRuta(idRuta);
        } catch (GlobalException ex) {
            Logger.getLogger(RutasDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*************************LISTAR RUTAS*****************/
    public ArrayList<Ruta> listarRutas(){
        return sRuta.listarRutas();
    }
    
    /*************************CONSULTAR RUTA*****************/
    public Ruta consultarRuta(String idRuta){
        return sRuta.consultarRuta(idRuta);
    }
    
}
