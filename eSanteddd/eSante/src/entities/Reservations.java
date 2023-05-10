/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "RESERVATIONS")
@NamedQueries({
    @NamedQuery(name = "Reservations.findAll", query = "SELECT r FROM Reservations r"),
    @NamedQuery(name = "Reservations.findByNumero", query = "SELECT r FROM Reservations r WHERE r.numero = :numero"),
    @NamedQuery(name = "Reservations.findByDateResa", query = "SELECT r FROM Reservations r WHERE r.dateResa = :dateResa"),
    @NamedQuery(name = "Reservations.findByDateDeprend", query = "SELECT r FROM Reservations r WHERE r.dateDeprend = :dateDeprend"),
    @NamedQuery(name = "Reservations.findByTypeResa", query = "SELECT r FROM Reservations r WHERE r.typeResa = :typeResa"),
    @NamedQuery(name = "Reservations.findByServiceResa", query = "SELECT r FROM Reservations r WHERE r.serviceResa = :serviceResa"),
    @NamedQuery(name = "Reservations.findByDescres", query = "SELECT r FROM Reservations r WHERE r.descres = :descres"),
    @NamedQuery(name = "Reservations.findByPayed", query = "SELECT r FROM Reservations r WHERE r.payed = :payed")})
public class Reservations implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private BigDecimal numero;
    @Column(name = "DATE_RESA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateResa;
    @Column(name = "DATE_DEPREND")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDeprend;
    @Column(name = "TYPE_RESA")
    private String typeResa;
    @Column(name = "SERVICE_RESA")
    private String serviceResa;
    @Column(name = "DESCRES")
    private String descres;
    @Column(name = "PAYED")
    private BigInteger payed;
    @JoinColumn(name = "CODE", referencedColumnName = "CODE")
    @ManyToOne(optional = false)
    private Employes code;
    @JoinColumn(name = "NSS", referencedColumnName = "NSS")
    @ManyToOne(optional = false)
    private Patients nss;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroResa")
    private Collection<DemandeAnnulationMed> demandeAnnulationMedCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroResa")
    private Collection<Consultations> consultationsCollection;

    public Reservations() {
    }

    public Reservations(BigDecimal numero) {
        this.numero = numero;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public Date getDateResa() {
        return dateResa;
    }

    public void setDateResa(Date dateResa) {
        this.dateResa = dateResa;
    }

    public Date getDateDeprend() {
        return dateDeprend;
    }

    public void setDateDeprend(Date dateDeprend) {
        this.dateDeprend = dateDeprend;
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

    public String getDescres() {
        return descres;
    }

    public void setDescres(String descres) {
        this.descres = descres;
    }

    public BigInteger getPayed() {
        return payed;
    }

    public void setPayed(BigInteger payed) {
        this.payed = payed;
    }

    public Employes getCode() {
        return code;
    }

    public void setCode(Employes code) {
        this.code = code;
    }

    public Patients getNss() {
        return nss;
    }

    public void setNss(Patients nss) {
        this.nss = nss;
    }

    public Collection<DemandeAnnulationMed> getDemandeAnnulationMedCollection() {
        return demandeAnnulationMedCollection;
    }

    public void setDemandeAnnulationMedCollection(Collection<DemandeAnnulationMed> demandeAnnulationMedCollection) {
        this.demandeAnnulationMedCollection = demandeAnnulationMedCollection;
    }

    public Collection<Consultations> getConsultationsCollection() {
        return consultationsCollection;
    }

    public void setConsultationsCollection(Collection<Consultations> consultationsCollection) {
        this.consultationsCollection = consultationsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reservations)) {
            return false;
        }
        Reservations other = (Reservations) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Reservations[ numero=" + numero + " ]";
    }
    
}
