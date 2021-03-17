/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Cliente;
import Modelo.Usuario;
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
public class ServicioCliente extends Servicio{
    
    //Llamadas a los procedimientos almacenados
    private static final String INSERTAR_CLIENTE = "{call INSERTARCLIENTE(?,?,?,?,?,?,?,?,?)}";
    private static final String ELIMINAR_CLIENTE = "{call ELIMINARCLIENTE(?)}";
    private static final String MODIFICAR_CLIENTE = "{call MODIFICARCLIENTE(?,?,?,?,?,?,?,?,?)}";
    private static final String CONSULTAR_CLIENTE = "{?=call CONSULTARCLIENTE(?)}";
    private static final String LISTAR_CLIENTES = "{?=call LISTARCLIENTES()}";
    
    public void insertarCliente(Cliente cliente) throws Exception{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            } catch(GlobalException ex){
                java.util.logging.Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                java.util.logging.Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        try{
            //ServicioUsuario servUsuario = new ServicioUsuario();
            //servUsuario.insertarUsuario(cliente);
            
            pstmt = conexion.prepareCall(INSERTAR_CLIENTE);
            pstmt.setString(1,cliente.getIdCliente());
            pstmt.setString(2,cliente.getNombre());
            pstmt.setString(3,cliente.getPrimerApellido());
            pstmt.setString(4,cliente.getSegundoApellido());
            pstmt.setString(5,cliente.getFechaNacimiento());
            pstmt.setString(6,cliente.getCorreo());
            pstmt.setString(7,cliente.getDireccion());
            pstmt.setString(8,cliente.getTelefono());
            pstmt.setString(9,cliente.getCelular());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la inserción.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            } 
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Llave primaria del cliente a ingresar ya exíste.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarCliente(String identificador) throws GlobalException{
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(ELIMINAR_CLIENTE);
            pstmt.setString(1, identificador);
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la eliminación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Cliente a elimiar está ligado a otras tablas.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarCliente(Cliente cliente){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;
        
        try{
            pstmt = conexion.prepareCall(MODIFICAR_CLIENTE);
            pstmt.setString(1,cliente.getIdCliente());
            pstmt.setString(2,cliente.getNombre());
            pstmt.setString(3,cliente.getPrimerApellido());
            pstmt.setString(4,cliente.getSegundoApellido());
            pstmt.setString(5,cliente.getFechaNacimiento());
            pstmt.setString(6,cliente.getCorreo());
            pstmt.setString(7,cliente.getDireccion());
            pstmt.setString(8,cliente.getTelefono());
            pstmt.setString(9,cliente.getCelular());
            
            boolean resultado = pstmt.execute();
            if(resultado){
                try{
                    throw new NoDataException("Error: No se realizó la modificación.");
                }catch(NoDataException ex){
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la modificación del cliente.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public ArrayList<Cliente> listarClientes(){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        ArrayList<Cliente> coleccion = new ArrayList<>();
        Cliente cliente = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(LISTAR_CLIENTES);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            while(rs.next()){
                cliente = new Cliente(
                    rs.getString("idCliente"),
                    rs.getString("nombre"),
                    rs.getString("primerApellido"),
                    rs.getString("segundoApellido"),
                    rs.getString("fechaNac"),
                    rs.getString("correo"),
                    rs.getString("direccion"),
                    rs.getString("telefono"),
                    rs.getString("celular")
                );
                coleccion.add(cliente);
            }
            
            ServicioUsuario servUsuario = new ServicioUsuario();
            coleccion.forEach((_item) -> {
                Usuario consulta = servUsuario.consultarUsuario(_item.getIdCliente());
                _item.setUsuario(consulta.getUsuario());
                _item.setContrasenia(consulta.getContrasenia());
            });
            
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar el listado de los clientes.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return coleccion;
    }
    
    public Cliente consultarCliente(String identificador){
        try{
            Conectar();
        }catch(ClassNotFoundException e){
            try{
                throw new GlobalException("Error: Driver para establecer conexión, no se ha encontrado.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(SQLException e){
            try{
                throw new NoDataException("Error: Base de datos no se encuentra disponible.");
            }catch(NoDataException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ResultSet rs = null;
        Cliente cliente = null;
        CallableStatement pstmt = null;
        try{
            pstmt = conexion.prepareCall(CONSULTAR_CLIENTE);
            pstmt.registerOutParameter(1, OracleTypes.CURSOR);
            pstmt.setString(2, identificador);
            pstmt.execute();
            rs = (ResultSet) pstmt.getObject(1);
            rs.next();
            cliente = new Cliente(
                rs.getString("idCliente"),
                rs.getString("nombre"),
                rs.getString("primerApellido"),
                rs.getString("segundoApellido"),
                rs.getString("fechaNac"),
                rs.getString("correo"),
                rs.getString("direccion"),
                rs.getString("telefono"),
                rs.getString("celular")
            );
            
            ServicioUsuario servUsuario = new ServicioUsuario();
            Usuario consulta = servUsuario.consultarUsuario(cliente.getIdCliente());
            cliente.setUsuario(consulta.getUsuario());
            cliente.setContrasenia(consulta.getContrasenia());
            
        }catch(SQLException e){
            try{
                throw new GlobalException("Error: Problema al realizar la consulta del cliente.");
            }catch(GlobalException ex){
                Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ServicioCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return cliente;
    }
    
}
