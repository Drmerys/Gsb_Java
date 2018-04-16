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
public class RapportModel {
    Connection connect;
    String query;
    String numero;
    String praticien;
    String date;
    String motif;
    String bilan;
    ArrayList resultArray;
    
    public RapportModel(Connection connect){
        this.connect = connect;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public void setPraticien(String praticien){
        this.praticien = praticien;
    }
    
    public String getPraticien(){
        return praticien;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setMotif(String motif){
        this.motif = motif;
    }
    
    public String getMotif(){
        return motif;
    }
    
    public void setBilan(String bilan){
        this.bilan = bilan;
    }
    
    public String getBilan(){
        return bilan;
    }
    
    public void result(){
        resultArray = new ArrayList();
        this.query = "SELECT RAP_NUM, PRA_NOM, PRA_PRENOM, DATE_FORMAT(RAP_DATE, '%d/%m/%Y'), TYM_LIBELLE, RAP_BILAN "+
                "FROM rapport_visite "+
                "INNER JOIN type_motif ON rapport_visite.TYM_CODE = type_motif.TYM_CODE "+
                "INNER JOIN praticien ON rapport_visite.PRA_NUM = praticien.PRA_NUM";
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
            setPraticien(resultArray.get(2).toString()+" "+resultArray.get(1).toString());
            setDate(resultArray.get(3).toString());
            setMotif(resultArray.get(4).toString());
            setBilan(resultArray.get(5).toString());
            setNumero(resultArray.get(6).toString());
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
