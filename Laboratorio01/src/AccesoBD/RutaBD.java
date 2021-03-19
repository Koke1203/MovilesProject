/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Ruta;
import Servicios.Servicio;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class RutaBD extends Servicio{
    
    private static final String INSERTARRUTA = "{call INSERTARRUTA(?,?,?,?,?,?,?,?,?)}";
    private static final String MODIFICARRUTA = "{call MODIFICARRUTA(?,?,?,?,?,?,?,?,?)}";
    private static final String ELIMINARRUTA = "{call ELIMINARRUTA(?)}";
    private static final String LISTARRUTAS = "{?=call LISTARAVIONES()}";
    private static final String CONSULTARRUTA = "{?=call CONSULTARAVION(?)}";
    
    
    public void insertarRuta(Ruta ruta) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARRUTA);
            pstmt.setString(1, ruta.getIdRuta());
            pstmt.setString(2, ruta.getOrigen());
            pstmt.setString(3, ruta.getDestino());
            pstmt.setInt(4, ruta.getDuracionHoras());
            pstmt.setInt(5, ruta.getDuracionMinutos());
            pstmt.setString(6, ruta.getDiaSemana());
            pstmt.setInt(7, ruta.getHora());
            pstmt.setInt(8, ruta.getMinutos());
            pstmt.setString(9, ruta.getHoraLlegada());
            
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarRuta(Ruta ruta) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARRUTA);
            pstmt.setString(1, ruta.getIdRuta());
            pstmt.setString(2, ruta.getOrigen());
            pstmt.setString(3, ruta.getDestino());
            pstmt.setInt(4, ruta.getDuracionHoras());
            pstmt.setInt(5, ruta.getDuracionMinutos());
            pstmt.setString(6, ruta.getDiaSemana());
            pstmt.setInt(7, ruta.getHora());
            pstmt.setInt(8, ruta.getMinutos());
            pstmt.setString(9, ruta.getHoraLlegada());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarRuta(String id) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARRUTA);
            pstmt.setString(1, id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(RutaBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
