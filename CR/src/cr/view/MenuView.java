/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Stagiaire
 */
public class MenuView {
    GridPane root;
    Text title;
    public Button[] buttons = new Button[6];
    public Label[] label = new Label[6];
    
    public Node getMenuView(){
        root = new GridPane();
        title = new Text("Gestion des comptes rendus");
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        String[] labelText = {"None", "Comptes-Rendus", "Visiteurs", "Praticiens", "Médicaments", "Quitter"};
        for(int i=0; i<6; i++){
                buttons[i] = new Button();
                root.add(buttons[i], 0, i);
                label[i] = new Label(labelText[i]);
                root.add(label[i], 1, i);
            }
        root.getChildren().removeAll(buttons[0],label[0]);
        return root;
    }
}
