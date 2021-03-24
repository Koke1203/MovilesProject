/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import Modelo.Modelo;
import Vista.VistaCliente;
import Vista.VistaPerfilCliente;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JTextField;

/**
 *
 * @author groya
 */
public class ControladorPerfilCliente implements ActionListener{
    
    private VistaPerfilCliente vPerfilCliente;
    private VistaCliente vCliente;
    private Modelo modelo;
    private Cliente cliente;
    
    //Arreglo con JTextField de la vista registro
    private ArrayList<JTextField> camposTexto;
    
    public ControladorPerfilCliente(VistaPerfilCliente vPerfilCliente, VistaCliente vCliente, Modelo modelo, Cliente cliente){
        this.vPerfilCliente = vPerfilCliente;
        this.vCliente = vCliente;
        this.modelo = modelo;
        this.cliente = cliente;
        
        this.vPerfilCliente.setControlador(this);
        this.vPerfilCliente.setModelo(modelo);
        
        MostrarDatosCliente();
    }
    
    private void MostrarDatosCliente(){
        vPerfilCliente.getTxtIdentificacion().setText(cliente.getIdCliente());
        vPerfilCliente.getTxtNombre().setText(cliente.getNombre());
        vPerfilCliente.getTxtPrimerApellido().setText(cliente.getPrimerApellido());
        vPerfilCliente.getTxtSegundoApellido().setText(cliente.getSegundoApellido());
        vPerfilCliente.getTxtCorreo().setText(cliente.getCorreo());
        vPerfilCliente.getTxtDireccion().setText(cliente.getDireccion());
        vPerfilCliente.getTxtTelefono().setText(cliente.getTelefono());
        vPerfilCliente.getTxtCelular().setText(cliente.getCelular());
        vPerfilCliente.getTxtContrasenia().setText(cliente.getContrasenia());
        try{
            String strDate = cliente.getFechaNacimiento();
            System.out.println(strDate);
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
            vPerfilCliente.getDateNacimiento().setDate(new Date());
        }catch(ParseException ex){
            System.out.println("Error al relizar la conversión de la fecha.");
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
        
        JDateChooser campoFechaNacimiento = vPerfilCliente.getDateNacimiento();
        if(campoFechaNacimiento.getDate() == null){
            return true;
        }
        
        
       return false;
    }
    
    public ArrayList<JTextField> getComponentesTextField(){
        ArrayList<JTextField> jTxtComponentes = new ArrayList<>();
        for (Component component : vPerfilCliente.getPanelPerfilCliente().getComponents()) {
            if (component instanceof JTextField) {
                jTxtComponentes.add((JTextField) component);
            }
        }
        return jTxtComponentes;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
    }
    
}
