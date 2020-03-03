/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.utj.pojo.Alumno;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import views.Ejemplo;
import views.Personas;

/**
 *
 * @author aldai
 */
public class StudentController {

   private Personas ps;
    
    public StudentController(Alumno al , Personas ps) {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.addColumn("Nombre");
        ps.getTable().setModel(dtm);
        this.ps = ps;
        ps.getTextFieldTeachers().setVisible(false);
        Ejemplo euj = new Ejemplo();
        ps.getSaveButton().addActionListener(euj);
        ActionListener asml = (e)->{
            System.out.println("Hola mundo de los lambdas");
        };
        ps.getSaveButton().addActionListener(asml);
        String data [] = {"Aldair"};
        dtm.addRow(data);
    }
    
}
