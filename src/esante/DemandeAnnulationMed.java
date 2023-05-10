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

public class DemandeAnnulationMed {

    private int id;
    private String demandeDe;
    private String raison;
    private int numeroResa;

    public DemandeAnnulationMed(int id, String demandeDe, String raison, int numeroResa) {
        this.id = id;
        this.demandeDe = demandeDe;
        this.raison = raison;
        this.numeroResa = numeroResa;
    }

    public DemandeAnnulationMed(String demandeDe, String raison, int numeroResa) {
        this.demandeDe = demandeDe;
        this.raison = raison;
        this.numeroResa = numeroResa;
    }

    // Getters and setters for all fields
    public static ArrayList<DemandeAnnulationMed> getAll() throws SQLException {
        ArrayList<DemandeAnnulationMed> demandeAnnulationMeds = new ArrayList<>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM demande_annulation_med";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String demandeDe = rs.getString("demande_de");
                String raison = rs.getString("raison");
                int numeroResa = rs.getInt("numero_resa");

                DemandeAnnulationMed demandeAnnulationMed = new DemandeAnnulationMed(id, demandeDe, raison, numeroResa);
                demandeAnnulationMeds.add(demandeAnnulationMed);
            }

        } catch (SQLException e) {
        } catch (Exception ex) {
            Logger.getLogger(DemandeAnnulationMed.class.getName()).log(Level.SEVERE, null, ex);
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
    
        return demandeAnnulationMeds;
    }

    public static DemandeAnnulationMed getById(int id) throws SQLException {
        DemandeAnnulationMed demandeAnnulationMed = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM demande_annulation_med WHERE id = ?";

        try {
            conn = dataBasecon.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                demandeAnnulationMed = new DemandeAnnulationMed(
                        rs.getInt("id"),
                        rs.getString("demande_de"),
                        rs.getString("raison"),
                        rs.getInt("numero_resa")
                );
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return demandeAnnulationMed;
    }

    public void save() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;

        try {
            conn = dataBasecon.getConnection();

            if (this.id == 0) {
                sql = "INSERT INTO demande_annulation_med (demande_de, raison, numero_resa) VALUES (?, ?, ?)";
                ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, this.demandeDe);
                ps.setString(2, this.raison);
                ps.setInt(3, this.numeroResa);
                ps.executeUpdate();
                rs = ps.getGeneratedKeys();

                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                sql = "UPDATE demande_annulation_med SET demande_de = ?, raison = ?, numero_resa = ? WHERE id = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, this.demandeDe);
                ps.setString(2, this.raison);
                ps.setInt(3, this.numeroResa);
                ps.setInt(4, this.id);
                ps.executeUpdate();
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public void delete() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "DELETE FROM demande_annulation_med WHERE id = ?";

        try {
            conn = dataBasecon.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, this.id);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDemandeDe() {
        return demandeDe;
    }

    public void setDemandeDe(String demandeDe) {
        this.demandeDe = demandeDe;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public int getNumeroResa() {
        return numeroResa;
    }

    public void setNumeroResa(int numeroResa) {
        this.numeroResa = numeroResa;
    }

}
