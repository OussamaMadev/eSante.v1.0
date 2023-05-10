package entities;

import entities.Reservations;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-10T06:01:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Consultations.class)
public class Consultations_ { 

    public static volatile SingularAttribute<Consultations, BigDecimal> idConsultation;
    public static volatile SingularAttribute<Consultations, String> traitement;
    public static volatile SingularAttribute<Consultations, String> recommandation;
    public static volatile SingularAttribute<Consultations, Short> notponctualite;
    public static volatile SingularAttribute<Consultations, Short> notqualite;
    public static volatile SingularAttribute<Consultations, Reservations> numeroResa;
    public static volatile SingularAttribute<Consultations, String> resultat;

}