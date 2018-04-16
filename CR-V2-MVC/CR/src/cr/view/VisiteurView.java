package cr.view;

import cr.model.VisiteurModel;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class VisiteurView {
    
    GridPane root;
    Text title;
    Label[] label = new Label[8];
    TextField[] textField = new TextField[9];
    Button ok = new Button("OK");
    
    public Node getVisiteurView(VisiteurModel visiteurModel){
        root = new GridPane();
        title = new Text("Visiteurs");
        title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        root.add(title, 0, 0, 2, 1);
        root.add(ok, 2, 1);
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25,25,25,25));
        String[] infos = {"None", "None", visiteurModel.getNom(), visiteurModel.getPrenom(),visiteurModel.getAdresse(),
                          visiteurModel.getVille()+" - "+ visiteurModel.getCP(), visiteurModel.getSecteur(), visiteurModel.getLabo()};
        String[] labelText = {"None", "Chercher", "Nom", "Prénom", "Adresse", "Ville", "Secteur", "Labo"};
        for(int i = 0; i < 8; i++){
        label[i] = new Label(labelText[i]);
        root.add(label[i], 0, i);
        textField[i] = new TextField();
        textField[i].setText(infos[i]);
        textField[i].setEditable(false);
        root.add(textField[i], 1, i, 2, 1);
        }
        root.getChildren().removeAll(label[0], label[1], textField[0], textField[1]);
        textField[1].setText("");
        textField[1].setEditable(true);
        root.add(label[1], 0, 1, 1, 1);
        root.add(textField[1], 1, 1, 1, 1);
        return root;
    }

}
