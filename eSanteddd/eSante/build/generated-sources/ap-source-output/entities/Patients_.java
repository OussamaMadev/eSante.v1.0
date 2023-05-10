package entities;

import entities.Reservations;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-10T06:01:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Patients.class)
public class Patients_ { 

    public static volatile CollectionAttribute<Patients, Reservations> reservationsCollection;
    public static volatile SingularAttribute<Patients, Date> dateNaissance;
    public static volatile SingularAttribute<Patients, String> adresse;
    public static volatile SingularAttribute<Patients, String> telephone;
    public static volatile SingularAttribute<Patients, String> nom;
    public static volatile SingularAttribute<Patients, String> prenom;
    public static volatile SingularAttribute<Patients, String> email;
    public static volatile SingularAttribute<Patients, BigDecimal> nss;

}