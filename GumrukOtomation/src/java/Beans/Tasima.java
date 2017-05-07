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
@ManagedBean(name = "tasima")
@SessionScoped
public class Tasima {

 
    DataSource dataSource;
    private int sıraNo;
    private String plaka;
    private String pasaportNo;
    private String yukCinsi;
    private String miktar;
    private String olcuBirimi;
    private String girisZamani;
    private String cikisZamani;
    private String geldigiYer;
    private String gidecegiYer;
    private String memurTC;

    public Tasima() {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("jdbc:derby://localhost:1527/gumrukotomasyon");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int getSıraNo() {
        return sıraNo;
    }

    public void setSıraNo(int sıraNo) {
        this.sıraNo = sıraNo;
    }

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getPasaportNo() {
        return pasaportNo;
    }

    public void setPasaportNo(String pasaportNo) {
        this.pasaportNo = pasaportNo;
    }

    public String getYukCinsi() {
        return yukCinsi;
    }

    public void setYukCinsi(String yukCinsi) {
        this.yukCinsi = yukCinsi;
    }

    public String getMiktar() {
        return miktar;
    }

    public void setMiktar(String miktar) {
        this.miktar = miktar;
    }

    public String getOlcuBirimi() {
        return olcuBirimi;
    }

    public void setOlcuBirimi(String olcuBirimi) {
        this.olcuBirimi = olcuBirimi;
    }

    public String getGirisZamani() {
        return girisZamani;
    }

    public void setGirisZamani(String girisZamani) {
        this.girisZamani = girisZamani;
    }

    public String getCikisZamani() {
        return cikisZamani;
    }

    public void setCikisZamani(String cikisZamani) {
        this.cikisZamani = cikisZamani;
    }

    public String getGeldigiYer() {
        return geldigiYer;
    }

    public void setGeldigiYer(String geldigiYer) {
        this.geldigiYer = geldigiYer;
    }

    public String getGidecegiYer() {
        return gidecegiYer;
    }

    public void setGidecegiYer(String gidecegiYer) {
        this.gidecegiYer = gidecegiYer;
    }

    public String getMemurTC() {
        return memurTC;
    }

    public void setMemurTC(String memurTC) {
        this.memurTC = memurTC;
    }
    
}
