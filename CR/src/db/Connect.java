/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Lucille
 */
public class Connect {
    private String user;
    private String passwd;
    private String matricule;
    private final String url;
    Connection connect;
    //private String query;
    //private int item = 0;
    
    public Connect(){
        this.user="root";
        this.passwd="root";
        this.url="jdbc:mysql://localhost:8889/gestion_cr";
    }
    
    public void setup(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver OK");
            
            this.connect = DriverManager.getConnection(url, user, passwd);
        }
        catch (Exception e){
            Alert error = new Alert(AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
            e.printStackTrace();
        }
    }
    
    /*public static boolean isNumeric(String str)  
    {  
      try  
      {  
        double d = Double.parseDouble(str);  
      }  
      catch(NumberFormatException nfe)  
      {  
        return false;  
      }  
      return true;  
    }
    
    
    
    public ArrayList result(String cat, String code){
        ArrayList resultArray = new ArrayList();
        this.query = "SELECT ";
        if("motif".equals(cat)){
            query+="TYM_LIBELLE "+
                   "FROM type_motif";
        }
        else if("medname".equals(cat)){
            query+="MED_DEPOTLEGAL "+
                   "FROM medicament";
        }
        else {
            switch (cat){
                case "visiteur":
                    query+="VIS_NOM, VIS_PRENOM, VIS_ADRESSE, VIS_CP, VIS_VILLE, SEC_LIBELLE, LAB_NOM "+
                           "FROM visiteur "+
                           "LEFT JOIN secteur ON visiteur.SEC_CODE=secteur.SEC_CODE "+
                           "LEFT JOIN labo ON visiteur.LAB_CODE=labo.LAB_CODE";
                    cat="VIS_NOM";
                    break;
                case "praticien":
                    query+="PRA_NUM, PRA_NOM, PRA_PRENOM, PRA_ADRESSE, PRA_CP, PRA_VILLE, PRA_COEFNOTORIETE, TYP_LIEU "+
                           "FROM praticien "+
                           "LEFT JOIN type_praticien ON praticien.TYP_CODE=type_praticien.TYP_CODE";
                    cat="PRA_NUM";
                    break;
                case "medicament":
                    query+="MED_DEPOTLEGAL, MED_NOMCOMMERCIAL, FAM_LIBELLE, MED_COMPOSITION, MED_EFFET, MED_CONTREINDIC "+
                           "FROM medicament "+
                           "LEFT JOIN famille ON medicament.FAM_CODE=famille.FAM_CODE";
                    cat="MED_DEPOTLEGAL";
                    break;
                case "rapport":
                    query+="RAP_NUM, PRA_NUM, DATE_FORMAT(RAP_DATE, '%d/%m/%Y'), TYM_CODE, RAP_MOTIF, RAP_BILAN "+
                           "FROM rapport_visite ";
                    cat="RAP_NUM";
                    break;
                case "motif":
                    query+="TYM_LIBELLE "+
                           "FROM type_motif";
                    cat="TYM_LIBELLE";
                    break;
            }
            if(!"".equals(code)){
                switch (cat){
                    case "VIS_NOM":
                        query+=" WHERE LOWER(VIS_NOM) LIKE LOWER(\"%"+code+
                               "%\") OR LOWER(VIS_PRENOM) LIKE LOWER(\"%"+code+
                               "%\") OR LOWER(VIS_MATRICULE) LIKE LOWER(\"%"+code+"%\")";
                        break;
                    case "PRA_NUM":
                        query+=" WHERE LOWER(PRA_NOM) LIKE LOWER(\"%"+code+
                               "%\") OR LOWER(PRA_PRENOM) LIKE LOWER(\"%"+code+"%\")";
                        if(isNumeric(code)){
                            query+=" OR PRA_NUM="+code;
                        }
                        break;
                    case "MED_DEPOTLEGAL":
                        query+=" WHERE LOWER(MED_DEPOTLEGAL) LIKE LOWER(\"%"+code+
                               "%\") OR LOWER(MED_NOMCOMMERCIAL) LIKE LOWER(\"%"+code+"%\")";
                        break;
                    case "RAP_NUM":
                        query+=" WHERE PRA_NUM="+code;
                        break;
                }
            }
            else {
                query+=" ORDER BY "+cat+" LIMIT "+item+",1";
            }
        }
        try (Statement state = connect.createStatement(); ResultSet result = state.executeQuery(query)){
            int k=1;
            while (result.next()){
                ResultSetMetaData resultMeta = result.getMetaData();
                if("motif".equals(cat) || "medname".equals(cat)){
                    resultArray.add(result.getObject(1).toString());
                    k++;
                }
                else{
                    for(int i=1; i<=resultMeta.getColumnCount();i++){
                        if(result.getObject(i)!=null){
                            resultArray.add(result.getObject(i).toString());
                        }
                        else {
                            resultArray.add("N/A");
                        }
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
            Alert error = new Alert(AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
        }
        return resultArray;
    }
    
    public void insert(int praticien, String date, String bilan, int nbMotif, String motif){
        int numRap;
        this.query="SELECT MAX(RAP_NUM) FROM rapport_visite";
        try (Statement state = connect.createStatement(); ResultSet result = state.executeQuery(query)){
            if(result.next()){
                numRap = Integer.parseInt(result.getObject(1).toString())+1;
                this.query="INSERT INTO rapport_visite VALUES ("+
                        matricule+","+numRap+","+praticien+","+
                        "'"+date+"',\""+bilan+"\","+nbMotif+",\""+motif+"\")";
                Statement insert = connect.createStatement();
                insert.executeUpdate(query);
                Alert success = new Alert(AlertType.INFORMATION);
                success.setTitle("Rapport ajouté");
                success.setHeaderText("Ajout effectué");
                success.setContentText("Le rapport a bien été ajouté.");
                success.showAndWait();
                
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Alert error = new Alert(AlertType.WARNING);
            error.setTitle("Erreur");
            error.setHeaderText(null);
            error.setContentText("Une erreur a été rencontrée, veuillez réessayer plus tard.");
            error.showAndWait();
        }
        
    }
    
    public void addItem(ArrayList resultArray){
        Iterator e = resultArray.iterator();
        if(e.hasNext()){
            this.item++;
        }
    }
    
    public void delItem(){
        if(item>0){
            this.item--;  
        }
    }
    
    public void resetItem(){
        this.item=0;
    }
    
    public boolean moreItem(ArrayList resultArray){
        return !"N/A".equals(resultArray.get(1).toString());
    }
    
    public boolean lessItem(){
        return item>0;
    }
    
    public int getElements(ArrayList resultArray){
        return resultArray.size();
    }*/
}
