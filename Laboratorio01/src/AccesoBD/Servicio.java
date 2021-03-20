/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author groya
 */
public class Servicio {
    protected Connection conexion = null;
    
    public Servicio(){}
    
    protected void Conectar() throws ClassNotFoundException, SQLException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system","system");   
        System.out.println("Conexión exitosa!");
    }
    
    protected void Desconectar() throws SQLException{
        if(!conexion.isClosed()){
            conexion.close();
        }
    }
}
