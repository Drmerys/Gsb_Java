/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.controller;

import cr.model.MedModel;
import cr.model.Model;
import cr.model.PraticienModel;
import cr.model.RapportModel;
import cr.view.View;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 *
 * @author Stagiaire
 */
public class Controller implements Observer{
    private final Stage stage;
    private final View view;
    private final Model model;
    
    public Controller(View view, Model model, Stage stage){
        this.view = view;
        this.model = model;
        this.stage = stage;
    }
    
    public void start(){
        model.setup();
        ConnexionController connexionCT = new ConnexionController(view.connexionView, model.connexionModel);
        setObservers(connexionCT);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        if (o instanceof ConnexionController){
            char clickedButtonValue = ( (ConnexionController) o).buttonClicked;
            boolean connected = ( (ConnexionController) o).connected;
            if (clickedButtonValue == 'O'){
                if(connected){
                    stage.setScene(view.getMenuScene());
                    MenuController menuCT = new MenuController(view.menuView, model.menuModel);
                    setObservers(menuCT);
                }
                else {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Erreur de connexion");
                    alert.setHeaderText("La connexion a échoué");
                    alert.setContentText("La connexion n'a pas abouti, merci de réessayer.");
                    alert.showAndWait();
                }
            }
        }
        else if(o instanceof MenuController){
            char clickedButtonValue = ( (MenuController) o).buttonClicked;
            switch (clickedButtonValue) {
                case 'M':
                    MedModel medModel = model.medModel;
                    stage.setScene(view.getMedScene(medModel));
                    break;
                case 'P':
                    PraticienModel praticienModel = model.praticienModel;
                    stage.setScene(view.getPraticienScene(praticienModel));
                    break;
                case 'C':
                    RapportModel rapportModel = model.rapportModel;
                    stage.setScene(view.getRapportScene(rapportModel));
                    break;
                case 'Q':
                    System.exit(0);
                default:
                    break;
            }
        }
    }
    
    public void setObservers(ConnexionController connexionCT){
        connexionCT.addObserver(this);
        connexionCT.run();
    }
    
    public void setObservers(MenuController menuCT){
        menuCT.addObserver(this);
        menuCT.run();
    }
}
