/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.controller;

import cr.model.ConnexionModel;
import cr.view.ConnexionView;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Stagiaire
 */
public class ConnexionController extends Observable{
    private ConnexionView connexionView;
    private ConnexionModel connexionModel;
    
    public char buttonClicked;
    public boolean connected;
    
    public ConnexionController(ConnexionView connexionView, ConnexionModel connexionModel){
        this.connexionView = connexionView;
        this.connexionModel = connexionModel;
    }
    
    public void run(){
        connexionModel.connect();
        listenButton(connexionView.ok, connexionView.userName, connexionView.passWord);
    }
    
    public void listenButton(Button button, TextField id, PasswordField pw){
        button.setOnAction((ActionEvent e) ->{
            connexionModel.setId(id.getText());
            connexionModel.setPw(pw.getText());
            buttonClicked = button.getText().charAt(0);
            connected = connexionModel.connect();
            notifyObservers();
            setChanged();
        });
    }
}
