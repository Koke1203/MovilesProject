/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.HistoricoCompra;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author groya
 */
public class ServicioHistoricoCompra extends Servicio{
    //Llamadas a los procedimientos almacenados
    private static final String INSERTAR_HISTORICOCOMPRA = "{call INSERTARHISTORICOCOMPRA(?,?,?)}";
    private static final String ELIMINAR_HISTORICOCOMPRA = "{call ELIMINARHISTORICOCOMPRA(?)}";
    private static final String MODIFICAR_HISTORICOCOMPRA = "{call MODIFICARHISTORICOCOMPRA(?,?,?)}";
    private static final String CONSULTAR_HISTORICOCOMPRA = "{?=call CONSULTARHISTORICOCOMPRA(?)}";
    private static final String LISTAR_HISTORICOCOMPRAS = "{?=call LISTARHISTORICOCOMPRA()}";
    
    public void insertarHistoricoCompra(HistoricoCompra historicoCompra) throws Exception{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            } catch(GlobalException ex){
                java.util.logging.Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                java.util.logging.Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(INSERTAR_HISTORICOCOMPRA);
            pstmt.setString(1,historicoCompra.getIdHistoricoCompra());
            pstmt.setString(2,historicoCompra.getIdVuelo());
            pstmt.setString(3,historicoCompra.getIdCliente());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la inserción.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Llave primaria del historico de compra a ingresar ya exíste.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarHistoricoCompra(String identificador) throws GlobalException{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(ELIMINAR_HISTORICOCOMPRA);
            pstmt.setString(1, identificador);
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la eliminación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Historico de compra a elimiar está ligado a otras tablas.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarHistoricoCompra(HistoricoCompra historicoCompra){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(MODIFICAR_HISTORICOCOMPRA);
            pstmt.setString(1,historicoCompra.getIdHistoricoCompra());
            pstmt.setString(2,historicoCompra.getIdVuelo());
            pstmt.setString(3,historicoCompra.getIdCliente());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la modificación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la modificación del historico de compra.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<HistoricoCompra> listarHistoricoCompras(){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        ArrayList<HistoricoCompra> coleccion = new ArrayList<>();
        HistoricoCompra historicoCompra = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(LISTAR_HISTORICOCOMPRAS);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while(rs.next()){
                historicoCompra = new HistoricoCompra(
                        rs.getString("IDHISTORICOCOMPRA"),
                        rs.getString("VUELO_IDVUELO"),
                        rs.getString("CLIENTE_IDCLIENTE"));
                coleccion.add(historicoCompra);
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar el listado de los historicos de compra.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return coleccion;
    }
    
    public HistoricoCompra consultarHistoricoCompra(String identificador){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        HistoricoCompra historicoCompra = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(CONSULTAR_HISTORICOCOMPRA);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, identificador);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            historicoCompra = new HistoricoCompra(
                    rs.getString("IDHISTORICOCOMPRA"),
                    rs.getString("VUELO_IDVUELO"),
                    rs.getString("CLIENTE_IDCLIENTE"));
            
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la consulta del historico de compra.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioHistoricoCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return historicoCompra;
    }
}
