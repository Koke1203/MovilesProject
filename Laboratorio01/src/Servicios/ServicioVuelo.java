/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Vuelo;
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
public class ServicioVuelo extends Servicio{
       //Llamadas a los procedimientos almacenados
    private static final String INSERTAR_VUELO = "{call INSERTARVUELO(?,?,?,?,?,?,?)}";
    private static final String ELIMINAR_VUELO = "{call ELIMINARVUELO(?)}";
    private static final String MODIFICAR_VUELO = "{call MODIFICARVUELO(?,?,?,?,?,?,?)}";
    private static final String CONSULTAR_VUELO = "{?=call CONSULTARVUELO(?)}";
    private static final String LISTAR_VUELOS = "{?=call LISTARVUELOS()}";
    
    public void insertarVuelo(Vuelo vuelo) throws Exception{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            } catch(GlobalException ex){
                java.util.logging.Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                java.util.logging.Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(INSERTAR_VUELO);
            pstmt.setString(1,vuelo.getIdVuelo());
            pstmt.setString(2,vuelo.getFechaIda());
            pstmt.setString(3,vuelo.getFechaRegreso());
            pstmt.setInt(4,vuelo.getCantidadPasajeros());
            pstmt.setDouble(5,vuelo.getPrecio());
            pstmt.setString(6,vuelo.getAvion());
            pstmt.setString(7,vuelo.getRuta());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la inserción.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Llave primaria del vuelo a ingresar ya exíste.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarVuelo(String identificador) throws GlobalException{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(ELIMINAR_VUELO);
            pstmt.setString(1, identificador);
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la eliminación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Vuelo a elimiar está ligada a otras tablas.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarVuelo(Vuelo vuelo){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(MODIFICAR_VUELO);
            pstmt.setString(1,vuelo.getIdVuelo());
            pstmt.setString(2,vuelo.getFechaIda());
            pstmt.setString(3,vuelo.getFechaRegreso());
            pstmt.setInt(4,vuelo.getCantidadPasajeros());
            pstmt.setDouble(5,vuelo.getPrecio());
            pstmt.setString(6,vuelo.getAvion());
            pstmt.setString(7,vuelo.getRuta());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la modificación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la modificación del Vuelo.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<Vuelo> listarVuelos(){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        ArrayList<Vuelo> coleccion = new ArrayList<>();
        Vuelo vuelo = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(LISTAR_VUELOS);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while(rs.next()){
                vuelo = new Vuelo(
                        rs.getString("idVuelo"),
                        rs.getString("fechaIda"),
                        rs.getString("fechaRegreso"),
                        rs.getInt("cantidadPasajeros"),
                        rs.getDouble("precio"),
                        rs.getString("Avion_idAvion"),
                        rs.getString("Ruta_idRuta"));
                coleccion.add(vuelo);
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar el listado de vuelos.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return coleccion;
    }
    
    public Vuelo consultarVuelo(String identificador){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        Vuelo vuelo = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(CONSULTAR_VUELO);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, identificador);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
                vuelo = new Vuelo(
                        rs.getString("idVuelo"),
                        rs.getString("fechaIda"),
                        rs.getString("fechaRegreso"),
                        rs.getInt("cantidadPasajeros"),
                        rs.getDouble("precio"),
                        rs.getString("Avion_idAvion"),
                        rs.getString("Ruta_idRuta"));
            
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la consulta del vuelo.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioVuelo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return vuelo;
    }
}
