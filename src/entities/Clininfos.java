/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ThinkPad
 */
@Entity
@Table(name = "CLININFOS")
@NamedQueries({
    @NamedQuery(name = "Clininfos.findAll", query = "SELECT c FROM Clininfos c"),
    @NamedQuery(name = "Clininfos.findByNomClinique", query = "SELECT c FROM Clininfos c WHERE c.nomClinique = :nomClinique"),
    @NamedQuery(name = "Clininfos.findByAdresse", query = "SELECT c FROM Clininfos c WHERE c.adresse = :adresse"),
    @NamedQuery(name = "Clininfos.findBySiteWeb", query = "SELECT c FROM Clininfos c WHERE c.siteWeb = :siteWeb"),
    @NamedQuery(name = "Clininfos.findByCodeRespo", query = "SELECT c FROM Clininfos c WHERE c.codeRespo = :codeRespo"),
    @NamedQuery(name = "Clininfos.findByTel1", query = "SELECT c FROM Clininfos c WHERE c.tel1 = :tel1"),
    @NamedQuery(name = "Clininfos.findByTel2", query = "SELECT c FROM Clininfos c WHERE c.tel2 = :tel2"),
    @NamedQuery(name = "Clininfos.findByTel3", query = "SELECT c FROM Clininfos c WHERE c.tel3 = :tel3"),
    @NamedQuery(name = "Clininfos.findByAdminPassword", query = "SELECT c FROM Clininfos c WHERE c.adminPassword = :adminPassword"),
    @NamedQuery(name = "Clininfos.findById", query = "SELECT c FROM Clininfos c WHERE c.id = :id")})
public class Clininfos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "NOM_CLINIQUE")
    private String nomClinique;
    @Column(name = "ADRESSE")
    private String adresse;
    @Column(name = "SITE_WEB")
    private String siteWeb;
    @Column(name = "CODE_RESPO")
    private BigInteger codeRespo;
    @Column(name = "TEL1")
    private Long tel1;
    @Column(name = "TEL2")
    private Long tel2;
    @Column(name = "TEL3")
    private Long tel3;
    @Column(name = "ADMIN_PASSWORD")
    private BigInteger adminPassword;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;

    public Clininfos() {
    }

    public Clininfos(BigDecimal id) {
        this.id = id;
    }

    public Clininfos(BigDecimal id, String nomClinique) {
        this.id = id;
        this.nomClinique = nomClinique;
    }

    public String getNomClinique() {
        return nomClinique;
    }

    public void setNomClinique(String nomClinique) {
        this.nomClinique = nomClinique;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public BigInteger getCodeRespo() {
        return codeRespo;
    }

    public void setCodeRespo(BigInteger codeRespo) {
        this.codeRespo = codeRespo;
    }

    public Long getTel1() {
        return tel1;
    }

    public void setTel1(Long tel1) {
        this.tel1 = tel1;
    }

    public Long getTel2() {
        return tel2;
    }

    public void setTel2(Long tel2) {
        this.tel2 = tel2;
    }

    public Long getTel3() {
        return tel3;
    }

    public void setTel3(Long tel3) {
        this.tel3 = tel3;
    }

    public BigInteger getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(BigInteger adminPassword) {
        this.adminPassword = adminPassword;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clininfos)) {
            return false;
        }
        Clininfos other = (Clininfos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Clininfos[ id=" + id + " ]";
    }
    
}
