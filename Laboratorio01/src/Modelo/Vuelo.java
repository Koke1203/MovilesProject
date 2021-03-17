/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author groya
 */
public class Vuelo {
    
    private String idVuelo;
    private String fechaIda;
    private String fechaRegreso;
    private int cantidadPasajeros;
    private double precio;
    private Avion avion;
    private Ruta ruta;
    
    public Vuelo(String idVuelo, String fechaIda, String fechaRegreso, int cantidadPasajeros, double precio, Avion avion, Ruta ruta) {
        this.idVuelo = idVuelo;
        this.fechaIda = fechaIda;
        this.fechaRegreso = fechaRegreso;
        this.cantidadPasajeros = cantidadPasajeros;
        this.precio = precio;
        this.avion = avion;
        this.ruta = ruta;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(String fechaIda) {
        this.fechaIda = fechaIda;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }
    
}
