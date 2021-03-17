/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prinicpal;

import Modelo.Ruta;
import Servicios.ServicioRuta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author groya
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Ruta ruta = new Ruta("001","aa","bb",23,1,"Martes",5,1);
            System.out.print(ruta.getHoraLlegada());
            
            ServicioRuta servicio = new ServicioRuta();
            ArrayList<Ruta> rutas = servicio.listarRutas();
            for(Ruta rutaI : rutas){
                System.out.println(rutaI);
            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
