/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ThinkPad
 */
public class ESante {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        
     
        Employes user = new Employes();
        user=Employes.getByCode(43543);
        
        ArrayList<Reservations> reservations = Reservations.getByEmploye(user.getCode());

        for (Reservations r : reservations) {
            System.out.println("Reservation #" + r.getNumero());
            System.out.println("Date: " + r.getDateResa());
            System.out.println("Date de prise: " + r.getDateDePrend());
            System.out.println("Type: " + r.getTypeResa());
            System.out.println("Service: " + r.getServiceResa());
            System.out.println("Description: " + r.getDescRes());
            System.out.println("NSS: " + r.getNss());
            System.out.println("Code: " + r.getCode());
            System.out.println("Payé: " + r.getPayed());
            System.out.println("-----------------------------------");
        }

    }
}
