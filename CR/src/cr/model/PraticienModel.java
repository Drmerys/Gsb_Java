/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Stagiaire
 */
public class PraticienModel {
    Connection connect;
    ArrayList resultArray;
    String query;
    String numero;
    String nom;
    String prenom;
    String adresse;
    String cp;
    String ville;
    String notoriete;
    String exercice;
    
    public PraticienModel(Connection connect){
        this.connect = connect;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public String getAdresse(){
        return adresse;
    }
    
    public void setCP(String cp){
        this.cp = cp;
    }
    
    public String getCP(){
        return cp;
    }
    
    public void setVille(String ville){
        this.ville = ville;
    }
    
    public String getVille(){
        return ville;
    }
    
    public void setNotoriete(String notoriete){
        this.notoriete = notoriete;
    }
    
    public String getNotoriete(){
        return notoriete;
    }
    
    public void setExercice(String exercice){
        this.exercice = exercice;
    }
    
    public String getExercice(){
        return exercice;
    }
    
    public void result(){
        resultArray = new ArrayList();
        this.query = "SELECT PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_LIEU "+
                     "FROM praticien "+
                     "LEFT JOIN type_praticien ON praticien.TYP_CODE=type_praticien.TYP_CODE";
            
        try (Statement state = connect.createStatement(); ResultSet result = state.executeQuery(query)){
            while (result.next()){
                ResultSetMetaData resultMeta = result.getMetaData();
                for(int i=1; i<=resultMeta.getColumnCount();i++){
                    if(result.getObject(i)!=null){
                        resultArray.add(result.getObject(i).toString());
                    }
                    else {
                        resultArray.add("N/A");
                    }
                }
            }
            setNom(resultArray.get(1).toString());
            setPrenom(resultArray.get(2).toString());
            setAdresse(resultArray.get(3).toString());
            setCP(resultArray.get(4).toString());
            setVille(resultArray.get(5).toString());
            setNotoriete(resultArray.get(6).toString());
            setExercice(resultArray.get(7).toString());
            setNumero(resultArray.get(8).toString());
        }
        catch(Exception e){
            e.printStackTrace();
            Alert error = new Alert(AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
        }
    }
}
