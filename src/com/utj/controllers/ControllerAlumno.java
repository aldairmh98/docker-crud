/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utj.controllers;

import DAO.DAOAlumno;
import com.utj.pojo.Alumno;
import com.utj.views.ViewPersona;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aldai
 */
public class ControllerAlumno {
    
    private ViewPersona vista;
    private DAOAlumno DaoAlumno;
    private DefaultTableModel dtm;
    
    public ControllerAlumno(ViewPersona vista, DAOAlumno DaoAlumno){
        this.vista = vista;
        this.DaoAlumno  = DaoAlumno;
        vista.getLabelNivel().setVisible(false);
        vista.getTextNivelEstudios().setVisible(false);
        Object [] columns = {"ID", "Nombre"};
        dtm = new DefaultTableModel(columns, 0);
        vista.getButtonSave().addActionListener((e) -> {
            System.out.println("Botón Presionado");
        });
        vista.getjTable1().setModel(dtm);
        this.fillTable();
        
    }
    
    private void fillTable(){
        try {
            ArrayList<Alumno> alumnos = DaoAlumno.readAll();
            for(Alumno al : alumnos){
                Object[] rowData = {al.getId(), al.getNombre()};
                dtm.addRow(rowData);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    
}
