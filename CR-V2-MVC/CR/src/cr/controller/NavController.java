package cr.controller;

import cr.model.NavModel;
import cr.view.NavView;
import java.util.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 *
 * @author Stagiaire
 */
public class NavController extends Observable{
    private NavView navView;
    private NavModel navModel;
    
    public char buttonClicked;
    
    public NavController(NavView navView, NavModel navModel){
        this.navView = navView;
        this.navModel = navModel;
    }
    
    public void run(){
        listenAllButtons();
    }
    
    public void listenAllButtons(){
        for(int i=0; i<navView.buttons.length; i++){
            listenButton(navView.buttons[i]);
        }
    }
    
    public void listenButton(Button button){
        button.setOnAction((ActionEvent e) ->{
            updateButtonClicked(button.getText().charAt(0));
        });
    }
    
    public void updateButtonClicked(char buttonClicked){
        this.buttonClicked = buttonClicked;
        setChanged();
        notifyObservers();
    }
}
