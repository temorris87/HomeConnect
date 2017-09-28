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
public class Washer {
    public Rectangle box;
    public Circle power;
    public Washer(double x, double y){
        box = new Rectangle(x,y,146,58);
        power = new Circle(x+20,y+40,10);
        power.setFill(Color.RED);
        box.setFill(Color.WHITE);
        box.setStroke(Color.BLACK);
    }
    public void powerOff(){
        power.setFill(Color.RED);
    }
    public void powerOn(){ power.setFill(Color.GREEN); }
}
