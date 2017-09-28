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
 * Created by micha on 4/22/2017.
 */
public class Lights {
    private double rad;
    private double x;
    private double y;
    private double dimness;

    private String room;
    public Circle light;

    public Lights(double rad, double x, double y, double dimness, String room) {
        this.rad = rad;
        this.x = x;
        this.y = y;
        this.dimness = dimness;
        this.room = room;
        light = new Circle(x, y, rad);
        light.setFill(Color.YELLOW);
        light.setStroke(Color.BLACK);
        light.setOpacity(this.dimness);
    }

    public String keyRoom() {
        return room;
    }

    public void turnOn() {
        if (light.getFill().equals(Color.YELLOW))
            return;
        light.setFill(Color.YELLOW);
        light.setStroke(Color.YELLOW);
    }

    public void turnOff() {
        if (light.getFill().equals(Color.WHITE))
            return;
        light.setFill(Color.WHITE);
        light.setStroke(Color.WHITE);
    }

    public String getRoom() {
        return room;
    }
    public void setRoom(String nRoom){
        room =nRoom;
    }

    public void dimness(double percent) throws NoSuchMethodException {
        if (percent > 1 || percent < 0) {
            throw new NoSuchMethodException("WRONG INPUT");
        }
        light.setOpacity(percent);
    }

    public void setDimness(double dimness) {
        this.dimness = dimness;
        light.setOpacity(dimness);
    }

    public double getDimness() {
        return dimness;
    }
}