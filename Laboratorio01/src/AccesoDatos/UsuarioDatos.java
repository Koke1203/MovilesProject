/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import AccesoBD.UsuarioBD;
import Excepciones.GlobalException;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class UsuarioDatos {
    
    private static UsuarioDatos mInstance;
    private final UsuarioBD sUsuario;
    
    public static UsuarioDatos getInstance() {
        if (mInstance == null) {
            mInstance = new UsuarioDatos();
        }
        return mInstance;
    }
 
    private UsuarioDatos() {
        sUsuario = new UsuarioBD();
    }
    
    /**
     * ***********************INSERTAR USUARIO****************
     */
    public void insertarUsuario(Usuario usuario) throws Exception {
        sUsuario.insertarUsuario(usuario);
    }

    /**
     * ***********************MODIFICAR USUARIO****************
     */
    public void modificarUsuario(Usuario usuario) {
        sUsuario.modificarUsuario(usuario);
    }

    /**
     * ***********************ELIMINAR USUARIO****************
     */
    public void eliminarAdministrador(String idUsuario) throws GlobalException {
        sUsuario.eliminarUsuario(idUsuario);
    }

    /**
     * ***********************LISTAR USUARIOS****************
     */
    public ArrayList<Usuario> listarUsuarios() {
        return sUsuario.listarUsuarios();
    }

    /**
     * ***********************CONSULTAR USUARIO****************
     */
    public Usuario consultarUsuario(String idUsuario) {
        return sUsuario.consultarUsuario(idUsuario);
    }
    
}
