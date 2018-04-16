/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.view;

import cr.model.MedModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Stagiaire
 */
public class MedView {
    GridPane root;
    Text title;
    Label[] label = new Label[8];
    TextArea[] textArea = new TextArea[8];
    TextField[] textField = new TextField[8];
    
    public Node getMedView(MedModel medModel){
        root = new GridPane();
        title = new Text("Médicaments");
        String[] infos = {"None", medModel.getCode(), medModel.getNom(),
                          medModel.getFam(), medModel.getCompo(),
                          medModel.getEffets(), medModel.getContrindic(), 
                          medModel.getPrix()};
        String[] labelText = {"None", "Code", "Nom commercial", "Famille", "Composition", "Effets indésirables", "Contre-indications", "Prix Echantillon"};
        for (int i=0; i<8; i++){
            label[i] = new Label(labelText[i]);
            root.add(label[i], 0, i); 
            if(i==0 || i==1 || i==2 || i==3 || i==4 || i==7){
                textField[i] = new TextField(infos[i]);
                textField[i].setEditable(false);
                root.add(textField[i], 1, i);
            }
            else {
                textArea[i] = new TextArea(infos[i]);
                textArea[i].setEditable(false);
                textArea[i].setPrefRowCount(3);
                textArea[i].setWrapText(true);
                root.add(textArea[i], 1, i);
            } 
        }
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        title.setTextAlignment(TextAlignment.CENTER);
        root.add(title, 0, 0, 2, 1);
        root.getChildren().removeAll(label[0], textArea[0], textField[0]);
        return root;
    }
}
