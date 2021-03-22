/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.Principal;
import Vista.Login;
import Vista.RegistroCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author groya
 */
public class ControladorPrincipal implements ActionListener{
    
    private Modelo modelo;
    private Principal vPrincipal;
    private Login vLogin;
    private ControladorLogin cLogin;
    private RegistroCliente vRegistro;
    private ControladorRegistroCliente cRegistroCliente;
    
    public ControladorPrincipal(Modelo modelo, Principal vPrincipal){
        this.modelo = modelo;
        this.vPrincipal = vPrincipal;
        this.vPrincipal.setControlador(this);
    }
    
    public void InciarSesion(){
        vLogin = new Login();
        cLogin = new ControladorLogin(vLogin, vPrincipal, modelo);
        
        this.vPrincipal.setVisible(false);
    }
    
    private void Registrarse() {
        vRegistro = new RegistroCliente();
        cRegistroCliente = new ControladorRegistroCliente(vRegistro, vPrincipal, modelo);
        
        this.vPrincipal.setVisible(false);
    }
    
        @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "IniciarSesion":
                this.InciarSesion();
                break;
            case "Registrarse":
                this.Registrarse();
                break;
                
        }
    }   
    
}
