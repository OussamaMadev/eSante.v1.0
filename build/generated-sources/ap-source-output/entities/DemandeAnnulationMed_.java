package entities;

import entities.Reservations;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-05-10T06:01:03", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(DemandeAnnulationMed.class)
public class DemandeAnnulationMed_ { 

    public static volatile SingularAttribute<DemandeAnnulationMed, String> demandeDe;
    public static volatile SingularAttribute<DemandeAnnulationMed, String> raison;
    public static volatile SingularAttribute<DemandeAnnulationMed, BigDecimal> id;
    public static volatile SingularAttribute<DemandeAnnulationMed, Reservations> numeroResa;

}