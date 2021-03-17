/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Ruta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.internal.OracleTypes;

/**
 *
 * @author groya
 */
public class ServicioRuta extends Servicio{
    
    //Llamadas a los procedimientos almacenados
    private static final String INSERTAR_RUTA = "{call INSERTARRUTA(?,?,?,?,?,?,?,?,?)}";
    private static final String ELIMINAR_RUTA = "{call ELIMINARRUTA(?)}";
    private static final String MODIFICAR_RUTA = "{call MODIFICARRUTA(?,?,?,?,?,?,?,?,?)}";
    private static final String CONSULTAR_RUTA = "{?=call CONSULTARRUTA(?)}";
    private static final String LISTAR_RUTAS = "{?=call LISTARRUTAS()}";
    
    public void insertarRuta(Ruta ruta) throws Exception{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            } catch(GlobalException ex){
                java.util.logging.Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                java.util.logging.Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(INSERTAR_RUTA);
            pstmt.setString(1,ruta.getIdRuta());
            pstmt.setString(2,ruta.getOrigen());
            pstmt.setString(3,ruta.getDestino());
            pstmt.setInt(4,ruta.getDuracionHoras());
            pstmt.setInt(5,ruta.getDuracionMinutos());
            pstmt.setString(6,ruta.getDiaSemana());
            pstmt.setInt(7,ruta.getHora());
            pstmt.setInt(8,ruta.getMinutos());
            pstmt.setString(9,ruta.getHoraLlegada());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la inserción.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Llave primaria de la ruta a ingresar ya exíste.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarRuta(String identificador) throws GlobalException{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(ELIMINAR_RUTA);
            pstmt.setString(1, identificador);
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la eliminación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Ruta a elimiar está ligada a otras tablas.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarRuta(Ruta ruta){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(MODIFICAR_RUTA);
            pstmt.setString(1,ruta.getIdRuta());
            pstmt.setString(2,ruta.getOrigen());
            pstmt.setString(3,ruta.getDestino());
            pstmt.setInt(4,ruta.getDuracionHoras());
            pstmt.setInt(5,ruta.getDuracionMinutos());
            pstmt.setString(6,ruta.getDiaSemana());
            pstmt.setInt(7,ruta.getHora());
            pstmt.setInt(8,ruta.getMinutos());
            pstmt.setString(9,ruta.getHoraLlegada());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la modificación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la modificación de la Ruta.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<Ruta> listarRutas(){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        ArrayList<Ruta> coleccion = new ArrayList<>();
        Ruta ruta = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(LISTAR_RUTAS);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while(rs.next()){
                ruta = new Ruta(
                        rs.getString("idRuta"),
                        rs.getString("origen"),
                        rs.getString("destino"),
                        rs.getInt("duracionHoras"),
                        rs.getInt("duracionMinutos"),
                        rs.getString("diaSemana"),
                        rs.getInt("hora"),
                        rs.getInt("minutos"),
                        rs.getString("horaLlegada"));
                coleccion.add(ruta);
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar el listado de las rutas.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return coleccion;
    }
    
    public Ruta consultarRuta(String identificador){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        Ruta ruta = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(CONSULTAR_RUTA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, identificador);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            ruta = new Ruta(
                rs.getString("idRuta"),
                rs.getString("origen"),
                rs.getString("destino"),
                rs.getInt("duracionHoras"),
                rs.getInt("duracionMinutos"),
                rs.getString("diaSemana"),
                rs.getInt("hora"),
                rs.getInt("minutos"),
                rs.getString("horaLlegada")
            );
            
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la consulta de la ruta.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioRuta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return ruta;
    }
}   
