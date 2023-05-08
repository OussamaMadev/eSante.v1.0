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

    
    private Connection conn;
    Statement stat = null;
    ResultSet res = null;
    String requete;

    public boolean connectToDB() throws Exception {
        try {
            //Load the MySQL Connector/J driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //Establish a connection to the MySQL database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "C##Sadmin", "1234");

            JOptionPane.showMessageDialog(null, "the etat_amerique data base is connected", "  ", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "the etat_amerique data base connection failled", "Message", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
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
