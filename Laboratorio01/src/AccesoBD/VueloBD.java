/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Vuelo;
import Servicios.Servicio;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class VueloBD extends Servicio{
    
    private static final String INSERTARVUELO = "{call INSERTARVUELO(?,?,?,?,?,?,?)}";
    private static final String MODIFICARVUELO = "{call MODIFICARVUELO(?,?,?,?,?,?,?)}";
    private static final String ELIMINARVUELO = "{call ELIMINARVUELO(?)}";
    private static final String LISTARVUELOS = "{?=call LISTARVUELOS()}";
    private static final String CONSULTARVUELO = "{?=call CONSULTARVUELO(?)}";
    
    
    
    public void insertarVuelo(Vuelo vuelo) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARVUELO);
            pstmt.setString(1, vuelo.getIdVuelo());
            pstmt.setString(2, vuelo.getFechaIda());
            pstmt.setString(3, vuelo.getFechaRegreso());
            pstmt.setInt(4, vuelo.getCantidadPasajeros());
            pstmt.setDouble(5, vuelo.getPrecio());
            pstmt.setString(6, vuelo.getAvion());
            pstmt.setString(7, vuelo.getRuta());
       
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    public void modificarVuelo(Vuelo vuelo) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARVUELO);
            pstmt.setString(1, vuelo.getIdVuelo());
            pstmt.setString(2, vuelo.getFechaIda());
            pstmt.setString(3, vuelo.getFechaRegreso());
            pstmt.setInt(4, vuelo.getCantidadPasajeros());
            pstmt.setDouble(5, vuelo.getPrecio());
            pstmt.setString(6, vuelo.getAvion());
            pstmt.setString(7, vuelo.getRuta());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarVuelo(String id) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARVUELO);
            pstmt.setString(1, id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(VueloBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
