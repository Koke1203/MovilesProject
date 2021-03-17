/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prinicpal;

import Modelo.Avion;
import Modelo.Cliente;
import Modelo.Ruta;
import Modelo.Usuario;
import Servicios.Servicio;
import Servicios.ServicioAvion;
import Servicios.ServicioCliente;
import Servicios.ServicioRuta;
import Servicios.ServicioUsuario;
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
            
            //Avion avion = new Avion("001",1990,"BOING","747",60,6,10);
            //ServicioAvion servicioAvion = new ServicioAvion();
            //servicioAvion.insertarAvion(avion);
            //avion.setMarca("AIRBUS");
            //servicioAvion.modificarAvion(avion);
            //Avion avion2 = servicioAvion.consultarAvion("001");
            //System.out.println(avion2);
            /*ArrayList<Avion> aviones = servicioAvion.listarAviones();
            for(Avion av : aviones){
                System.out.println(av);
            }*/
            //servicioAvion.eliminarAvion("001");
            
            
            //Cliente cliente = new Cliente("001","nombre","apellido1","apellido2","10/11/1995","correo","direccion","tel","cel","user","contrasenia");
            //ServicioCliente servicioCliente = new ServicioCliente();
            //servicioCliente.insertarCliente(cliente);
            //Cliente cliente2 = new Cliente("001","modif1","modf2","apellido2","10/11/1995","correo","modf3","tel","cel","user","contrasenia");
            //servicioCliente.modificarCliente(cliente2);
//            Cliente cliente3 = servicioCliente.consultarCliente("001");
//            System.out.println(cliente3);
//            System.out.println(cliente3.toStringSuper());
            /*ArrayList<Cliente> clientes = servicioCliente.listarClientes();
            for(Cliente cli:clientes){
            System.out.println(cli);
            System.out.println(cli.toStringSuper());
            }*/
            //servicioCliente.eliminarCliente("001");
            //Usuario usuario = new Usuario("001","usuario","12345",1);
            //ServicioUsuario servUsuario = new ServicioUsuario();
//            servUsuario.insertarUsuario(usuario);
//            usuario = new Usuario("001","user","6789",1);
//            servUsuario.modificarUsuario(usuario);
//            ArrayList<Usuario> usuarios = servUsuario.listarUsuarios();
//            for(Usuario user : usuarios){
//                System.out.println(user);
//            }
//            usuario = servUsuario.consultarUsuario("001");
//            System.out.println(usuario);
//            servUsuario.eliminarUsuario("001");
//            Ruta ruta = new Ruta("001","aa","bb",23,1,"Martes",5,1);
//            System.out.print(ruta.getHoraLlegada());
//            
//            ServicioRuta servicio = new ServicioRuta();
//            ArrayList<Ruta> rutas = servicio.listarRutas();
//            for(Ruta rutaI : rutas){
//                System.out.println(rutaI);
//            }
        } catch (Exception ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
