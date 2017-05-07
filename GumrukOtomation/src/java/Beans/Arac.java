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
/**
 *
 * @author Brainiac
 */
@ManagedBean(name="arac")
@RequestScoped
public class Arac {
    DataSource dataSource;
    
    private String plaka;
    private String aracCinsi;
    private String ulkesi;
    private String firma;
    private String model;
    //jdbc:derby://localhost:1527/gumrukotomasyon [APP on APP]
    public Arac() throws SQLException, ClassNotFoundException{
          try {
			Context ctx = new InitialContext();
                        //Class.forName("org.apache.derby.jdbc.ClientDriver");
                       // DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			dataSource = (DataSource)ctx.lookup("jdbc:derby:gumrukotomasyon");
		} catch (NamingException e) {
			e.printStackTrace();
		}
    }

     public String aracEkle() throws SQLException, NamingException {
       
        // check whether dataSource was injected by the server
        if (dataSource == null) {
            throw new SQLException("Unable to obtain DataSource");
        }

        // obtain a connection from the connection pool
        Connection connection = dataSource.getConnection();

        // check whether connection was successful
        if (connection == null) {
            throw new SQLException("Unable to connect to DataSource");
        }

        try {
            // create a PreparedStatement to insert a new address book entry
            PreparedStatement addEntry
                    = connection.prepareStatement("INSERT INTO ARAC"
                            + "(plaka,aracCinsi,ulkesi,firma,model)"
                            + "VALUES ( ?, ?, ?, ?,? )");

            // specify the PreparedStatement's arguments
            addEntry.setString(1, getPlaka());
            addEntry.setString(2, getAracCinsi());
            addEntry.setString(3, getUlkesi());
            addEntry.setString(4, getFirma());
            addEntry.setString(5, getModel());

            addEntry.executeUpdate(); // insert the entry
            return "home"; // go back to home.xhtml home page
        } // end try
        finally {
            connection.close(); // return this connection to pool
        } // end finally
    }
    
     public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
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
    
   
}
