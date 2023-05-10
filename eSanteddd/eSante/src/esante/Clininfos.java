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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad
 */
public class Clininfos {

    private int id;
    private String nom_clinique;
    private String adresse;
    private String site_web;
    private int code_respo;
    private long tel1;
    private long tel2;
    private long tel3;
    private int admin_password;

    public Clininfos(String nom_clinique, String adresse, String site_web, int code_respo, long tel1, long tel2, long tel3, int admin_password) {
        this.nom_clinique = nom_clinique;
        this.adresse = adresse;
        this.site_web = site_web;
        this.code_respo = code_respo;
        this.tel1 = tel1;
        this.tel2 = tel2;
        this.tel3 = tel3;
        this.admin_password = admin_password;
    }

    public Clininfos() {
    }

    public void updateCodeRespo(int id, int newCodeRespo) throws SQLException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        String requete;
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();

            requete = "UPDATE clininfos SET code_respo = ? WHERE id = ?";
            prepStat = conn.prepareStatement(requete);
            prepStat.setInt(1, newCodeRespo);
            prepStat.setInt(2, id);
            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Clininfos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (prepStat != null) {
                prepStat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void updatePassword(int id, int newPassword) throws SQLException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        String requete;
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();

            requete = "UPDATE clininfos SET admin_password = ? WHERE id = ?";
            prepStat = conn.prepareStatement(requete);
            prepStat.setInt(1, newPassword);
            prepStat.setInt(2, id);
            prepStat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Clininfos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (prepStat != null) {
                prepStat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public Clininfos getById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement prepStat = null;
        ResultSet resultSet = null;
        String requete;
        Clininfos clinInfo = null;
        
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();

            requete = "SELECT * FROM clininfos WHERE id = ?";
            prepStat = conn.prepareStatement(requete);
            prepStat.setInt(1, id);
            resultSet = prepStat.executeQuery();

            if (resultSet.next()) {
                        

                clinInfo = new Clininfos(
                        resultSet.getString("nom_clinique"),
                        resultSet.getString("adresse"),
                        resultSet.getString("site_web"),
                        resultSet.getInt("code_respo"),
                        resultSet.getLong("tel1"),
                        resultSet.getLong("tel2"),
                        resultSet.getLong("tel3"),
                        resultSet.getInt("admin_password")
                );
                clinInfo.setId(id);
                System.out.println(resultSet.getInt("admin_password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(Clininfos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (prepStat != null) {
                prepStat.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return clinInfo;
    }

    public String getNom_clinique() {
        return nom_clinique;
    }

    public void setNom_clinique(String nom_clinique) {
        this.nom_clinique = nom_clinique;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSite_web() {
        return site_web;
    }

    public void setSite_web(String site_web) {
        this.site_web = site_web;
    }

    public int getCode_respo() {
        return code_respo;
    }

    public void setCode_respo(int code_respo) {
        this.code_respo = code_respo;
    }

    public long getTel1() {
        return tel1;
    }

    public void setTel1(long tel1) {
        this.tel1 = tel1;
    }

    public long getTel2() {
        return tel2;
    }

    public void setTel2(long tel2) {
        this.tel2 = tel2;
    }

    public long getTel3() {
        return tel3;
    }

    public void setTel3(long tel3) {
        this.tel3 = tel3;
    }

    public int getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(int admin_password) {
        this.admin_password = admin_password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
