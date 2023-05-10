/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package esante;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author ThinkPad
 */
public class Reservations {
    private int numero;
    private Timestamp dateResa;
    private Date dateDePrend;
    private String typeResa;
    private String serviceResa;
    private String descRes;
    private int nss;
    private int code;
    private int payed;

    
    
    public Reservations(int numero, Timestamp dateResa, Date dateDePrend, String typeResa, String serviceResa, String descRes, int nss, int code, int payed) {
        this.numero = numero;
        this.dateResa = dateResa;
        this.dateDePrend = dateDePrend;
        this.typeResa = typeResa;
        this.serviceResa = serviceResa;
        this.descRes = descRes;
        this.nss = nss;
        this.code = code;
        this.payed = payed;
    }

    
    
    public Reservations() {
    }

    public Reservations( Timestamp dateResa, Date dateDePrend, String typeResa, String serviceResa, String descRes, int nss, int code, int payed) {
       
        this.dateResa = dateResa;
        this.dateDePrend = dateDePrend;
        this.typeResa = typeResa;
        this.serviceResa = serviceResa;
        this.descRes = descRes;
        this.nss = nss;
        this.code = code;
        this.payed = payed;
    }

    
     public static ArrayList<Reservations> getAll() throws Exception {
        ArrayList<Reservations> reservationList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        String requete;

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stat = conn.createStatement();
            requete = "SELECT * FROM reservations";
            res = stat.executeQuery(requete);

            while (res.next()) {
                Reservations reservation = new Reservations(
                        res.getInt("numero"),
                        res.getTimestamp("date_resa"),
                        res.getDate("date_dePrend"),
                        res.getString("type_resa"),
                        res.getString("service_resa"),
                        res.getString("descRes"),
                        res.getInt("nss"),
                        res.getInt("code"),
                        res.getInt("payed")
                );
                reservationList.add(reservation);
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
        return reservationList;
    }
    
    //Reservations.getAllreq("select * from Resevatoins");
     public static ArrayList<Reservations> getAllreq(String requete) throws Exception {
        ArrayList<Reservations> reservationList = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet res = null;
        

        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            stat = conn.createStatement();
            requete = "SELECT * FROM reservations";
            res = stat.executeQuery(requete);

            while (res.next()) {
                Reservations reservation = new Reservations(
                        res.getInt("numero"),
                        res.getTimestamp("date_resa"),
                        res.getDate("date_dePrend"),
                        res.getString("type_resa"),
                        res.getString("service_resa"),
                        res.getString("descRes"),
                        res.getInt("nss"),
                        res.getInt("code"),
                        res.getInt("payed")
                );
                reservationList.add(reservation);
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
        return reservationList;
    }
    
    public static Reservations getByNumero(int numero) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String query = "SELECT * FROM reservations WHERE numero = ?";
        
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setInt(1, numero);
            res = ps.executeQuery();

            if (res.next()) {
                return new Reservations(
                        res.getInt("numero"),
                        res.getTimestamp("date_resa"),
                        res.getDate("date_dePrend"),
                        res.getString("type_resa"),
                        res.getString("service_resa"),
                        res.getString("descRes"),
                        res.getInt("nss"),
                        res.getInt("code"),
                        res.getInt("payed")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (res != null) {
                res.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public static ArrayList<Reservations> getByPatient(int nss) throws Exception {
        ArrayList<Reservations> reservationList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String query = "SELECT * FROM reservations WHERE nss = ?";
        
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setInt(1, nss);
            res = ps.executeQuery();

            while (res.next()) {
                Reservations reservation = new Reservations(
                        res.getInt("numero"),
                        res.getTimestamp("date_resa"),
                        res.getDate("date_dePrend"),
                        res.getString("type_resa"),
                        res.getString("service_resa"),
                        res.getString("descRes"),
                        res.getInt("nss"),
                        res.getInt("code"),
                        res.getInt("payed")
                );
                reservationList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return reservationList;
    }
    
    
    public static ArrayList<Reservations> getByEmploye(int code) throws Exception {
        ArrayList<Reservations> reservationList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        String query = "SELECT * FROM reservations WHERE code = ?";
        
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setInt(1, code);
            res = ps.executeQuery();

            while (res.next()) {
                Reservations reservation = new Reservations(
                        res.getInt("numero"),
                        res.getTimestamp("date_resa"),
                        res.getDate("date_dePrend"),
                        res.getString("type_resa"),
                        res.getString("service_resa"),
                        res.getString("descRes"),
                        res.getInt("nss"),
                        res.getInt("code"),
                        res.getInt("payed")
                );
                reservationList.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return reservationList;
    }
    
    
    public static void delete(int numero) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        String query = "DELETE FROM reservations WHERE numero = ?";
        
        try {
            dataBasecon db = new dataBasecon();
            db.connectToDB();
            conn = db.getConn();
            ps = conn.prepareStatement(query);
            ps.setInt(1, numero);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    public void save() throws Exception {
    Connection conn = null;
    PreparedStatement stat = null;
    String requete;

    try {
        dataBasecon db = new dataBasecon();
        db.connectToDB();
        conn = db.getConn();
        
        if (this.numero > 0) {
            // Perform update
            requete = "UPDATE reservations SET date_resa=?, date_dePrend=?, type_resa=?, service_resa=?, descRes=?, nss=?, code=?, payed=? WHERE numero=?";
            stat = conn.prepareStatement(requete);
            stat.setTimestamp(1, this.dateResa);
            stat.setDate(2, this.dateDePrend);
            stat.setString(3, this.typeResa);
            stat.setString(4, this.serviceResa);
            stat.setString(5, this.descRes);
            stat.setInt(6, this.nss);
            stat.setInt(7, this.code);
            stat.setInt(8, this.payed);
            stat.setInt(9, this.numero);
            stat.executeUpdate();
        } else {
            // Perform insert
            requete = "INSERT INTO reservations (date_resa, date_dePrend, type_resa, service_resa, descRes, nss, code, payed) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stat = conn.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
            stat.setTimestamp(1, this.dateResa);
            stat.setDate(2, this.dateDePrend);
            stat.setString(3, this.typeResa);
            stat.setString(4, this.serviceResa);
            stat.setString(5, this.descRes);
            stat.setInt(6, this.nss);
            stat.setInt(7, this.code);
            stat.setInt(8, this.payed);
            stat.executeUpdate();

            // Get the auto-generated key for the new record
            ResultSet rs = stat.getGeneratedKeys();
            if (rs.next()) {
                this.numero = rs.getInt(1);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        if (stat != null) {
            stat.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}

    

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Timestamp getDateResa() {
        return dateResa;
    }

    public void setDateResa(Timestamp dateResa) {
        this.dateResa = dateResa;
    }

    public Date getDateDePrend() {
        return dateDePrend;
    }

    public void setDateDePrend(Date dateDePrend) {
        this.dateDePrend = dateDePrend;
    }

    public String getTypeResa() {
        return typeResa;
    }

    public void setTypeResa(String typeResa) {
        this.typeResa = typeResa;
    }

    public String getServiceResa() {
        return serviceResa;
    }

    public void setServiceResa(String serviceResa) {
        this.serviceResa = serviceResa;
    }

    public String getDescRes() {
        return descRes;
    }

    public void setDescRes(String descRes) {
        this.descRes = descRes;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPayed() {
        return payed;
    }

    public void setPayed(int payed) {
        this.payed = payed;
    }
    
    
    
}
