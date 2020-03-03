/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.utj.pojo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author aldai
 */
public class DAOAlumno implements DAO<Alumno, Integer> {

    //SINGLETON INICIO
    private static DAOAlumno instance = null;
    
    public DAOAlumno(){
        
    }
    
    public static DAOAlumno getInstance(){
        if(instance == null)
            instance = new DAOAlumno();
        
        return instance;
    }
    //SINGLETON FIN
    @Override
    public void create(Alumno objeto) throws SQLException {
        Connection con = Connect.getConnection();

        try (PreparedStatement ps2 = con.prepareStatement("INSERT INTO alumno(matricula, "
                + "name, gender, fecha_nac) VALUES (?, ? , ?, ?)");) {

            //ResultSet rs = ps.executeQuery();
            ps2.setString(1, objeto.getMatricula());
            ps2.setString(3, String.valueOf(objeto.getGenero()));
            ps2.setString(2, objeto.getNombre());
            LocalDate ld = LocalDate.of(2020, Month.FEBRUARY, 22);
            ps2.setObject(4, objeto.getFecha_nacimiento().toString());

            ps2.executeUpdate();
            /*while (rs.next()) {
             System.out.println(rs.getString("name"));
             }*/
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public void update(Alumno objeto) throws SQLException {
        Connection con = Connect.getConnection();
        try (PreparedStatement ps2 = con.prepareStatement("UPDATE alumno SET matricula = ?, "
                + "name = ?, gender = ?, fecha_nac = ? WHERE id = ?")) {

            ps2.setString(1, objeto.getMatricula());
            ps2.setString(2, objeto.getNombre());
            ps2.setString(3, String.valueOf(objeto.getGenero()));
            ps2.setObject(4, objeto.getFecha_nacimiento().toString());
            ps2.setInt(5, objeto.getId());
            ps2.executeUpdate();
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Alumno readOne(Integer id) throws SQLException {
        Alumno al = null;
        try (PreparedStatement pr = Connect.getConnection().prepareStatement("SELECT * FROM alumno WHERE id = ?")) {
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();

            if (rs.next()) {
                al = new Alumno();
                al.setNombre(rs.getString("nombre"));
                al.setMatricula(rs.getString("matricula"));
                al.setGenero(rs.getString("gender").charAt(0));
                java.sql.Date retrieved = (java.sql.Date) rs.getObject("fecha_nac");
                al.setFecha_nacimiento(retrieved.toLocalDate());
            }

        }
        return al;
    }

    @Override
    public ArrayList<Alumno> readAll() throws SQLException {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Alumno al;
        try (PreparedStatement pr = Connect.getConnection().prepareStatement("SELECT * FROM alumno")) {
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                al = new Alumno();
                al.setNombre(rs.getString("nombre"));
                al.setMatricula(rs.getString("matricula"));
                al.setGenero(rs.getString("gender").charAt(0));
                java.sql.Date retrieved = (java.sql.Date) rs.getObject("fecha_nac");
                al.setFecha_nacimiento(retrieved.toLocalDate());
                alumnos.add(al);
            }

        }
        return alumnos;
    }

    public ArrayList<Alumno> readAll(Integer career) throws SQLException {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Alumno al;
        try (PreparedStatement pr = Connect.getConnection().prepareStatement("SELECT * FROM alumno")) {
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                al = new Alumno();
                al.setNombre(rs.getString("nombre"));
                al.setMatricula(rs.getString("matricula"));
                al.setGenero(rs.getString("gender").charAt(0));
                java.sql.Date retrieved = (java.sql.Date) rs.getObject("fecha_nac");
                al.setFecha_nacimiento(retrieved.toLocalDate());
                alumnos.add(al);
            }

        }
        return alumnos;
    }
}
