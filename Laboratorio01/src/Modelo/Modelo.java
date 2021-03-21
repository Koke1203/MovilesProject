/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import AccesoDatos.*;
import Excepciones.GlobalException;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author groya
 */
public class Modelo extends Observable{
    
    private String accionAvion;
    private String accionRuta;
    private String accionVuelo;
    private String accionUsuario;
    private String accionCliente;
    private String accionHistorico;
    
    public Modelo(){
        this.accionAvion = "";
        this.accionRuta="";
        this.accionVuelo = "";
        this.accionUsuario="";
        this.accionCliente="";
        this.accionHistorico="";
    }
    
    public String getAccionAvion() {
        return accionAvion;
    }

    public void setAccionAvion(String accionAvion) {
        this.accionAvion = accionAvion;
    }

    public String getAccionRuta() {
        return accionRuta;
    }

    public void setAccionRuta(String accionRuta) {
        this.accionRuta = accionRuta;
    }

    public String getAccionVuelo() {
        return accionVuelo;
    }

    public void setAccionVuelo(String accionVuelo) {
        this.accionVuelo = accionVuelo;
    }

    public String getAccionUsuario() {
        return accionUsuario;
    }

    public void setAccionUsuario(String accionUsuario) {
        this.accionUsuario = accionUsuario;
    }

    public String getAccionCliente() {
        return accionCliente;
    }

    public void setAccionCliente(String accionCliente) {
        this.accionCliente = accionCliente;
    }

    public String getAccionHistorico() {
        return accionHistorico;
    }

    public void setAccionHistorico(String accionHistorico) {
        this.accionHistorico = accionHistorico;
    }
    
    
    /*
     * ***************************AVIONES****************************
     */
    
    public void insertarAvion(Avion avion) throws Exception{
        AvionesDatos.getInstance().insertarAvion(avion);
        setAccionAvion("insertarAvion");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarAvion(Avion avion){
        AvionesDatos.getInstance().modificarAvion(avion);
        setAccionAvion("modificarAvion");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarAvion(String idAvion) throws GlobalException{
        AvionesDatos.getInstance().eliminarAvion(idAvion);
        setAccionAvion("eliminarAvion");
        this.setChanged();
        this.notifyObservers();
    }
    
    public Avion consultarAvion(String idAvion){
        return AvionesDatos.getInstance().consultarAvion(idAvion);
    }
    
    public ArrayList<Avion> listarAviones(){
        return AvionesDatos.getInstance().listarAviones();
    }
    
    
    /*
     * ***************************RUTAS****************************
     */
    
    public void insertarRuta(Ruta ruta) throws Exception{
        RutasDatos.getInstance().insertarRuta(ruta);
        setAccionRuta("insertarRuta");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarRuta(Ruta ruta){
        RutasDatos.getInstance().modificarRuta(ruta);
        setAccionRuta("modificarRuta");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarRuta(String idRuta) throws GlobalException{
        RutasDatos.getInstance().eliminarRuta(idRuta);
        setAccionRuta("eliminarRuta");
        this.setChanged();
        this.notifyObservers();
    }
    
    public Ruta consultarRuta(String idRuta){
        return RutasDatos.getInstance().consultarRuta(idRuta);
    }
    
    public ArrayList<Ruta> listarRutas(){
        return RutasDatos.getInstance().listarRutas();
    }
    
     /*
     * ***************************VUELOS****************************
     */
    
    public void insertarVuelo(Vuelo vuelo) throws Exception{
        VuelosDatos.getInstance().insertarVuelo(vuelo);
        setAccionVuelo("insertarVuelo");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarVuelo(Vuelo ruta){
        VuelosDatos.getInstance().modificarVuelo(ruta);
        setAccionVuelo("modificarVuelo");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarVuelo(String idVuelo) throws GlobalException{
        VuelosDatos.getInstance().eliminarVuelo(idVuelo);
        setAccionVuelo("eliminarVuelo");
        this.setChanged();
        this.notifyObservers();
    }
    
    public Vuelo consultarVuelo(String idVuelo){
        return VuelosDatos.getInstance().conultarVuelo(idVuelo);
    }
    
    public ArrayList<Vuelo> listarVuelos(){
        return VuelosDatos.getInstance().listarVuelos();
    }
    
    /*
     * ***************************USUARIOS****************************
     */
    
    public void insertarUsuario(Usuario usuario) throws Exception{
        UsuarioDatos.getInstance().insertarUsuario(usuario);
        setAccionUsuario("insertarUsuario");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarUsuario(Usuario usuario){
        UsuarioDatos.getInstance().modificarUsuario(usuario);
        setAccionUsuario("modificarUsuario");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarUsuario(String idUsuario) throws GlobalException{
        UsuarioDatos.getInstance().eliminarUsuario(idUsuario);
        setAccionUsuario("eliminarUsuario");
        this.setChanged();
        this.notifyObservers();
    }
    
    public Usuario consultarUsuario(String idUsuario){
        return UsuarioDatos.getInstance().consultarUsuario(idUsuario);
    }
    
    public ArrayList<Usuario> listarUsuarios(){
        return UsuarioDatos.getInstance().listarUsuarios();
    }
    
    /*
     * ***************************CLIENTES****************************
    */
    
    public void insertarCliente(Cliente cliente) throws Exception{
        ClientesDatos.getInstance().insertarCliente(cliente);
        setAccionCliente("insertarCliente");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarCliente(Cliente cliente){
        ClientesDatos.getInstance().modificarCliente(cliente);
        setAccionCliente("modificarCliente");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarCliente(String idCliente) throws GlobalException{
        ClientesDatos.getInstance().eliminarCliente(idCliente);
        setAccionCliente("eliminarCliente");
        this.setChanged();
        this.notifyObservers();
    }
    
    public Cliente consultarCliente(String idCliente){
        return ClientesDatos.getInstance().consultarCliente(idCliente);
    }
    
    public ArrayList<Cliente> listarClientes(){
        return ClientesDatos.getInstance().listarClientes();
    }
    
    /*
     * ***************************HISTORICO COMPRAS****************************
    */
    
    public void insertarHistoricoCompra(HistoricoCompra historicoCompra) throws Exception{
        HistoricoCompraDatos.getInstance().insertarHistoricoCompra(historicoCompra);
        setAccionHistorico("insertarHistorico");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void modificarHistoricoCompra(HistoricoCompra historicoCompra){
        HistoricoCompraDatos.getInstance().modificarHistoricoCompra(historicoCompra);
        setAccionHistorico("modificarHistorico");
        this.setChanged();
        this.notifyObservers();
    }
    
    public void eliminarHistoricoCompra(String idHistoricoCompra) throws GlobalException{
        HistoricoCompraDatos.getInstance().eliminarHistoricoCompra(idHistoricoCompra);
        setAccionHistorico("eliminarHistorico");
        this.setChanged();
        this.notifyObservers();
    }
    
    public HistoricoCompra consultarHistoricoCompra(String idHistoricoCompra){
        return HistoricoCompraDatos.getInstance().consultarHistoricoCompra(idHistoricoCompra);
    }
    
    public ArrayList<HistoricoCompra> listarHistoricoCompras(){
        return HistoricoCompraDatos.getInstance().listarHistoricosCompra();
    }
    
}
