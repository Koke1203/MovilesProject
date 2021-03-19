/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Avion;
import Servicios.Servicio;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class AvionBD extends Servicio{

    private static final String INSERTARAVION = "{call INSERTARAVION(?,?,?,?,?,?,?)}";
    private static final String MODIFICARAVION = "{call MODIFICARAVION(?,?,?,?,?,?,?)}";
    private static final String ELIMINARAVION = "{call ELIMINARAVION(?)}";
    private static final String LISTARAVIONES = "{?=call LISTARAVIONES()}";
    private static final String CONSULTARAVION = "{?=call CONSULTARAVION(?)}";

//*******************************************************************************
    
    public void insertarAvion(Avion avion) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARAVION);
            pstmt.setString(1, avion.getIdentificador());
            pstmt.setInt(2, avion.getAnio());
            pstmt.setString(3, avion.getMarca());
            pstmt.setString(4, avion.getModelo());
            pstmt.setInt(5, avion.getCantPasajeros());
            pstmt.setInt(6, avion.getCantFilas());
            pstmt.setInt(7, avion.getCantAsientos());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void modificarAvion(Avion avion) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARAVION);
            pstmt.setString(1, avion.getIdentificador());
            pstmt.setInt(2, avion.getAnio());
            pstmt.setString(3, avion.getMarca());
            pstmt.setString(4, avion.getModelo());
            pstmt.setInt(5, avion.getCantPasajeros());
            pstmt.setInt(6, avion.getCantFilas());
            pstmt.setInt(7, avion.getCantAsientos());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void eliminarAvion(String id) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARAVION);
            pstmt.setString(1, id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AvionBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }



}
