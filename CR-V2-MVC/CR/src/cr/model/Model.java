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
    public VisiteurModel visiteurModel;
    
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
            medModel = new MedModel(connect, 0);
            medModel.result();
            menuModel = new MenuModel();
            navModel = new NavModel();
            praticienModel = new PraticienModel(connect, 0);
            praticienModel.result();
            visiteurModel = new VisiteurModel(connect, 0);
            visiteurModel.result();
            rapportModel = new RapportModel(connect, 0);
            rapportModel.result();
        }
        catch (Exception e){
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Erreur de connexion");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée lors de la connexion au serveur, veuillez réessayer plus tard.");
            error.showAndWait();
            System.exit(0);
            e.printStackTrace();
        }
    }
    
    public void setMedModel(int index){
        medModel = new MedModel(connect, index);
        medModel.result();
    }
    
    public void setPraticienModel(int index){
        praticienModel = new PraticienModel(connect, index);
        praticienModel.result();
    }
    
    public void setRapportModel(int index){
        rapportModel = new RapportModel(connect, index);
        rapportModel.result();
    }
    
    public void setVisiteurModel(int index){
        visiteurModel = new VisiteurModel(connect, index);
        visiteurModel.result();
    }
    
    
}
