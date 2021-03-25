/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Administrador;
import Vista.Aviones;
import Vista.Login;
import Vista.RegistroAdministrador;
import Vista.Rutas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jorge
 */
public class ControladorAdministrador implements ActionListener {
    private Modelo modelo;
    private Administrador vAdministrador;
    
    private Login vLogin;
    private Rutas vRutas;
    private Aviones vAviones;
    //private Vuelos vVuelos;
    private RegistroAdministrador vRegistroAdministrador;
    private ControladorRegistroAdministrador cRegistroAdministrador;
    

    
    ControladorAdministrador(Administrador vAdministrador, Login vLogin, Modelo modelo) {
        this.modelo = modelo;
        this.vLogin = vLogin;
        this.vAdministrador = vAdministrador;
        this.vAdministrador.setControlador(this);
        this.vAdministrador.setModelo(modelo);
    }
    
    private void CerrarSesion() {
        this.vAdministrador.setVisible(false);
        this.vLogin.getControlador().Regresar();
        this.vAdministrador.dispose();
    }
    
    private void RegistrarAdministrador(){
        vRegistroAdministrador = new RegistroAdministrador();
        cRegistroAdministrador = new ControladorRegistroAdministrador(vRegistroAdministrador, vAdministrador, modelo);
        vAdministrador.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Vuelos":
                break;
            case "Rutas":
                break;
            case "Aviones":
                break;
            case "Registros":
                RegistrarAdministrador();
                break;
            case "Editar":
                break;
            case "Cerrar":
                CerrarSesion();
                break;
        }
    }


    
}
