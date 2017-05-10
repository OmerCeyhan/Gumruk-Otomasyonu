/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.sql.DataSource;
import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Brainiac
 */
@ManagedBean(name = "ihbar")
@SessionScoped
public class Ihbar {

    DataSource dataSource;

    private String ihbarNo;
    private String plaka;
    private String ihbarSebebi;
    private String ihbarTarihi;
    private String ihbarSayisi;

    public Ihbar() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc/gumrukotomasyon");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public String getIhbarNo() {
        return ihbarNo;
    }

    public void setIhbarNo(String ihbarNo) {
        this.ihbarNo = ihbarNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getIhbarSebebi() {
        return ihbarSebebi;
    }

    public void setIhbarSebebi(String ihbarSebebi) {
        this.ihbarSebebi = ihbarSebebi;
    }

    public String getIhbarTarihi() {
        return ihbarTarihi;
    }

    public void setIhbarTarihi(String ihbarTarihi) {
        this.ihbarTarihi = ihbarTarihi;
    }

    public String getIhbarSayisi() {
        return ihbarSayisi;
    }

    public void setIhbarSayisi(String ihbarSayisi) {
        this.ihbarSayisi = ihbarSayisi;
    }
    
}
