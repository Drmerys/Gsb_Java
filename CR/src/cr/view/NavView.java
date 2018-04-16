/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

/**
 *
 * @author Stagiaire
 */
public class NavView {
    HBox navigation;
    Button buttonPrevious;
    Button buttonNext;
    Button back;
    Button newRap;
    
    public Node getNavView(){
        navigation = new HBox(10);
        buttonPrevious = new Button("Précédent");
        buttonNext = new Button("Suivant");
        back = new Button("Retour");
        navigation.setAlignment(Pos.CENTER);
        navigation.getChildren().addAll(buttonPrevious, buttonNext, back);
        return navigation;
    }
    
    public Node getRapNavView(){
        navigation = new HBox(10);
        buttonPrevious = new Button("Précédent");
        buttonNext = new Button("Suivant");
        back = new Button("Retour");
        newRap = new Button("Nouveau");
        navigation.setAlignment(Pos.CENTER);
        navigation.getChildren().addAll(buttonPrevious, buttonNext, newRap, back);
        return navigation;
    }
}
