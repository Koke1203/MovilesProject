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
public class DetalleVuelo {
    
    private String idVuelo;
    private String origen;
    private String destino;
    private String fechaSalida;
    private String fechaRegreso;
    private String hora;
    
    public DetalleVuelo(String idVuelo, String origen, String destino, String fechaSalida, String fechaRegreso, String hora) {
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.fechaRegreso = fechaRegreso;
        this.hora = hora;
    }


    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(String fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "DetalleVuelo{" + "idVuelo=" + idVuelo + ", origen=" + origen + ", destino=" + destino + ", fechaSalida=" + fechaSalida + ", fechaRegreso=" + fechaRegreso + ", hora=" + hora + '}';
    }
    
    
}
