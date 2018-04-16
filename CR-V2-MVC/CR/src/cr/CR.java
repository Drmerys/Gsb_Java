/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr;

import cr.controller.Controller;
import cr.model.Model;
import cr.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Lucille
 */
public class CR extends Application {
    
        public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        View view = new View();
        Model model = new Model();
        primaryStage.setTitle("GSB - Gestion des Comptes-Rendus");
        primaryStage.setScene(view.getConnexionScene());
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.show();
        
        new Controller(view, model, primaryStage).start();
    }
}
/*
    
    protected Scene visiteur(){ //Page de détail des visiteurs
        if(check){
            GridPane root = new GridPane();
            root.setAlignment(Pos.CENTER);
            root.setHgap(10);
            root.setVgap(10);
            root.setPadding(new Insets(25,25,25,25));

            Text title = new Text("Visiteurs");
            title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            root.add(title, 0, 0, 2, 1);

            Label labelSearch = new Label("Chercher");
            root.add(labelSearch, 0, 1);
            TextField textSearch = new TextField();
            Button ok = new Button("OK");
            ok.setOnAction((ActionEvent e) -> {
               visArray = connect.result("visiteur",textSearch.getText());
               stage.setScene(visiteur());
            });
            HBox hBox = new HBox(10);
            hBox.getChildren().addAll(textSearch, ok);
            root.add(hBox, 1, 1);

            Label labelName = new Label("Nom");
            root.add(labelName, 0, 2);
            TextField textName = new TextField();
            textName.setText(visArray.get(0).toString());
            textName.setEditable(false);
            root.add(textName, 1, 2);

            Label labelFirstName = new Label("Prénom");
            root.add(labelFirstName, 0, 3);
            TextField textFirstName = new TextField();
            textFirstName.setText(visArray.get(1).toString());
            textFirstName.setEditable(false);
            root.add(textFirstName, 1, 3);

            Label labelAdress = new Label("Adresse");
            root.add(labelAdress, 0, 4);
            TextField textAdress = new TextField();
            textAdress.setText(visArray.get(2).toString());
            textAdress.setEditable(false);
            root.add(textAdress, 1, 4);

            Label labelCity = new Label("Ville");
            root.add(labelCity, 0, 5);
            TextField textZip = new TextField();
            textZip.setText(visArray.get(3).toString());
            textZip.setEditable(false);
            TextField textCity = new TextField();
            textCity.setText(visArray.get(4).toString());
            textCity.setEditable(false);
            HBox city = new HBox(10);
            city.getChildren().addAll(textZip, textCity);
            root.add(city, 1, 5);

            Label labelSector = new Label("Secteur");
            root.add(labelSector, 0, 6);
            TextField textSector = new TextField();
            textSector.setText(visArray.get(5).toString());
            textSector.setEditable(false);
            root.add(textSector, 1, 6);

            Label labelLab = new Label("Labo");
            root.add(labelLab, 0, 7);
            TextField textLab = new TextField();
            textLab.setText(visArray.get(6).toString());
            textLab.setEditable(false);
            root.add(textLab, 1, 7);

            Button previous = new Button("Précédent");
            if(!connect.lessItem()){
                previous.setDisable(true);
            }
            previous.setOnAction((ActionEvent e) -> {
               connect.delItem();
               visArray = connect.result("visiteur","");
               stage.setScene(visiteur());
            });
            Button next = new Button("Suivant");
            if(!connect.moreItem(visArray)){
                next.setDisable(true);
            }
            next.setOnAction((ActionEvent e) -> {
               connect.addItem(visArray);
               visArray = connect.result("visiteur","");
               stage.setScene(visiteur());
            });
            Button back = new Button("Retour");
            back.setOnAction((ActionEvent e)-> {
                stage.setScene(menu()); 
            });
            HBox navigation = new HBox(10);
            navigation.getChildren().addAll(previous, next, back);
            root.add(navigation, 0, 8, 2, 1);

            return new Scene(root, 600, 600);
        }
        else {
            return connexion();
        }
    }
    
    protected Scene rapport(boolean newRap){
        if (check){
            GridPane root = new GridPane();
            root.setAlignment(Pos.CENTER);
            root.setHgap(10);
            root.setVgap(10);
            root.setPadding(new Insets(25,25,25,25));

            Text title = new Text("Rapports de Visite");
            title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            root.add(title, 0, 0, 2, 1);

            Label labelNumber = new Label("Numéro Rapport");
            labelNumber.setDisable(true);
            root.add(labelNumber, 0, 1);
            TextField textNumber = new TextField("(Nouv.)");
            textNumber.setDisable(true);
            root.add(textNumber, 1, 1);

            Label labelDoctor = new Label("Numéro Praticien");
            root.add(labelDoctor, 0, 2);
            TextField textDoctor = new TextField();
            Button details = new Button("Détails");
            details.setOnAction((ActionEvent e) ->{
               praArray = connect.result("praticien", rapArray.get(2).toString());
               stage.setScene(praticien());
            });
            HBox hBox = new HBox(10);
            hBox.getChildren().addAll(textDoctor, details);
            root.add(hBox, 1, 2);

            Label labelDate = new Label("Date Rapport");
            root.add(labelDate, 0, 3);
            DatePicker date = new DatePicker();
            TextField textDate = new TextField();
            date.setTooltip(new Tooltip("Format JJ/MM/AAAA"));
            root.add(date, 1, 3);

            Label labelVisit = new Label("Motif Visite");
            root.add(labelVisit, 0, 4);
            ObservableList<String> itemsVisit = FXCollections.observableArrayList (motArray);
            ComboBox listVisit = new ComboBox(itemsVisit);
            listVisit.setStyle("-fx-font-weight: bold; -fx-opacity: 1.0;");
            int select = (connect.getElements(rapArray)>0&&isNumeric(rapArray.get(4).toString()))?Integer.parseInt(rapArray.get(4).toString())-1:4;
            listVisit.getSelectionModel().select(select);
            TextField textVisit = new TextField();
            textVisit.setDisable(true);
            listVisit.valueProperty().addListener((obs, oldItem, newItem) ->{
                if(newItem==motArray.get(4).toString()){
                    textVisit.setDisable(false);
                }
            });
            HBox visit = new HBox(10);
            visit.getChildren().addAll(listVisit, textVisit);
            root.add(visit, 1, 4, 2, 1);

            Label labelResult = new Label("Bilan");
            root.add(labelResult, 0, 5);
            TextArea textResult = new TextArea();
            textResult.setWrapText(true);
            textResult.setPrefHeight(100);
            textResult.setPrefWidth(50);
            root.add(textResult, 1, 5, 2, 2);

            Label labelProduct = new Label("Produits présentés");
            root.add(labelProduct, 0, 7);
            ObservableList<String> itemsProduct = FXCollections.observableArrayList (namArray);
            ComboBox product1 = new ComboBox(itemsProduct);
            product1.setPromptText("Produit 1");
            root.add(product1, 1, 7);
            ComboBox product2 = new ComboBox(itemsProduct);
            product2.setPromptText("Produit 2");
            root.add(product2, 1, 8);


            
            if (!newRap){
                textNumber.setText(rapArray.get(0).toString());
                textNumber.setEditable(false);
                textDoctor.setText(rapArray.get(1).toString());
                textDoctor.setEditable(false);
                root.getChildren().remove(date);
                root.add(textDate, 1, 3);
                textDate.setText(rapArray.get(2).toString());
                textDate.setEditable(false);
                int index=((isNumeric(rapArray.get(3).toString())))?Integer.parseInt(rapArray.get(3).toString())-1:4;
                listVisit.getSelectionModel().select(index);
                listVisit.setDisable(true);
                String tVisit = ((!"N/A".equals(rapArray.get(4).toString())))?rapArray.get(5).toString():"";
                textVisit.setText(tVisit);
                textResult.setText(rapArray.get(5).toString());
                textResult.setEditable(false);
                Button buttonNew = new Button("Nouveau");
                buttonNew.setOnAction((ActionEvent e) ->{
                    listVisit.getSelectionModel().select(0);
                    stage.setScene(rapport(true)); 
                });
                navigation.getChildren().add(buttonNew);
            }
            else {
                Button submit = new Button("Valider");
                submit.setOnAction((ActionEvent e) ->{
                    
                    Alert empty = new Alert(AlertType.ERROR); //création d'une boîte de dialogue d'erreur au cas où
                    empty.setTitle("Formulaire incomplet");
                    empty.setHeaderText("Il manque des informations");
                    empty.setContentText("Merci de remplir tous les champs avant de valider.");
                    
                    int praticien = (isNumeric(textDoctor.getText()))?Integer.parseInt(textDoctor.getText()):0; //récupération des infos en vérifiant le format
                    String tDate = (date.getValue()!=null)?date.getValue().toString():"";
                    String bilan = textResult.getText();
                    String motif = (!"".equals(textVisit.getText()))?textVisit.getText():"NULL";
                    int nbMotif = listVisit.getSelectionModel().getSelectedIndex()+1;
                    
                    if(praticien>0 && !"".equals(tDate) && !"".equals(bilan)){
                        if(nbMotif==5 && !"NULL".equals(motif) || nbMotif<5){
                            connect.insert(praticien, tDate, bilan, nbMotif, motif);
                            stage.setScene(rapport(false));
                        }
                        else {
                            empty.showAndWait();
                        }
                    }
                    else {
                        empty.showAndWait();
                    }
                });
                navigation.getChildren().add(submit);
            }

            return new Scene(root, 600, 600);
        }
        else {
            return connexion();
        }
    }
    */
    

