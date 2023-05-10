/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ThinkPad
 */
@Entity
@Table(name = "PATIENTS")
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByNss", query = "SELECT p FROM Patients p WHERE p.nss = :nss"),
    @NamedQuery(name = "Patients.findByNom", query = "SELECT p FROM Patients p WHERE p.nom = :nom"),
    @NamedQuery(name = "Patients.findByPrenom", query = "SELECT p FROM Patients p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Patients.findByDateNaissance", query = "SELECT p FROM Patients p WHERE p.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Patients.findByAdresse", query = "SELECT p FROM Patients p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Patients.findByTelephone", query = "SELECT p FROM Patients p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Patients.findByEmail", query = "SELECT p FROM Patients p WHERE p.email = :email")})
public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NSS")
    private BigDecimal nss;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "PRENOM")
    private String prenom;
    @Column(name = "DATE_NAISSANCE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateNaissance;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nss")
    private Collection<Reservations> reservationsCollection;

    public Patients() {
    }

    public Patients(BigDecimal nss) {
        this.nss = nss;
    }

    public Patients(BigDecimal nss, String nom, String prenom) {
        this.nss = nss;
        this.nom = nom;
        this.prenom = prenom;
    }

    public BigDecimal getNss() {
        return nss;
    }

    public void setNss(BigDecimal nss) {
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

    public Collection<Reservations> getReservationsCollection() {
        return reservationsCollection;
    }

    public void setReservationsCollection(Collection<Reservations> reservationsCollection) {
        this.reservationsCollection = reservationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nss != null ? nss.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.nss == null && other.nss != null) || (this.nss != null && !this.nss.equals(other.nss))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Patients[ nss=" + nss + " ]";
    }
    
}
