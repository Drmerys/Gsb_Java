package cr.controller;

import cr.model.MedModel;
import cr.model.Model;
import cr.model.PraticienModel;
import cr.model.RapportModel;
import cr.model.VisiteurModel;
import cr.view.View;
import java.util.Observable;
import java.util.Observer;
import javafx.scene.Scene;
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
    Scene medScene;
    Scene praticienScene;
    Scene rapportScene;
    Scene visiteurScene;
    
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
            NavController navCT;
            switch (clickedButtonValue) {
                case 'M':
                    MedModel medModel = model.medModel;
                    stage.setScene(view.getMedScene(medModel));
                    medScene = stage.getScene();
                    navCT = new NavController(view.navView, model.navModel);
                    setObservers(navCT);
                    break;
                case 'P':
                    PraticienModel praticienModel = model.praticienModel;
                    stage.setScene(view.getPraticienScene(praticienModel));
                    praticienScene = stage.getScene();
                    navCT = new NavController(view.navView, model.navModel);
                    setObservers(navCT);
                    break;
                case 'V':
                    VisiteurModel visiteurModel = model.visiteurModel;
                    stage.setScene(view.getVisiteurScene(visiteurModel));
                    visiteurScene = stage.getScene();
                    navCT = new NavController(view.navView, model.navModel);
                    setObservers(navCT);
                    break;
                case 'C':
                    RapportModel rapportModel = model.rapportModel;
                    stage.setScene(view.getRapportScene(rapportModel));
                    rapportScene = stage.getScene();
                    navCT = new NavController(view.navView, model.navModel);
                    setObservers(navCT);
                    break;
                case 'Q':
                    System.exit(0);
                default:
                    break;
            }
        }
        else if(o instanceof NavController){
            char clickedButtonValue = ( (NavController) o).buttonClicked;
            NavController navCT;
            switch (clickedButtonValue) {
                case 'R':
                    stage.setScene(view.getMenuScene());
                    MenuController menuCT = new MenuController(view.menuView, model.menuModel);
                    setObservers(menuCT);
                    break;
                case 'P':
                    if(stage.getScene()==medScene){
                        if(model.medModel.getIndex()>1){
                            model.setMedModel(model.medModel.getIndex()-7);
                            stage.setScene(view.getMedScene(model.medModel));
                            medScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    else if(stage.getScene()==praticienScene){
                        if(model.praticienModel.getIndex()>1){
                            model.setPraticienModel(model.praticienModel.getIndex()-8);
                            stage.setScene(view.getPraticienScene(model.praticienModel));
                            praticienScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    else if(stage.getScene()==rapportScene){
                        if(model.rapportModel.getIndex()>1){
                            model.setRapportModel(model.rapportModel.getIndex()-6);
                            stage.setScene(view.getRapportScene(model.rapportModel));
                            rapportScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    else if(stage.getScene()==visiteurScene){
                        if(model.visiteurModel.getIndex()>1){
                            model.setVisiteurModel(model.visiteurModel.getIndex()-7);
                            stage.setScene(view.getVisiteurScene(model.visiteurModel));
                            visiteurScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    break;
                case 'S':
                    if(stage.getScene()==medScene){
                        if(model.medModel.getIndex()<model.medModel.getLength()){
                            model.setMedModel(model.medModel.getIndex()+7);
                            stage.setScene(view.getMedScene(model.medModel));
                            medScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    else if(stage.getScene()==praticienScene){
                        if(model.praticienModel.getIndex()<model.praticienModel.getLength()){
                            model.setPraticienModel(model.praticienModel.getIndex()+8);
                            stage.setScene(view.getPraticienScene(model.praticienModel));
                            praticienScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    else if(stage.getScene()==rapportScene){
                        if(model.rapportModel.getIndex()<model.rapportModel.getLength()){
                            model.setRapportModel(model.rapportModel.getIndex()+6);
                            stage.setScene(view.getRapportScene(model.rapportModel));
                            rapportScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    else if(stage.getScene()==visiteurScene){
                        if(model.visiteurModel.getIndex()<model.visiteurModel.getLength()){
                            model.setVisiteurModel(model.visiteurModel.getIndex()+7);
                            stage.setScene(view.getVisiteurScene(model.visiteurModel));
                            visiteurScene = stage.getScene();
                            navCT = new NavController(view.navView, model.navModel);
                            setObservers(navCT);
                        }
                    }
                    break;
                case 'N':
                    //scene rapport vide
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
    
    public void setObservers (NavController navCT){
        navCT.addObserver(this);
        navCT.run();
    }
}
