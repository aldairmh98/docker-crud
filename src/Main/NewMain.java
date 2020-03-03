/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import DAO.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author aldai
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection con = Connect.getConnection();
        
        
        try (PreparedStatement ps2 = con.prepareStatement("INSERT INTO alumno(matricula, "
                + "name, gender, fecha_nac) VALUES (?, ? , ?, ?)");) {
            
            //ResultSet rs = ps.executeQuery();
            ps2.setString(1, "S10999");
            ps2.setString(3,String.valueOf('d'));
            ps2.setString(2, "Aldair");
            LocalDate ld = LocalDate.of(2020, Month.FEBRUARY, 22);
            ps2.setObject(4, ld.toString());
            
            System.out.println(ps2.executeUpdate());
            /*while (rs.next()) {
                System.out.println(rs.getString("name"));
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
