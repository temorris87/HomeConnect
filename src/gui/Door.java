package gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Created by micha on 4/23/2017.
 */
public class Door {
    public Line door;
    public String room;

    public Door(double xStart, double yStart,double xEnd, double yEnd, String Name){
        door = new Line(xStart,yStart,xEnd,yEnd);
        door.setStroke(Color.WHITE);
        room = Name;
    }
    public void closeDoor(){ door.setStroke(Color.BLACK);};
    public void openDoor() { door.setStroke(Color.WHITE);};
    public String getRoom(){
        return room;
    }

}
