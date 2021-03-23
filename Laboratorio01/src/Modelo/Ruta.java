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
public class Ruta {
 
    private String idRuta;
    private String origen;
    private String destino;
    private int duracionHoras;
    private int duracionMinutos;
    private String diaSemana;
    private int hora;
    private int minutos;
    private String horaLlegada;
    
    
    public Ruta(String idRuta, String origen, String destino, int duracionHoras, int duracionMinutos, String diaSemana, int hora, int minutos, String horaLlegada) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionHoras = duracionHoras;
        this.duracionMinutos = duracionMinutos;
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.minutos = minutos;
        this.horaLlegada = horaLlegada;
    }
    
        public Ruta(String idRuta, String origen, String destino, int duracionHoras, int duracionMinutos, String diaSemana, int hora, int minutos) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.duracionHoras = duracionHoras;
        this.duracionMinutos = duracionMinutos;
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.minutos = minutos;
        this.horaLlegada = calcularHoraLlegada(hora, minutos, duracionHoras, duracionMinutos);
    }
    
        public String getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(String idRuta) {
        this.idRuta = idRuta;
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

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public String getHoraLlegada() {
        return horaLlegada.length() > 0 ? horaLlegada : calcularHoraLlegada(hora, minutos, duracionHoras, duracionMinutos);
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
    
    //TODO Crear método que calcula la hora de llegada
    public String calcularHoraLlegada(int hora, int minutos, int durHor, int durMin) throws IllegalArgumentException{
        if(!esHoraValida(hora) || !sonMinutosValidos(minutos)){
            throw new IllegalArgumentException("Argumentos inválidos");
        }else{
            int numHoras = (minutos + durMin) / 60;
            int minLleg = (minutos + durMin) % 60;
            int horLleg = (hora + durHor + numHoras) % 24;
            String horaFormato = horLleg < 9 ? String.format("%02d",horLleg) : String.format("%2d",horLleg);
            String minutosFormato = minLleg < 9 ? String.format("%02d",minLleg) : String.format("%2d",minLleg);
            String salida = String.format("%s:%s", horaFormato, minutosFormato);
            return salida;
        }
    }
    
    public String obtenerHoraFormato(){
         String horaFormato = String.format("%2d",hora);
         String minutosFormato = hora < 9 ? String.format("%02d",hora) : String.format("%2d",hora);
        return String.format("%s:%s", horaFormato, minutosFormato);
    }
    
    
    //Formato de 24hrs -> 0 - 23
    private boolean esHoraValida(int hora){
        return (hora < 24) && (hora >= 0);
    }
    //60 minutos -> 0 - 59
    private boolean sonMinutosValidos(int minutos){
        return (minutos < 60) && (minutos >= 0);
    }
    
    @Override
    public String toString() {
        return "Ruta{" + "idRuta=" + idRuta + ", origen=" + origen + ", destino=" + destino + ", duracionHoras=" + duracionHoras + ", duracionMinutos=" + duracionMinutos + ", diaSemana=" + diaSemana + ", hora=" + hora + ", minutos=" + minutos + ", horaLlegada=" + horaLlegada + '}';
    }
    
    
}
