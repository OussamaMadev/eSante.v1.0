/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package esante;

/**
 *
 * @author ThinkPad
 */
public class ESante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        dataBasecon db = new dataBasecon();
        db.connectToDB();
        db.SQLSelect("select * from employes");
        db.affichresult();
        db.disconect();
    }

}
