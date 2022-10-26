/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.conexion.close;
import static datos.conexion.getConnection;
import dominio.Persona;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alumno Mañana
 */
public class PersonaDao {
    private static final String SQL_SELECT = "SELECT * FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellidos, email, telefono) VALUE (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellidos=?, email=?, telefono=? WHERE idPersona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE idPersona=?";
    
    public List<Persona> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();
        conn = getConnection();
        stmt =conn.prepareStatement(SQL_SELECT);
        rs = stmt.executeQuery();
        
        while(rs.next()){
            int idPersona = rs.getInt("idPersona");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            
            personas.add(new Persona (idPersona, nombre, apellidos, email, telefono));
        }
        
        close(rs);
        close(stmt);
        close(conn);
          return personas;
    }
    
    
        public int insertar(Persona persona){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_INSERT);
                
                stmt.setString(1, persona.getNombre());
                stmt.setString(2, persona.getApellidos());
                stmt.setString(3, persona.getEmail());
                stmt.setString(4, persona.getTelefono());
                
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
    
        
        public int actualizar(Persona persona){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_UPDATE);
                
                stmt.setString(1, persona.getNombre());
                stmt.setString(2, persona.getApellidos());
                stmt.setString(3, persona.getEmail());
                stmt.setString(4, persona.getTelefono());
                stmt.setInt(5, persona.getIdPersona());
                
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
        
        
        public int eliminar(Persona persona){
            Connection conn = null;
            PreparedStatement stmt = null;
            int registros = 0;
            
            try {
                conn = getConnection();
                stmt =conn.prepareStatement(SQL_DELETE);
                
                stmt.setInt(1, persona.getIdPersona());
                
                registros = stmt.executeUpdate();
                
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }finally{
                try {
                    close(stmt);
                    close(conn);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            return registros;
        }
        
    
}
