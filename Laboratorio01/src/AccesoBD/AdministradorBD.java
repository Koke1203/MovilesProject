/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoBD;

import Excepciones.GlobalException;
import Excepciones.NoDataException;
import Modelo.Administrador;
import Servicios.Servicio;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class AdministradorBD extends Servicio {

    private static final String INSERTARUSUARIO = "{call INSERTARUSUARIO(?,?,?,?)}";
    private static final String MODIFICARUSUARIO = "{call MODIFICARUSUARIO(?,?,?,?)}";
    private static final String ELIMINARUSUARIO = "{call ELIMINARUSUARIO(?)}";
    private static final String LISTARUSUARIOS = "{?=call LISTARUSUARIOS()}";
    private static final String CONSULTARUSUARIO = "{?=call CONSULTARUSUARIO(?)}";

//*******************************************************************************
    public void insertarAdministrador(Administrador admin) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(INSERTARUSUARIO);
            pstmt.setString(1, admin.getIdUsuario());
            pstmt.setString(2, admin.getContrasenia());
            pstmt.setString(3, admin.getTipoStr());
            pstmt.setString(4, admin.getUsuario());

            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void modificarAdministrador(Administrador admin) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(MODIFICARUSUARIO);
            pstmt.setString(1, admin.getIdUsuario());
            pstmt.setString(2, admin.getContrasenia());
            pstmt.setString(3, admin.getTipoStr());
            pstmt.setString(4, admin.getUsuario());
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void eliminarAdministrador(String id) {
        try {
            Conectar();
        } catch (ClassNotFoundException e) {
            try {
                throw new GlobalException("No se ha localizado el driver");
            } catch (GlobalException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            try {
                throw new NoDataException("La base de datos no se encuentra disponible");
            } catch (NoDataException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        CallableStatement pstmt = null;

        try {
            pstmt = conexion.prepareCall(ELIMINARUSUARIO);
            pstmt.setString(1, id);
            boolean resultado = pstmt.execute();
            if (resultado == true) {
                try {
                    throw new NoDataException("No se realizo la inserción");
                } catch (NoDataException ex) {
                    Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SQLException e) {
            try {
                throw new GlobalException("Llave duplicada");
            } catch (GlobalException ex) {
                Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(AdministradorBD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
//****************************************************************************************************************************

   



}
