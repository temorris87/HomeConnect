package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * Created by micha on 4/23/2017.
 */
public class Radio {
    public Circle BigCircle;
    public Circle Circle;
    public Circle SmallCircle;

    public Radio(double x , double y){
        BigCircle = new Circle(x,y,20);
        Circle = new Circle(x,y,15);
        SmallCircle = new Circle(x,y,10);
        BigCircle.setFill(Color.WHITE);
        Circle.setFill(Color.WHITE);
        SmallCircle.setFill(Color.WHITE);
        BigCircle.setStroke(Color.BLACK);
        Circle.setStroke(Color.BLACK);
        SmallCircle.setStroke(Color.BLACK);
    }
    public void turnOn(){
        BigCircle.setStroke(Color.RED);
        Circle.setStroke(Color.RED);
        SmallCircle.setStroke(Color.RED);
    }
    public void turnOff(){
        BigCircle.setStroke(Color.BLACK);
        Circle.setStroke(Color.BLACK);
        SmallCircle.setStroke(Color.BLACK);
    }
}
