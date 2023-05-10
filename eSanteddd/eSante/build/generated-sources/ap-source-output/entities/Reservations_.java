package entities;

import entities.Consultations;
import entities.DemandeAnnulationMed;
import entities.Employes;
import entities.Patients;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-10T06:01:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Reservations.class)
public class Reservations_ { 

    public static volatile SingularAttribute<Reservations, Employes> code;
    public static volatile CollectionAttribute<Reservations, Consultations> consultationsCollection;
    public static volatile SingularAttribute<Reservations, BigDecimal> numero;
    public static volatile SingularAttribute<Reservations, String> typeResa;
    public static volatile SingularAttribute<Reservations, String> descres;
    public static volatile SingularAttribute<Reservations, Date> dateResa;
    public static volatile SingularAttribute<Reservations, String> serviceResa;
    public static volatile SingularAttribute<Reservations, Date> dateDeprend;
    public static volatile SingularAttribute<Reservations, BigInteger> payed;
    public static volatile SingularAttribute<Reservations, Patients> nss;
    public static volatile CollectionAttribute<Reservations, DemandeAnnulationMed> demandeAnnulationMedCollection;

}