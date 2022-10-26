/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;


import datos.PersonaDao;
import dominio.Persona;
import java.util.logging.*;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alumno Mañana
 */
public class TestMysql {
    
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();
        
        
        //ArrayList<Persona> p1 = new ArrayList<Persona>();
        Persona p1 = new Persona ("Fer", "Bravo", "Hola@gm", "37268439");
        Persona p2 = new Persona ("Ingrid", "ayala", "Hola@gm", "37268439");
        Persona p3 = new Persona ("jim", "Bravo", "Hola@gm", "37268439");
        Persona p4 = new Persona ("carlos", "garcia", "Hola@gm", "37268439");
        Persona p5 = new Persona (4);
        Persona p6 = new Persona (2,"Manolo", "Bravo", "Hola@gm", "37268439");
        
        //personaDao.insertar(p1);
        //personaDao.insertar(p2);
        //personaDao.insertar(p3);
        //personaDao.eliminar(p5);
        personaDao.actualizar(p6);
        
        
        try{
            List<Persona> personas = personaDao.seleccionar();
            personas.forEach(persona ->{
                System.out.println("persona"+persona);
            });
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
        }
    }
    
}
