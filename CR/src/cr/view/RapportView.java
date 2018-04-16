/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.view;

import cr.model.RapportModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Stagiaire
 */
public class RapportView {
    GridPane root;
    Text title;
    Label[] label = new Label[7];
    TextArea[] textArea = new TextArea[6];
    ObservableList<String> itemsVisit = FXCollections.observableArrayList ();
    ObservableList<String> itemsProduct = FXCollections.observableArrayList ();
    ComboBox listVisit = new ComboBox(itemsVisit);
    ComboBox product1 = new ComboBox(itemsProduct);
    ComboBox product2 = new ComboBox(itemsProduct);
    Button details = new Button("Détails");
    DatePicker date = new DatePicker();
    
    public Node getRapportView(RapportModel rapportModel){
        root = new GridPane();
        title = new Text("Rapports de Visite");
        String[] labelText = {"None", "Numéro Rapport", "Praticien", "Date Rapport", "Motif Visite", "Bilan", "Produits présentés"};
        String[] infos = {"None", rapportModel.getNumero(), rapportModel.getPraticien(), rapportModel.getDate(), rapportModel.getMotif(), rapportModel.getBilan()};
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(title, 0, 0, 2, 1);
        for(int i=0; i<7; i++){
            label[i] = new Label(labelText[i]);
            root.add(label[i], 0, i);
            switch (i) {
                case 1:
                case 2:
                case 5:
                    textArea[i] = new TextArea();
                    textArea[i].setText(infos[i]);
                    root.add(textArea[i], 1, i);
                    break;
                case 3:
                    root.add(date, 1, i);
                    break;
                case 4:
                    root.add(listVisit, 1, i);
                    break;
                case 6:
                    root.add(product1, 1, i);
                    break;
                default:
                    break;
            }
        }
        root.add(product2, 1, 8);
        return root;
    }
}
