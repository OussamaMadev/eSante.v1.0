/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ThinkPad
 */
@Entity
@Table(name = "DEMANDE_ANNULATION_MED")
@NamedQueries({
    @NamedQuery(name = "DemandeAnnulationMed.findAll", query = "SELECT d FROM DemandeAnnulationMed d"),
    @NamedQuery(name = "DemandeAnnulationMed.findById", query = "SELECT d FROM DemandeAnnulationMed d WHERE d.id = :id"),
    @NamedQuery(name = "DemandeAnnulationMed.findByDemandeDe", query = "SELECT d FROM DemandeAnnulationMed d WHERE d.demandeDe = :demandeDe"),
    @NamedQuery(name = "DemandeAnnulationMed.findByRaison", query = "SELECT d FROM DemandeAnnulationMed d WHERE d.raison = :raison")})
public class DemandeAnnulationMed implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "DEMANDE_DE")
    private String demandeDe;
    @Column(name = "RAISON")
    private String raison;
    @JoinColumn(name = "NUMERO_RESA", referencedColumnName = "NUMERO")
    @ManyToOne(optional = false)
    private Reservations numeroResa;

    public DemandeAnnulationMed() {
    }

    public DemandeAnnulationMed(BigDecimal id) {
        this.id = id;
    }

    public DemandeAnnulationMed(BigDecimal id, String demandeDe) {
        this.id = id;
        this.demandeDe = demandeDe;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

    public Reservations getNumeroResa() {
        return numeroResa;
    }

    public void setNumeroResa(Reservations numeroResa) {
        this.numeroResa = numeroResa;
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
        if (!(object instanceof DemandeAnnulationMed)) {
            return false;
        }
        DemandeAnnulationMed other = (DemandeAnnulationMed) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.DemandeAnnulationMed[ id=" + id + " ]";
    }
    
}
