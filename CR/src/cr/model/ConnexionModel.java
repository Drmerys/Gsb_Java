/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.model;

import cr.controller.ConnexionController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Alert;

/**
 *
 * @author Stagiaire
 */
public class ConnexionModel{
    String user;
    String passwd;
    String url;
    String id;
    String pw;
    String query;
    String matricule;
    Connection connect;
    
    public char buttonClicked;
    public boolean connected;
    
    public ConnexionModel(Connection connect, String url, String user, String passwd){
        this.connect = connect;
        this.url = url;
        this.user = user;
        this.passwd = passwd;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setPw(String pw){
        this.pw = pw;
    }
    
    
    public boolean connect(){
        System.out.println("modconnect");
        query = "SELECT LOWER(TYV_LIBELLE), VIS_MATRICULE FROM type_visiteur " +
                       "INNER JOIN visiteur ON type_visiteur.TYV_CODE=visiteur.TYV_CODE " +
                       "WHERE VIS_NOM=\""+id+"\" AND LOWER(DATE_FORMAT(VIS_DATEEMBAUCHE, '%d-%b-%Y'))='"+pw+"'";
        try (Statement state = connect.createStatement(); ResultSet result = state.executeQuery(query)){
            if(result.next()){
                user=result.getObject(1).toString();
                matricule=result.getObject(2).toString();
                
                switch (user){
                    case "visiteur":
                        passwd="visite";
                        break;
                    case "delegue":
                        passwd="deleg";
                        break;
                    case "responsable":
                        passwd="respo";
                }
                //connect.close();
                connect = DriverManager.getConnection(url, user, passwd);
                return true;
            }
            else{
                return false;
            }
        }
        catch (Exception e){
            Alert error = new Alert(Alert.AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
            e.printStackTrace();
            return false;
        }
    }

}
