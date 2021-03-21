/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.VueloBD;
import Excepciones.GlobalException;
import Modelo.Vuelo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class VuelosDatos {

    private static VuelosDatos mVuelo;
    private final VueloBD sVuelo;

    public static VuelosDatos getInstance() {
        if (mVuelo == null) {
            mVuelo = new VuelosDatos();
        }
        return mVuelo;
    }

    private VuelosDatos() {
        sVuelo = new VueloBD();
    }
    
    
    /**
     * ***********************INSERTAR VUELO****************
     */
    public void insertarVuelo(Vuelo vuelo) throws Exception {
        sVuelo.insertarVuelo(vuelo);
    }

    /**
     * ***********************MODIFICAR VUELO****************
     */
    public void modificarVuelo(Vuelo vuelo) {
        sVuelo.modificarVuelo(vuelo);
    }

    /**
     * ***********************ELIMINAR VUELO****************
     */
    public void eliminarVuelo(String idVuelo) throws GlobalException {
        sVuelo.eliminarVuelo(idVuelo);
    }

    /**
     * ***********************LISTAR VUELOS****************
     */
    public ArrayList<Vuelo> listarVuelos() {
        return sVuelo.listarVuelos();
    }

    /**
     * ***********************CONSULTAR VUELO****************
     */
    public Vuelo conultarVuelo(String idVuelo) {
        return sVuelo.consultarVuelo(idVuelo);
    }

}
