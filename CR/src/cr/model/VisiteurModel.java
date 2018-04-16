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
 * @author Bakary
 */
public class VisiteurModel {
    Connection connect;
    ArrayList resultArray;
    String nom;
    String prenom;
    String adresse;
    String ville;
    String cp;
    String secteur;
    String labo;
    String query;
    
    public VisiteurModel(Connection connect)
    {
        this.connect = connect;
    }
        
    public String getNom()
    {
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getPrenom()
    {
        return prenom;
    }
    
    public void setPrenom(String prenom){
        this.prenom = prenom;
    }
    
    public String getAdresse()
    {
        return adresse;
    }
    
    public void setAdresse(String adresse){
        this.adresse = adresse;
    }
    
    public String getCP(){
        return cp;
    }
    
    public void setCP(String cp){
        this.cp = cp;
    }
    public String getVille()
    {
        return ville;
    }
    
    public void setVille(String ville){
        this.ville = ville;
    }
    
    public String getSecteur()
    {
        return secteur;
    }
    
    public void setSecteur(String secteur){
        this.secteur = secteur;
    }
    
    public String getLabo()
    {
        return labo;
    }
    
    public void setLabo(String labo){
        this.labo = labo;
    }
    
    public void result(){
        // Instance de tableau d'pbjet;//////////
        resultArray = new ArrayList();
        this.query = "SELECT VIS_NOM, VIS_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, SEC_CODE, LAB_CODE "+
                "FROM visiteur "+
                "LEFT JOIN type_visiteur ON visiteur.TYV_CODE=type_visiteur.TYV_CODE";
        
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
            setSecteur(resultArray.get(6).toString());
            setLabo(resultArray.get(7).toString());
            
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
