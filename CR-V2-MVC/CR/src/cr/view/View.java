package cr.view;

import cr.model.MedModel;
import cr.model.Model;
import cr.model.PraticienModel;
import cr.model.RapportModel;
import cr.model.VisiteurModel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Stagiaire
 */
public class View {
    public ConnexionView connexionView;
    public MenuView menuView;
    public MedView medView;
    public NavView navView;
    public PraticienView praticienView;
    public RapportView rapportView;
    public VisiteurView visiteurView;
    Model model;
    
    public Scene getConnexionScene(){
        StackPane root = new StackPane();
        connexionView = new ConnexionView();
        root.getChildren().add(connexionView.getConnexionView());
        Scene scene = new Scene(root);
        return scene;
    }
    
    public Scene getMenuScene(){
        StackPane root = new StackPane();
        menuView = new MenuView();
        root.getChildren().add(menuView.getMenuView());
        Scene scene = new Scene(root);
        return scene;
    }
    public Scene getMedScene(MedModel medModel){
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        medView = new MedView();
        navView = new NavView();
        root.getChildren().addAll(medView.getMedView(medModel), navView.getNavView());
        Scene scene = new Scene(root);
        return scene;
    }
    
    public Scene getVisiteurScene(VisiteurModel visiteurModel){
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        visiteurView = new VisiteurView();
        navView = new NavView();
        root.getChildren().addAll(visiteurView.getVisiteurView(visiteurModel), navView.getNavView());
        Scene scene = new Scene(root);
        return scene;
    }
    public Scene getPraticienScene(PraticienModel praticienModel){
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        praticienView = new PraticienView();
        navView = new NavView();
        root.getChildren().addAll(praticienView.getPraticienView(praticienModel), navView.getNavView());
        Scene scene = new Scene(root);
        return scene;
    }
    
    public Scene getRapportScene(RapportModel rapportModel){
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        rapportView = new RapportView();
        navView = new NavView();
        root.getChildren().addAll(rapportView.getRapportView(rapportModel), navView.getRapNavView());
        Scene scene = new Scene(root);
        return scene;
    }
}
