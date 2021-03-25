/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Modelo.Usuario;
import Vista.Administrador;
import Vista.RegistroAdministrador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author groya
 */
public class ControladorRegistroAdministrador implements ActionListener{
    
    private RegistroAdministrador vRegistroAdministrador;
    private Administrador vAdministrador;
    private Modelo modelo;
    

    ControladorRegistroAdministrador(RegistroAdministrador vRegistroAdministrador, Administrador vAdministrador, Modelo modelo) {
        this.vRegistroAdministrador = vRegistroAdministrador;
        this.vAdministrador = vAdministrador;
        this.modelo = modelo;
        
        vRegistroAdministrador.setControlador(this);
        vRegistroAdministrador.setModelo(modelo);
        
        
    }
    
    private void Registrar() {
        JTextField txtIdentificacion = vRegistroAdministrador.getTxtIdentificacion();
        JTextField txtContrasenia = vRegistroAdministrador.getTxtContrasenia();
        
        if(!(txtIdentificacion.getText().isEmpty()) && !(txtContrasenia.getText().isEmpty())){
            String id = txtIdentificacion.getText();
            String pass = txtContrasenia.getText();
            Usuario usuarioBD = null;
                try{
                    usuarioBD = modelo.consultarUsuario(id);
                }catch(NullPointerException ex){
                    System.out.println("Se puede ingresar al usuario.");
                }
            if (usuarioBD == null) {//Caso de que el usuario no se haya registrado aún
                usuarioBD = new Usuario(id, "Administrador", pass, 0);
                try {
                    modelo.insertarUsuario(usuarioBD);
                } catch (Exception ex) {
                    Logger.getLogger(ControladorRegistroAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Administrador agregado correctamente.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                Regresar();
            }

        }else{
            JOptionPane.showMessageDialog(null, "Campos vacíos, favor completar todos los campos.");
        }
    }

    private void Regresar() {
        this.vAdministrador.setVisible(true);
        
        this.vRegistroAdministrador.setVisible(false);
        this.vRegistroAdministrador.dispose();//Se liberan recursos al SO
    }
    

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Registrar":
                Registrar();
                break;
            case "Regresar":
                Regresar();
                break;
        }
    }


    
}
