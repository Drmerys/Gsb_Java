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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Stagiaire
 */
public class ConnexionView {
    BorderPane borderpane;
    GridPane root;
    Text title;
    public TextField userName;
    public PasswordField passWord;
    public Button ok;
    
    public Node getConnexionView(){
        root = new GridPane();
        title = new Text();
        userName = new TextField();
        passWord = new PasswordField();
        ok = new Button("OK");
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        title.setText("Identifiez-vous");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(title, 0, 0, 2, 1);
        root.add(userName, 0, 1);
        root.add(passWord, 0, 2);
        root.add(ok, 1, 2);
        return root;
    } 
}
