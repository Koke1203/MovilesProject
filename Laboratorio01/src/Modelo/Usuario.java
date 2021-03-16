/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;

/**
 *
 * @author groya
 */
public class Usuario {
    
    private static final HashMap<Integer, String> TIPO_USUARIO = new HashMap<Integer, String>();
    
    private String idUsuario;
    private String usuario;
    private String contrasenia;
    private int tipo;//0 : Administrador, 1 : Cliente
    
    private Usuario(){
        TIPO_USUARIO.put(0, "Administrador");
        TIPO_USUARIO.put(1, "Cliente");
    }
    
    public Usuario(String idUsuario, String usuario, String contrasenia, int tipo) {
        this();
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getTipoStr() {
        if(TIPO_USUARIO.containsKey(tipo)){
            return TIPO_USUARIO.get(tipo);
        }
        return "";
    }
    
}
