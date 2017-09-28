package gui;/**
 * Created by micha on 4/22/2017.
 */

import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.text.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import thingspace.Update;
import java.io.IOException;

import javafx.stage.Screen;
import javafx.geometry.Rectangle2D;

public class Demo extends Application {

    double width = 1080;
    double height = 720;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws NoSuchMethodException {
        Lights[] lights = setLights();
        Door[] doors = setDoor();
        Radio[] radio = setRadio();
        primaryStage.setScene(floorplanScene(lights,doors));
        primaryStage.setTitle("Home Connect");
        startTimer(primaryStage, lights,doors,radio);
        primaryStage.show();
    }

    private Radio[] setRadio() {
        Radio[] radios = new Radio[1];
        radios[0] = new Radio(width*.831+100,height*.48+30);

        return radios;

    }

    private Door[] setDoor() {
        Door[] doors = new Door[2];
        Door doorFront = new Door(400,height+28,500,height+28,"frontporch_door");
        Door doorBack = new Door(600,100,700,100,"backporch_door");
        doors[0] = doorFront;
        doors[1] = doorBack;
        return doors;

    }

    private void startTimer(Stage primaryStage, Lights[] lights,Door[] doors, Radio[] radios) {
        Timeline loop = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                updateLights(lights);
                updateDoors(doors);

                primaryStage.setScene(floorplanScene(lights, null));
                primaryStage.fullScreenProperty();
                primaryStage.show();
            }
        }));
        loop.setCycleCount(Timeline.INDEFINITE);
        loop.play();
    }

    public void updateLights(Lights[] lights) {
        try {
            for (int i = 0; i < lights.length; i++) {
                String[][] data = Update.parseData(Update.getRoughData(lights[i].getRoom()));
                for (int j = 0; j < data.length; j++) {
                    if (data[j][0].compareTo("on") == 0) {
                        if (data[j][1].compareTo("true") == 0) {
                            lights[i].turnOn();
                        }
                        else
                            lights[i].turnOff();
                    }
                    else if (data[j][0].compareTo("dim") == 0) {
                        lights[i].setDimness(Double.parseDouble(data[j][1]));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Website doesn't exist.");
        }
    }

    public void updateDoors(Door[] doors) {
        try {
            for (int i = 0; i < doors.length; i++) {
                String[][] data = Update.parseData(Update.getRoughData(doors[i].getRoom()));
                for (int j = 0; j < data.length; j++) {
                    if (data[j][0].compareTo("locked") == 0) {
                        if (data[j][1].compareTo("true") == 0) {
                            doors[i].openDoor();
                        }
                        else
                            doors[i].closeDoor();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Website doesn't exist.");
        }
    }

    private Lights[] setLights() {

        // Lights
        Lights living_room_lights = new Lights(24.0, width/2,(height/2)+130, 1,"livingroom_light");
        Lights kitchen_light = new Lights(24, width, 200, 1,"kitchen_light");
        Lights bathroom_light = new Lights(24.0, 330,200, 1,"bathroom_light");
        Lights bed1_light = new Lights(24, width, height/2 + 90, 1,"bedroom1_light");
        Lights bed2_light = new Lights(24, width-100,height-90, 1,"bedroom2_light");
        Lights outside_front_light = new Lights(24,width/2 -92,height+58, 1,"frontporch_light");
        Lights outside_back_light = new Lights(24,650,70, 1,"backporch_light");

        Lights[] lights = new Lights[7];
        lights[0] = living_room_lights;
        lights[1] = kitchen_light;
        lights[2] = bathroom_light;
        lights[3] = bed1_light;
        lights[4] = bed2_light;
        lights[5] = outside_back_light;
        lights[6] = outside_front_light;

        return lights;
    }

    private Scene floorplanScene(Lights[] lights,Door[] doors) {

        // Make fullscreen.

        // HOUSE
        Rectangle HOUSE = new Rectangle();
        HOUSE.setFill(Color.WHITE);
        HOUSE.setStroke(Color.BLACK);
        HOUSE.setWidth(width*.9);
        HOUSE.setHeight(height*.9);
        HOUSE.setX(250);
        HOUSE.setY(100);

        // Bathroom
        Rectangle bath = new Rectangle();
        bath.setFill(Color.WHITE);
        bath.setStroke(Color.BLACK);
        bath.setWidth(width*.15);
        bath.setHeight(height*.3);
        bath.setX(250);
        bath.setY(100);

        // Bedroom 1
        Rectangle bed1 = new Rectangle();
        bed1.setFill(Color.WHITE);
        bed1.setStroke(Color.BLACK);
        bed1.setWidth(width*.3);
        bed1.setHeight(height*.3);
        bed1.setX(width*.831);
        bed1.setY(height*.739);

        // Bedroom 2
        Rectangle bed2 = new Rectangle();
        bed2.setFill(Color.WHITE);
        bed2.setStroke(Color.BLACK);
        bed2.setWidth(width*.3);
        bed2.setHeight(height*.3);
        bed2.setX(width*.831);
        bed2.setY(height*.48);

        //Text
        Text bathroom = new Text(250,160,"Bathroom");
        Text kitchen = new Text(width/2 +400,200,"Kitchen");
        Text LivingRoom = new Text(400,height,"Living Room");
        Text BedRoom1 = new Text(width*.831,height*.739 +50 ,"Bedroom 1");
        Text BedRoom2 = new Text(width*.831,height*.48+ 30,"Bedroom 2");
        Group text = new Group(bathroom,kitchen,LivingRoom,BedRoom1,BedRoom2);
        //Put all lights in to a group
        Group door = new Group(doors[0].door,doors[1].door);
        Group light_circles = new Group(lights[0].light,lights[1].light,lights[2].light,lights[3].light,lights[4].light,lights[5].light,lights[6].light);
        Group root = new Group(HOUSE,bed1,bath,bed2,door,light_circles,text);

        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());

        return scene;
    }

}