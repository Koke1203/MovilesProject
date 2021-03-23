/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Administrador;
import Vista.Login;
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

    
    ControladorAdministrador(Administrador vAdministrador, Login vLogin, Modelo modelo) {
        this.modelo = modelo;
        this.vLogin = vLogin;
        this.vAdministrador = vAdministrador;
        this.vAdministrador.setControlador(this);
        this.vAdministrador.setModelo(modelo);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
