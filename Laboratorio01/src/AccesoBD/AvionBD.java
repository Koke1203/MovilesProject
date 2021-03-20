/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Avion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author jorge
 */
public class AvionBD extends Servicio{

    private static final String INSERTAR_AVION = "{call INSERTARAVION(?,?,?,?,?,?,?)}";
    private static final String ELIMINAR_AVION = "{call ELIMINARAVION(?)}";
    private static final String MODIFICAR_AVION = "{call MODIFICARAVION(?,?,?,?,?,?,?)}";
    private static final String CONSULTAR_AVION = "{?=call CONSULTARAVION(?)}";
    private static final String LISTAR_AVIONES = "{?=call LISTARAVIONES()}";
    
    public void insertarAvion(Avion avion) throws Exception{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            } catch(GlobalException ex){
                java.util.logging.Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                java.util.logging.Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(INSERTAR_AVION);
            pstmt.setString(1,avion.getIdentificador());
            pstmt.setInt(2,avion.getAnio());
            pstmt.setString(3,avion.getMarca());
            pstmt.setString(4,avion.getModelo());
            pstmt.setInt(5,avion.getCantPasajeros());
            pstmt.setInt(6,avion.getCantFilas());
            pstmt.setInt(7,avion.getCantAsientos());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la inserción.");
                }catch(NoDataException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Llave primaria de la avión a ingresar ya exíste.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                Desconectar();
            }catch(SQLException e){
                try{
                    throw new GlobalException("Error: Estatutos invalidos o nulos.");
                }catch(GlobalException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarAvion(String identificador) throws GlobalException{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(ELIMINAR_AVION);
            pstmt.setString(1, identificador);
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la eliminación.");
                }catch(NoDataException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Avión a elimiar está ligada a otras tablas.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                Desconectar();
            }catch(SQLException e){
                try{
                    throw new GlobalException("Error: Estatutos invalidos o nulos.");
                }catch(GlobalException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarAvion(Avion avion){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(MODIFICAR_AVION);
            pstmt.setString(1,avion.getIdentificador());
            pstmt.setInt(2,avion.getAnio());
            pstmt.setString(3,avion.getMarca());
            pstmt.setString(4,avion.getModelo());
            pstmt.setInt(5,avion.getCantPasajeros());
            pstmt.setInt(6,avion.getCantFilas());
            pstmt.setInt(7,avion.getCantAsientos());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la modificación.");
                }catch(NoDataException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la modificación del avión.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try{
                if(pstmt != null){
                    pstmt.close();
                }
                Desconectar();
            }catch(SQLException e){
                try{
                    throw new GlobalException("Error: Estatutos invalidos o nulos.");
                }catch(GlobalException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<Avion> listarAviones(){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        ArrayList<Avion> coleccion = new ArrayList<>();
        Avion avion = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(LISTAR_AVIONES);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while(rs.next()){
                avion = new Avion(
                        rs.getString("idAvion"),
                        rs.getInt("anio"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("cantPasajeros"),
                        rs.getInt("cantFilas"),
                        rs.getInt("cantAsientos"));
                coleccion.add(avion);
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar el listado de las aviones.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                Desconectar();
            }catch(SQLException e){
                try{
                    throw new GlobalException("Error: Estatutos invalidos o nulos.");
                }catch(GlobalException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return coleccion;
    }
    
    public Avion consultarAvion(String identificador){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        Avion avion = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(CONSULTAR_AVION);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, identificador);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            avion = new Avion(
                    rs.getString("idAvion"),
                    rs.getInt("anio"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getInt("cantPasajeros"),
                    rs.getInt("cantFilas"),
                    rs.getInt("cantAsientos"));
            
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la consulta del avión.");
            }catch(GlobalException ex){
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }finally{
            try{
                if(rs != null){
                    rs.close();
                }
                if(pstmt != null){
                    pstmt.close();
                }
                Desconectar();
            }catch(SQLException e){
                try{
                    throw new GlobalException("Error: Estatutos invalidos o nulos.");
                }catch(GlobalException ex){
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return avion;
    }
}
