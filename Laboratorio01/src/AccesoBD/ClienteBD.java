/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Cliente;
import Servicios.Servicio;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class ClienteBD extends Servicio {

    private static final String INSERTARCLIENTE = "{call INSERTARCLIENTE(?,?,?,?,?,?,?,?,?)}";
    private static final String MODIFICARCLIENTE = "{call MODIFICARCLIENTE(?,?,?,?,?,?,?,?,?)}";
    private static final String ELIMINARCLIENTE = "{call ELIMINARCLIENTE(?)}";
    private static final String LISTARCLIENTES = "{?=call LISTARCLIENTES()}";
    private static final String CONSULTARCLIENTE = "{?=call CONSULTARCLIENTE(?)}";
    //********************************************************************************************************
    
    public void insertarCliente(Cliente cliente) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARCLIENTE);
            pstmt.setString(1, cliente.getIdCliente());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getPrimerApellido());
            pstmt.setString(4, cliente.getSegundoApellido());
            pstmt.setString(5, cliente.getFechaNacimiento());
            pstmt.setString(6, cliente.getCorreo());
            pstmt.setString(7, cliente.getDireccion());
            pstmt.setString(8, cliente.getTelefono());
            pstmt.setString(9, cliente.getCelular());
            

            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                Desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarCliente(Cliente cliente) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARCLIENTE);
            pstmt.setString(1, cliente.getIdCliente());
            pstmt.setString(2, cliente.getNombre());
            pstmt.setString(3, cliente.getPrimerApellido());
            pstmt.setString(4, cliente.getSegundoApellido());
            pstmt.setString(5, cliente.getFechaNacimiento());
            pstmt.setString(6, cliente.getCorreo());
            pstmt.setString(7, cliente.getDireccion());
            pstmt.setString(8, cliente.getTelefono());
            pstmt.setString(9, cliente.getCelular());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                Desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void eliminarCliente(String id) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARCLIENTE);
            pstmt.setString(1, id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                Desconectar();
            } catch (SQLException e) {
                try {
                    throw new GlobalException("Estatutos invalidos o nulos");
                } catch (GlobalException ex) {
                    Logger.getLogger(ClienteBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }


}
