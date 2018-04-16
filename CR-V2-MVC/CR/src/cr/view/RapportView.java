package cr.view;

import cr.model.RapportModel;
import java.time.LocalDate;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Stagiaire
 */
public class RapportView {
    GridPane root;
    Text title;
    Label[] label = new Label[7];
    TextArea[] textArea = new TextArea[7];
    TextField[] textField = new TextField[7];
    ObservableList<String> itemsVisit;
    ObservableList<String> itemsProduct;
    ComboBox listVisit;
    ComboBox product1;
    ComboBox product2;
    Button details;
    DatePicker date;
    
    public Node getRapportView(RapportModel rapportModel){
        root = new GridPane();
        title = new Text("Rapports de Visite");
        details = new Button("Détails");
        String[] labelText = {"None", "Numéro Rapport", "Praticien", "Date Rapport", "Motif Visite", "Bilan", "Produits présentés"};
        String[] infos = {"None", rapportModel.getNumero(), rapportModel.getPraticien(), rapportModel.getDate(), rapportModel.getMotif(), rapportModel.getBilan()};
        String[] intDate = infos[3].split("/");
        int[] tabDate = new int[3];
        tabDate[0]=Integer.parseInt(intDate[2]);
        tabDate[1]=Integer.parseInt(intDate[1]);
        tabDate[2]=Integer.parseInt(intDate[0]);
        date = new DatePicker(LocalDate.of(tabDate[0], tabDate[1], tabDate[2]));
        
        itemsVisit = FXCollections.observableArrayList (rapportModel.getMotif());
        itemsProduct = FXCollections.observableArrayList ();
        listVisit = new ComboBox(itemsVisit);
        listVisit.getSelectionModel().select(0);
        listVisit.setMouseTransparent(true);
        product1 = new ComboBox(itemsProduct);
        product2 = new ComboBox(itemsProduct);
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
                    textField[i] = new TextField(infos[i]);
                    textField[i].setEditable(false);
                    root.add(textField[i], 1, i);
                    break;
                case 5:
                    textArea[i] = new TextArea(infos[i]);
                    textArea[i].setEditable(false);
                    textArea[i].setWrapText(true);
                    root.add(textArea[i], 1, i);
                    break;
                case 3:
                    date.setMouseTransparent(true);
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
        root.getChildren().removeAll(label[0], textArea[0], textField[0]);
        return root;
    }
}
