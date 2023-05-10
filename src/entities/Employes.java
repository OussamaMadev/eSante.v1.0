/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ThinkPad
 */
@Entity
@Table(name = "EMPLOYES")
@NamedQueries({
    @NamedQuery(name = "Employes.findAll", query = "SELECT e FROM Employes e"),
    @NamedQuery(name = "Employes.findByCode", query = "SELECT e FROM Employes e WHERE e.code = :code"),
    @NamedQuery(name = "Employes.findByNom", query = "SELECT e FROM Employes e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employes.findByPrenom", query = "SELECT e FROM Employes e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employes.findBySecteur", query = "SELECT e FROM Employes e WHERE e.secteur = :secteur"),
    @NamedQuery(name = "Employes.findByAnciennete", query = "SELECT e FROM Employes e WHERE e.anciennete = :anciennete"),
    @NamedQuery(name = "Employes.findBySpecialite", query = "SELECT e FROM Employes e WHERE e.specialite = :specialite")})
public class Employes implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CODE")
    private BigDecimal code;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "SECTEUR")
    private String secteur;
    @Column(name = "ANCIENNETE")
    private BigInteger anciennete;
    @Column(name = "SPECIALITE")
    private String specialite;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private Collection<Reservations> reservationsCollection;

    public Employes() {
    }

    public Employes(BigDecimal code) {
        this.code = code;
    }

    public Employes(BigDecimal code, String nom, String prenom, String secteur) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.secteur = secteur;
    }

    public BigDecimal getCode() {
        return code;
    }

    public void setCode(BigDecimal code) {
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

    public BigInteger getAnciennete() {
        return anciennete;
    }

    public void setAnciennete(BigInteger anciennete) {
        this.anciennete = anciennete;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
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
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employes)) {
            return false;
        }
        Employes other = (Employes) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Employes[ code=" + code + " ]";
    }
    
}
