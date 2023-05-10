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
@Table(name = "CONSULTATIONS")
@NamedQueries({
    @NamedQuery(name = "Consultations.findAll", query = "SELECT c FROM Consultations c"),
    @NamedQuery(name = "Consultations.findByIdConsultation", query = "SELECT c FROM Consultations c WHERE c.idConsultation = :idConsultation"),
    @NamedQuery(name = "Consultations.findByResultat", query = "SELECT c FROM Consultations c WHERE c.resultat = :resultat"),
    @NamedQuery(name = "Consultations.findByTraitement", query = "SELECT c FROM Consultations c WHERE c.traitement = :traitement"),
    @NamedQuery(name = "Consultations.findByRecommandation", query = "SELECT c FROM Consultations c WHERE c.recommandation = :recommandation"),
    @NamedQuery(name = "Consultations.findByNotqualite", query = "SELECT c FROM Consultations c WHERE c.notqualite = :notqualite"),
    @NamedQuery(name = "Consultations.findByNotponctualite", query = "SELECT c FROM Consultations c WHERE c.notponctualite = :notponctualite")})
public class Consultations implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CONSULTATION")
    private BigDecimal idConsultation;
    @Column(name = "RESULTAT")
    private String resultat;
    @Column(name = "TRAITEMENT")
    private String traitement;
    @Column(name = "RECOMMANDATION")
    private String recommandation;
    @Column(name = "NOTQUALITE")
    private Short notqualite;
    @Column(name = "NOTPONCTUALITE")
    private Short notponctualite;
    @JoinColumn(name = "NUMERO_RESA", referencedColumnName = "NUMERO")
    @ManyToOne(optional = false)
    private Reservations numeroResa;

    public Consultations() {
    }

    public Consultations(BigDecimal idConsultation) {
        this.idConsultation = idConsultation;
    }

    public BigDecimal getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(BigDecimal idConsultation) {
        this.idConsultation = idConsultation;
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

    public Short getNotqualite() {
        return notqualite;
    }

    public void setNotqualite(Short notqualite) {
        this.notqualite = notqualite;
    }

    public Short getNotponctualite() {
        return notponctualite;
    }

    public void setNotponctualite(Short notponctualite) {
        this.notponctualite = notponctualite;
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
        hash += (idConsultation != null ? idConsultation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultations)) {
            return false;
        }
        Consultations other = (Consultations) object;
        if ((this.idConsultation == null && other.idConsultation != null) || (this.idConsultation != null && !this.idConsultation.equals(other.idConsultation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Consultations[ idConsultation=" + idConsultation + " ]";
    }
    
}
