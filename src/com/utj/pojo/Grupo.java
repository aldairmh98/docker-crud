/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utj.pojo;

/**
 *
 * @author aldai
 */
public class Grupo {
    private String id;
    private short grado;
    private int turn;
    private Alumno[] alumnos;

    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public short getGrado() {
        return grado;
    }

    public void setGrado(short grado) {
        this.grado = grado;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
    
    
}
