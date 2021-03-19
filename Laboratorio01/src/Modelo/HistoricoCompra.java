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
public class HistoricoCompra {
    
    private String idHistoricoCompra;
    private String idVuelo;
    private String idCliente;
    
    
    public HistoricoCompra(String idHistoricoCompra, String idVuelo, String idCliente) {
        this.idHistoricoCompra = idHistoricoCompra;
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
    }

    public String getIdHistoricoCompra() {
        return idHistoricoCompra;
    }

    public void setIdHistoricoCompra(String idHistoricoCompra) {
        this.idHistoricoCompra = idHistoricoCompra;
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    
    @Override
    public String toString() {
        return "HistoricoCompra{" + "idHistoricoCompra=" + idHistoricoCompra + ", idVuelo=" + idVuelo + ", idCliente=" + idCliente + '}';
    }
    
}
