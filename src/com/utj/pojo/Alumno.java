
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utj.pojo;

import java.time.LocalDate;

/**
 *
 * @author aldai
 */
public class Alumno extends Persona {
    
    
    private String nombre;
    private String matricula;
    private char genero;
    private String email;
    private String telefono;
    private String direccion;
    private Carrera carrera;
    private Calificacion[] calificaciones;


    public Calificacion[] getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(Calificacion[] calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }
    
    

    public Alumno() {
    }

    
    
    public String toFileSave(){
        return String.join(",", getNombre(), getEmail() );
    }
    
    
}
