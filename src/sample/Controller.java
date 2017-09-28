package sample;
import thingspace.Update;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame
 {
     private JPanel lightPanel;

     private JPanel washerPanel;

     private JPanel doorsPanel;

     private JButton lights;


     private JButton washer;

     private JButton doors;

     final int WINDOW_WIDTH = 210;
     final int WINDOW_HEIGHT = 225;

     public Controller() {
         setTitle("The Smart House");

         setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new GridLayout(6, 1));
//        buildButton();

         lights = new JButton("Lights");
         lightPanel = new JPanel();
         lightPanel.add(lights);
         add(lightPanel);
         lights.addActionListener(new ButtonListener());

         doors = new JButton("Doors");
         doorsPanel = new JPanel();
         doorsPanel.add(doors);
         add(doorsPanel);
         doors.addActionListener(new ButtonListener());



        setVisible(true);
     }

     private class ButtonListener implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             String actionCommand = e.getActionCommand();

             if (actionCommand.equals("Lights"))
             {
              //   JOptionPane.showMessageDialog(null, "Light 1 is ON");
                 Lights main  = new Lights();
                 main.show();
                 //JFrame f = main;
                 //f.show();
             }


             else  if (actionCommand.equals("Doors"))
             {
                 Door main6 = new Door();
                 main6.show();
             }

             else
             {
                 JOptionPane.showMessageDialog(null, "Light 1 is ON");
             }
         }
     }
    public static void main(String[] args)
    {
          new Controller();
//          Lights main  = new Lights();
    }
 }

