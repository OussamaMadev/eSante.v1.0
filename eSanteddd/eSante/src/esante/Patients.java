/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esante;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad
 */
public class Patients {

    private int nss;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String adresse;
    private String telephone;
    private String email;

    public Patients(int nss, String nom, String prenom, Date dateNaissance, String adresse, String telephone, String email) {
        this.nss = nss;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public Patients() {
    }

    public static ArrayList<Patients> getAll() throws Exception {
        ArrayList<Patients> patientList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        String requete;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stat = conn.createStatement();
            requete = "SELECT * FROM patients";
            res = stat.executeQuery(requete);

            while (res.next()) {
                Patients patient = new Patients(
                        res.getInt("nss"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getDate("date_naissance"),
                        res.getString("adresse"),
                        res.getString("telephone"),
                        res.getString("email")
                );
                patientList.add(patient);
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
        return patientList;
    }

    public void save() throws Exception {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();

            String query = "INSERT INTO patients(nss, nom, prenom, date_naissance, adresse, telephone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
            prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, this.nss);
            prepStat.setString(2, this.nom);
            prepStat.setString(3, this.prenom);
            prepStat.setDate(4, this.dateNaissance);
            prepStat.setString(5, this.adresse);
            prepStat.setString(6, this.telephone);
            prepStat.setString(7, this.email);
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

    public static Patients getByNss(int nss) throws Exception {
        Patients patient = null;
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet res = null;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();

            String query = "SELECT * FROM patients WHERE nss = ?";
            prepStat = conn.prepareStatement(query);
            prepStat.setInt(1, nss);
            res = prepStat.executeQuery();

            if (res.next()) {
                patient = new Patients(
                        res.getInt("nss"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getDate("date_naissance"),
                        res.getString("adresse"),
                        res.getString("telephone"),
                        res.getString("email")
                );
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
        return patient;
    }

    public void update() throws Exception {
        Connection conn = null;
        PreparedStatement prepStat = null;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();

            String query = "UPDATE patients SET nom = ?, prenom = ?, date_naissance = ?, adresse = ?, telephone = ?, email = ? WHERE nss = ?";
            prepStat = conn.prepareStatement(query);
            prepStat.setString(1, this.nom);
            prepStat.setString(2, this.prenom);
            prepStat.setDate(3, this.dateNaissance);
            prepStat.setString(4, this.adresse);
            prepStat.setString(5, this.telephone);
            prepStat.setString(6, this.email);
            prepStat.setInt(7, this.nss);
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

    public void delete() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        String query = "DELETE FROM patients WHERE nss = ?";

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, this.nss);
            int deletedRows = stmt.executeUpdate();
            if (deletedRows == 0) {
                throw new SQLException("Deleting patient failed, no rows affected.");
            }
        } catch (Exception ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
