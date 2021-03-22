/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Modelo;
import Modelo.Usuario;
import Vista.Principal;
import Vista.RegistroCliente;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author groya
 */
public class ControladorRegistroCliente implements ActionListener{
    
    private RegistroCliente vRegistro;
    private Principal vPrinicpal;
    private Modelo modelo;
    
    //Arreglo con JTextField de la vista registro
    private ArrayList<JTextField> camposTexto;
    
    ControladorRegistroCliente(RegistroCliente vRegistro, Principal vPrincipal, Modelo modelo) {
        this.modelo = modelo;
        this.vRegistro = vRegistro;
        this.vRegistro.setControlador(this);
        
        camposTexto = new ArrayList<>();
    }
    
    private void RegistrarCliente() {
        if(!camposRegistroVacios()){
            String idCliente = vRegistro.getTxtIdentificacion().getText();
            String nombre = vRegistro.getTxtNombre().getText();
            String primApellido = vRegistro.getTxtPrimerApellido().getText();
            String segundoApellido = vRegistro.getTxtSegundoApellido().getText();
            String fechaNac = vRegistro.getTxtNacimiento().getText();
            String correo = vRegistro.getTxtCorreo().getText();
            String direccion = vRegistro.getTxtDireccion().getText();
            String telefono = vRegistro.getTxtTelefono().getText();
            String celular = vRegistro.getTxtCelular().getText();
            String contrasenia = vRegistro.getTxtContrasenia().getText();
            
            Usuario usuario = new Usuario(idCliente, "usuario",contrasenia, 1);
            Cliente cliente = new Cliente(idCliente,nombre,primApellido,segundoApellido,fechaNac,correo, direccion, telefono, celular, contrasenia);
            
            try{
                modelo.insertarUsuario(usuario);
                modelo.insertarCliente(cliente);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
             JOptionPane.showMessageDialog(null, "Cliente registrado correctamente.");
        }else{
            //JOptionPane.showMessageDialog(null, "Campos *NO* VALIDOS");
        }
    }
    
    public boolean camposRegistroVacios(){
        camposTexto.clear();
        camposTexto = getComponentesTextField();
        Iterator<JTextField> iter = camposTexto.iterator();
        while (iter.hasNext()) {
            if(iter.next().getText().isEmpty()){
                return true;
            }
        }
       return false;
    }
    
    public ArrayList<JTextField> getComponentesTextField(){
        ArrayList<JTextField> jTxtComponentes = new ArrayList<>();
        for (Component component : vRegistro.getPanelRegistro().getComponents()) {
            if (component instanceof JTextField) {
                jTxtComponentes.add((JTextField) component);
            }
        }
        return jTxtComponentes;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch(ae.getActionCommand()){
            case "Registrar":
                RegistrarCliente();
                break;
        }
    }


    
}
