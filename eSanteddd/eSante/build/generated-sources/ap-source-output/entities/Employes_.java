package entities;

import entities.Reservations;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-10T06:01:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Employes.class)
public class Employes_ { 

    public static volatile SingularAttribute<Employes, String> secteur;
    public static volatile SingularAttribute<Employes, BigDecimal> code;
    public static volatile CollectionAttribute<Employes, Reservations> reservationsCollection;
    public static volatile SingularAttribute<Employes, String> specialite;
    public static volatile SingularAttribute<Employes, String> nom;
    public static volatile SingularAttribute<Employes, String> prenom;
    public static volatile SingularAttribute<Employes, BigInteger> anciennete;

}