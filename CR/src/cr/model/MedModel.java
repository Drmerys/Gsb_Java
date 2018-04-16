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
public class MedModel{
    private String query;
    private final Connection connect;
    ArrayList resultArray;
    String code;
    String nom;
    String fam;
    String compo;
    String effets;
    String contrindic;
    String prix;
    public MedModel(Connection connect){
        this.connect = connect;    
    }
    
    public void setCode(String code){
        this.code = code;
    }
    
    public String getCode(){
        return code;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setFam(String fam){
        this.fam = fam;
    }
    
    public String getFam(){
        return fam;
    }
    
    public void setCompo(String compo){
        this.compo = compo;
    }
    
    public String getCompo(){
        return compo;
    }
    
    public void setEffets(String effets){
        this.effets = effets;
    }
    
    public String getEffets(){
        return effets;
    }
    
    public void setContrindic(String contrindic){
        this.contrindic = contrindic;
    }
    
    public String getContrindic(){
        return contrindic;
    }
    
    public void setPrix(String prix){
        this.prix = prix;
    }
    
    public String getPrix(){
        return prix;
    }
    
    public void result(){
        resultArray = new ArrayList();
        this.query = "SELECT MED_DEPOTLEGAL, MED_NOMCOMMERCIAL, FAM_LIBELLE, MED_COMPOSITION, MED_EFFET, MED_CONTREINDIC, MED_PRIXECHANTILLON "+
                     "FROM medicament LEFT JOIN famille ON medicament.FAM_CODE=famille.FAM_CODE";
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
            setFam(resultArray.get(2).toString());
            setCompo(resultArray.get(3).toString());
            setEffets(resultArray.get(4).toString());
            setContrindic(resultArray.get(5).toString());
            setPrix(resultArray.get(6).toString());
            setCode(resultArray.get(7).toString());
        }
        catch(Exception e){
            e.printStackTrace();
            Alert error = new Alert(AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText("Erreur");
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
        }
    }    
}
