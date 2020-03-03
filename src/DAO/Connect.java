/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aldai
 */
public class Connect {
    
    private static Connection con ;
    
    private Connect(){

    }
    
    public static Connection getConnection(){
        
        if (con == null){
            try {
                con = DriverManager.getConnection("jdbc:mysql://162.241.60.240:3306/kapacita_taller", "kapacita_surveyu","K4P4C1T4SURV3Y");
            } catch (SQLException ex) {
                assert false : "Conexión a base de datos fallida";
            }
        }
        
        return con;
    }
}
