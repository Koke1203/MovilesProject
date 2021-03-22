/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controlador.ControladorPrincipal;
import Modelo.Modelo;
import Vista.Principal;

/**
 *
 * @author groya
 */
public class Aplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Modelo modelo = new Modelo();
        Principal vPrincipal = new Principal();
        ControladorPrincipal controlador = new ControladorPrincipal(modelo, vPrincipal);
    }
    
}
