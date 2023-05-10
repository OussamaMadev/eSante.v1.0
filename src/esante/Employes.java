/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThinkPad
 */
public class Employes {

    private int code;
    private String nom;
    private String prenom;
    private String secteur;
    private int anciennete;
    private String specialite;

    public Employes(String nom, String prenom, String secteur, int anciennete, String specialite) {

        this.nom = nom;
        this.prenom = prenom;
        this.secteur = secteur;
        this.anciennete = anciennete;
        this.specialite = specialite;
    }

    public Employes() {
    }

    public Employes(int code, String nom, String prenom, String secteur, int anciennete, String specialite) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.secteur = secteur;
        this.anciennete = anciennete;
        this.specialite = specialite;
    }

    
    
    public static ArrayList<Employes> getAll() throws Exception {
        ArrayList<Employes> employesList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        String requete;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stat = conn.createStatement();
            requete = "SELECT *  FROM employes order by code";
            res = stat.executeQuery(requete);

            while (res.next()) {
                Employes employe = new Employes(res.getInt("code"), res.getString("nom"), res.getString("prenom"), res.getString("secteur"), res.getInt("anciennete"), res.getString("specialite"));
                employesList.add(employe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return employesList;
    }


    public static ArrayList<Employes> getAllsql(String requete) throws Exception {
        ArrayList<Employes> employesList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
       

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stat = conn.createStatement();
            requete = "SELECT *  FROM employes order by code";
            res = stat.executeQuery(requete);

            while (res.next()) {
                Employes employe = new Employes(res.getInt("code"), res.getString("nom"), res.getString("prenom"), res.getString("secteur"), res.getInt("anciennete"), res.getString("specialite"));
                employesList.add(employe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (stat != null) {
                stat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return employesList;
    }

    public static Employes getByCode(int code) throws Exception {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet res = null;
        String requete;
        Employes employe = null;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            
            requete = "SELECT * FROM employes WHERE code=?";
            prepStat = conn.prepareStatement(requete);
            prepStat.setInt(1, code);
            res = prepStat.executeQuery();

            if (res.next()) {
                employe = new Employes(res.getInt("CODE"), res.getString("NOM"), res.getString("PRENOM"), res.getString("secteur"), res.getInt("anciennete"), res.getString("specialite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (prepStat != null) {
                prepStat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return employe;
    }

   public void save() throws Exception {
    Connection conn = null;
    PreparedStatement prepStat = null;
    String requete;
    
    try {
        dataBasecon db = new dataBasecon();
        db.connectToDB();
        conn = db.getConn();
        
        if (this.getCode() == 0) {
            // Insert a new employe
            requete = "INSERT INTO employes (nom, prenom, secteur, anciennete, specialite) VALUES (?, ?, ?, ?, ?)";
            prepStat = conn.prepareStatement(requete);
            prepStat.setString(1, this.getNom());
            prepStat.setString(2, this.getPrenom());
            prepStat.setString(3, this.getSecteur());
            prepStat.setInt(4, this.getAnciennete());
            prepStat.setString(5, this.getSpecialite());
            prepStat.executeUpdate();
            
            // Retrieve the generated code for the new employe
            ResultSet generatedKeys = prepStat.getGeneratedKeys();
            if (generatedKeys.next()) {
                this.setCode(generatedKeys.getInt(1));
            }
        } else {
            // Update an existing employe
            requete = "UPDATE employes SET nom=?, prenom=?, secteur=?, anciennete=?, specialite=? WHERE code=?";
            prepStat = conn.prepareStatement(requete);
            prepStat.setString(1, this.getNom());
            prepStat.setString(2, this.getPrenom());
            prepStat.setString(3, this.getSecteur());
            prepStat.setInt(4, this.getAnciennete());
            prepStat.setString(5, this.getSpecialite());
            prepStat.setInt(6, this.getCode());
            prepStat.executeUpdate();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (prepStat != null) {
            prepStat.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

    
    public void delete() throws Exception {
        Connection conn = null;
        PreparedStatement prepStat = null;
        String requete;
      
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            requete = "DELETE FROM employes WHERE code=?";
            prepStat = conn.prepareStatement(requete);
            prepStat.setInt(1, this.getCode());
            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepStat != null) {
                prepStat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    // Getters and Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public int getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(int anciennete) {
        this.anciennete = anciennete;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    // Methods for database operations
}
