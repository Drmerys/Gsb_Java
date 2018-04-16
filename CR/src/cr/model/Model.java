/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.model;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;

/**
 *
 * @author Stagiaire
 */
public class Model {
    private String user;
    private String passwd;
    private String matricule;
    private final String url;
    private String query;
    private Connection connect;
    
    public ConnexionModel connexionModel;
    public MedModel medModel;
    public MenuModel menuModel;
    public NavModel navModel;
    public PraticienModel praticienModel;
    public RapportModel rapportModel;
    
    public Model(){
        user="root";
        passwd="root";
        url="jdbc:mysql://localhost:8889/gestion_cr";
    }
    
    public void setup(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            
            this.connect = DriverManager.getConnection(url, user, passwd);
            connexionModel = new ConnexionModel(connect, url, user, passwd);
            medModel = new MedModel(connect);
            medModel.result();
            menuModel = new MenuModel();
            navModel = new NavModel();
            praticienModel = new PraticienModel(connect);
            praticienModel.result();
            rapportModel = new RapportModel(connect);
            rapportModel.result();
        }
        catch (Exception e){
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
            System.exit(0);
            e.printStackTrace();
        }
    }
    
    
}
