/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prinicpal;

import Servicios.Servicio;
import java.sql.SQLException;

/**
 *
 * @author groya
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servicio servicioBD = new Servicio();
        try {
            servicioBD.Conectar();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found exception!");
        } catch (SQLException ex) {
            System.out.println("SQL Exception!");
        }
    }
    
}
