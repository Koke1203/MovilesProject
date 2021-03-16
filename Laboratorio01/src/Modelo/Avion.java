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
public class Avion {
    
    private String identificador;
    private int anio;
    private String marca;
    private String modelo;
    private int cantPasajeros;
    private int cantFilas;
    private int cantAsientos;
    
    public Avion() {
    }
    
    public Avion(String identificador, int anio, String marca, String modelo, int cantPasajeros, int cantFilas, int cantAsientos) {
        this.identificador = identificador;
        this.anio = anio;
        this.marca = marca;
        this.modelo = modelo;
        this.cantPasajeros = cantPasajeros;
        this.cantFilas = cantFilas;
        this.cantAsientos = cantAsientos;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantPasajeros() {
        return cantPasajeros;
    }

    public void setCantPasajeros(int cantPasajeros) {
        this.cantPasajeros = cantPasajeros;
    }

    public int getCantFilas() {
        return cantFilas;
    }

    public void setCantFilas(int cantFilas) {
        this.cantFilas = cantFilas;
    }

    public int getCantAsientos() {
        return cantAsientos;
    }

    public void setCantAsientos(int cantAsientos) {
        this.cantAsientos = cantAsientos;
    } 
}
