/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.HistoricoCompraBD;
import Excepciones.GlobalException;
import Modelo.HistoricoCompra;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author groya
 */
public class HistoricoCompraDatos {
    private static HistoricoCompraDatos mInstance;
    private final HistoricoCompraBD sHistoricoCompra;
    
    
    public static HistoricoCompraDatos getInstance() {
        if (mInstance == null) {
            mInstance = new HistoricoCompraDatos();
        }
        return mInstance;
    }
 
    private HistoricoCompraDatos() {
        sHistoricoCompra = new HistoricoCompraBD();
    }
    
    
    /**
     * ***********************INSERTAR HISTORICO COMPRA****************
     */
    public void insertarHistoricoCompra(HistoricoCompra historicoCompra) throws Exception {
        sHistoricoCompra.insertarHistoricoCompra(historicoCompra);
    }

    /**
     * ***********************MODIFICAR HISTORICO COMPRA****************
     */
    public void modificarRuta(HistoricoCompra historicoCompra) {
        sHistoricoCompra.modificarHistoricoCompra(historicoCompra);
    }

    /**
     * ***********************ELIMINAR HISTORICO COMPRA****************
     */
    public void eliminarHistoricoCompra(String idHistoricoCompra) throws GlobalException {
        sHistoricoCompra.eliminarHistoricoCompra(idHistoricoCompra);
    }

    /**
     * ***********************LISTAR HISTORICOS DE COMPRA****************
     */
    public ArrayList<HistoricoCompra> listarHistoricosCompra() {
        return sHistoricoCompra.listarHistoricoCompras();
    }

    /**
     * ***********************CONSULTAR HISTORICO COMPRA****************
     */
    public HistoricoCompra consultarRuta(String idHistoricoCompra) {
        return sHistoricoCompra.consultarHistoricoCompra(idHistoricoCompra);
    }
}
