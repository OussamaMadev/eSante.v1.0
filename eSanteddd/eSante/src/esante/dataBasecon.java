/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esante;

/**
 *
 * @author ThinkPad
 */
import java.sql.*;
//import java.util.*;
import javax.swing.*;

public class dataBasecon {

    static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Connection conn;
    Statement stat = null;
    ResultSet res = null;
    String requete;

    public boolean connectToDB() throws Exception {
        try {

            //Load the oracl Connector/J driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish a connection to the oracl database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:eSante", "admincli", "1234");
            System.out.println("the data base is connected");
            return true;
        } catch (Exception e) {
            System.out.println("the data base is not connected&&&*****");
            return false;
        }
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Statement getStat() {
        return stat;
    }

    public void setStat(Statement stat) {
        this.stat = stat;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public String getRequete() {
        return requete;
    }

    public void setRequete(String requete) {
        this.requete = requete;
    }

    public boolean disconect() {
        try {

            conn.close();
            JOptionPane.showMessageDialog(null, "disconnected", "Message", JOptionPane.INFORMATION_MESSAGE);

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "failled", "Message", JOptionPane.INFORMATION_MESSAGE);

            return false;
        }
    }

    public ResultSet SQLSelect(String sql) throws Exception {

        try {
            stat = conn.createStatement();
            res = stat.executeQuery(sql);
            System.out.println("done");
            return res;
        } catch (Exception e) {
            res.close();
            stat.close();
            return null;
        }

    }

    public void affichresult() throws Exception {

        Boolean encore = false;

        requete = "Select code,nom,secteur From employes";
        try {
            res = SQLSelect(requete);
            if (res != null) {
                encore = res.next();
            }
            while (encore) {
                System.out.println(res.getString(1) + " " + res.getString(3));
                encore = res.next();
            }
            res.close();

        } catch (Exception e) {
            res.close();
        }

    }

}
