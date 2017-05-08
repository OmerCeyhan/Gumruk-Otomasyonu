/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Response;

/**
 *
 * @author Brainiac
 */
@ManagedBean(name = "arac")
@RequestScoped
public class Arac {

    private String plaka;
    private String aracCinsi;
    private String ulkesi;
    private String firma;
    private String model;
    //jdbc:derby://localhost:1527/gumrukotomasyon [APP on APP]

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getAracCinsi() {
        return aracCinsi;
    }

    public void setAracCinsi(String aracCinsi) {
        this.aracCinsi = aracCinsi;
    }

    public String getUlkesi() {
        return ulkesi;
    }

    public void setUlkesi(String ulkesi) {
        this.ulkesi = ulkesi;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String aracEkle() throws SQLException, NamingException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gumruk", "root", "omer1996");

            String sql = "INSERT INTO ARAC (plaka, arac_Cinsi, ulkesi, firma, model) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, getPlaka());
            ps.setString(2, getAracCinsi());
            ps.setString(3, getUlkesi());
            ps.setString(4, getFirma());
            ps.setString(5, getModel());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return "aracbilgi";
    }
}
