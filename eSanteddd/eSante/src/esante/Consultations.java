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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultations {

    private int ID_CONSULTATION;
    private String resultat;
    private String traitement;
    private String recommandation;
    private int notQualite;
    private int notPonctualite;
    private int NUMERO_RESA;

    public Consultations(int ID_CONSULTATION, String resultat, String traitement, String recommandation, int notQualite, int notPonctualite, int NUMERO_RESA) {
        this.ID_CONSULTATION = ID_CONSULTATION;
        this.resultat = resultat;
        this.traitement = traitement;
        this.recommandation = recommandation;
        this.notQualite = notQualite;
        this.notPonctualite = notPonctualite;
        this.NUMERO_RESA = NUMERO_RESA;
    }

    public Consultations(String resultat, String traitement, String recommandation, int notQualite, int notPonctualite, int NUMERO_RESA) {
        this.resultat = resultat;
        this.traitement = traitement;
        this.recommandation = recommandation;
        this.notQualite = notQualite;
        this.notPonctualite = notPonctualite;
        this.NUMERO_RESA = NUMERO_RESA;
    }

    
    public Consultations() {
    }

    public static ArrayList<Consultations> getAll() throws SQLException {
        ArrayList<Consultations> consultationsList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        String query;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stat = conn.createStatement();
            query = "SELECT * FROM consultations";
            res = stat.executeQuery(query);

            while (res.next()) {
                Consultations consultation = new Consultations(
                        res.getInt("id_consultation"),
                        res.getString("resultat"),
                        res.getString("traitement"),
                        res.getString("recommandation"),
                        res.getInt("notQualite"),
                        res.getInt("notPonctualite"),
                        res.getInt("numero_resa")
                );
                consultationsList.add(consultation);
            }
        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(Consultations.class.getName()).log(Level.SEVERE, null, ex);
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
        return consultationsList;
    }

    public static Consultations getById(int id) throws Exception {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        String query = "SELECT * FROM consultations WHERE id_consultation = ?";

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            res = stmt.executeQuery();

            if (res.next()) {
                Consultations consultation = new Consultations(
                        res.getInt("id_consultation"),
                        res.getString("resultat"),
                        res.getString("traitement"),
                        res.getString("recommandation"),
                        res.getInt("notQualite"),
                        res.getInt("notPonctualite"),
                        res.getInt("numero_resa")
                );
                return consultation;
            } else {
                throw new Exception("No consultation found with id " + id);
            }

        } catch (SQLException e) {
            throw new Exception("Error while getting consultation with id " + id, e);
        } finally {
            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void save() throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    
    try {
        conn = dataBasecon.getConnection();
        stmt = conn.prepareStatement("INSERT INTO consultations (resultat, traitement, recommandation, notQualite, notPonctualite, numero_resa) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, resultat);
        stmt.setString(2, traitement);
        stmt.setString(3, recommandation);
        stmt.setInt(4, notQualite);
        stmt.setInt(5, notPonctualite);
        stmt.setInt(6, NUMERO_RESA);
        int affectedRows = stmt.executeUpdate();
        
        if (affectedRows == 0) {
            throw new SQLException("Failed to save consultation, no rows affected.");
        }
        
        rs = stmt.getGeneratedKeys();
        
        if (rs.next()) {
            ID_CONSULTATION = rs.getInt(1);
        } else {
            throw new SQLException("Failed to save consultation, no generated key obtained.");
        }
    } catch (SQLException e) {
        throw e;
    } finally {
        if (rs != null) {
                rs.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (stmt != null) {
                stmt.close();
            }
    }
}


    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public String getRecommandation() {
        return recommandation;
    }

    public void setRecommandation(String recommandation) {
        this.recommandation = recommandation;
    }

    public int getNotQualite() {
        return notQualite;
    }

    public void setNotQualite(int notQualite) {
        this.notQualite = notQualite;
    }

    public int getNotPonctualite() {
        return notPonctualite;
    }

    public void setNotPonctualite(int notPonctualite) {
        this.notPonctualite = notPonctualite;
    }

    public int getID_CONSULTATION() {
        return ID_CONSULTATION;
    }

    public void setID_CONSULTATION(int ID_CONSULTATION) {
        this.ID_CONSULTATION = ID_CONSULTATION;
    }

    public int getNUMERO_RESA() {
        return NUMERO_RESA;
    }

    public void setNUMERO_RESA(int NUMERO_RESA) {
        this.NUMERO_RESA = NUMERO_RESA;
    }

   

}
