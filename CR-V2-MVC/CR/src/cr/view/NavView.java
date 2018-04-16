package cr.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 *
 * @author Stagiaire
 */
public class NavView {
    HBox navigation;
    public Button[] buttons = new Button[4];
    
    public Node getNavView(){
        navigation = new HBox(10);
        navigation.setAlignment(Pos.CENTER);
        String[] label = {"Précédent", "Suivant", "Retour", "Null"};
        for (int i=0; i<label.length; i++){
            buttons[i] = new Button(label[i]);
            navigation.getChildren().add(buttons[i]);
        }
        navigation.getChildren().remove(buttons[3]);
        return navigation;
    }
    
    public Node getRapNavView(){
        navigation = new HBox(10);
        navigation.setAlignment(Pos.CENTER);
        String[] label = {"Précédent", "Suivant", "Retour", "Nouveau"};
        for (int i=0; i<label.length; i++){
            buttons[i] = new Button(label[i]);
            navigation.getChildren().add(buttons[i]);
        }
        return navigation;
    }
}
