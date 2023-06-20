/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jptv21movingbuttonapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author pupil
 */
public class FXMLDocumentController {
    
    @FXML
    private Button btnClickMe;
    @FXML
    private Label lblClickedValue;
    @FXML
    private Label llblTitleLevel;
   
    private int currentLevel=1;
    private int windowClick=1;
    private String textClickedToWindow="";
    private boolean isMoving = true;
    private int delay = 1000;
    
    @FXML
    private void handleWindowsClicked() {
        if(isMoving) lblClickedValue.setText(textClickedToWindow+currentLevel+": "+windowClick++);
    }
    
    public void btnClickMeClick(){
        isMoving = !isMoving;
        if(isMoving){
            btnClickMe.setText("Нажми меня");
            delay -= 100;
            llblTitleLevel.setText("Уровень "+ currentLevel);
            windowClick=1;
        }else{
            btnClickMe.setText("Продолжить");
            textClickedToWindow=lblClickedValue.getText()+"\n";
            currentLevel++;
        }
    }
    
    
    public void moveButtonRandomly(double sceneWidth, double sceneHeight) {
        Thread thread = new Thread(() -> {
            while (true) {
                if (isMoving) {
                    double x = Math.random() * (sceneWidth - btnClickMe.getWidth());
                    double y = Math.random() * (sceneHeight - btnClickMe.getHeight());
                    btnClickMe.relocate(x, y);
                }
                try {
                    Thread.sleep(delay); // Задержка между перемещениями кнопки
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
    
}
     
    

