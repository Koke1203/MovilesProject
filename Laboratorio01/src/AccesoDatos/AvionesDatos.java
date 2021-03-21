/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.AvionBD;
import Excepciones.GlobalException;
import Modelo.Avion;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class AvionesDatos {
    private static AvionesDatos mInstance;
    private final AvionBD sAvion;
    
    public static AvionesDatos getInstance() {
        if (mInstance == null) {
            mInstance = new AvionesDatos();
        }
        return mInstance;
    }
 
    private AvionesDatos() {
        sAvion = new AvionBD();
    }
    
    /**
     * ***********************INSERTAR AVION****************
     */
    public void insertarAvion(Avion avion) throws Exception {
        sAvion.insertarAvion(avion);
    }

    /**
     * ***********************MODIFICAR AVION****************
     */
    public void modificarAvion(Avion avion) {
        sAvion.modificarAvion(avion);
    }

    /**
     * ***********************ELIMINAR AVION****************
     */
    public void eliminarAvion(String idAvion) throws GlobalException {
        sAvion.eliminarAvion(idAvion);
    }

    /**
     * ***********************LISTAR AVIONES****************
     */
    public ArrayList<Avion> listarAviones() {
        return sAvion.listarAviones();
    }

    /**
     * ***********************CONSULTAR AVION****************
     */
    public Avion consultarAvion(String idAvion) {
        return sAvion.consultarAvion(idAvion);
    }
    
    
}
