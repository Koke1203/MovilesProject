/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Modelo;
import Vista.Login;
import Vista.VistaCliente;
import Vista.VistaPerfilCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jorge
 */
public class ControladorCliente implements ActionListener{
    
    private VistaCliente vCliente;
    private VistaPerfilCliente vPerfil;
    private ControladorPerfilCliente cPerfilCliente;
    private Login vLogin;
    private Modelo modelo;
    private Cliente cliente;

    public ControladorCliente(VistaCliente vCliente, Login vLogin, Modelo modelo, Cliente cliente) {
        this.vCliente = vCliente;
        this.vLogin = vLogin;
        this.modelo = modelo;
        this.cliente = cliente;
        
        this.vCliente.setControlador(this);
        this.vCliente.setModelo(modelo);
    }
    
    private void CerrarSesion() {
        this.vCliente.setVisible(false);
        this.vLogin.getControlador().Regresar();
        this.vCliente.dispose();
    }

    private void MostrarPerfil() {
        vPerfil = new VistaPerfilCliente();
        cPerfilCliente = new ControladorPerfilCliente(vPerfil, vCliente, modelo, cliente);
        vCliente.setVisible(false);
        vPerfil.setVisible(true);
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Cerrar":
                CerrarSesion();
                break;
            case "Perfil":
                MostrarPerfil();
                break;
        }
    }
    
}
