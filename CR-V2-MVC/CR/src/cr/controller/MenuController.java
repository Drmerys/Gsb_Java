/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.controller;

import cr.model.MenuModel;
import cr.view.MenuView;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author Stagiaire
 */
public class MenuController extends Observable{
    private MenuView menuView;
    private MenuModel menuModel;
    
    public char buttonClicked;
    
    public MenuController(MenuView menuView, MenuModel menuModel){
        this.menuView = menuView;
        this.menuModel = menuModel;
    }
    
    public void run(){
        listenAllButtons();
    }
    
    public void listenAllButtons(){
        for(int i=0; i<menuView.buttons.length; i++){
            listenButtons(menuView.buttons[i], menuView.label[i]);
        }
    }
    
    public void listenButtons(Button button, Label label){
        button.setOnAction((ActionEvent e) -> {
            updateButtonClicked(label.getText().charAt(0));
        });
    }
    
    public void updateButtonClicked(char buttonClicked){
        this.buttonClicked = buttonClicked;
        setChanged();
        notifyObservers();
    }
    
    
}
