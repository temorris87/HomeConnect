package sample;
import thingspace.Update;
import java.io.IOException;

import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Lights extends JFrame
{

    private ButtonGroup buttons, buttons2, buttons3, buttons4, buttons5, buttons6, buttons7;
    private JRadioButton rdbuttons;
    final int WINDOW_WIDTH = 240;
    final int WINDOW_HEIGHT = 250;

    public Lights()
    {
        setTitle("Button Window");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(7,2));

        // Create two buttons.
        JLabel b1 = new JLabel("kitchen_light");
        JLabel b2 = new JLabel("bedroom1_light");
        JLabel b3 = new JLabel("bedroom2_light");
        JLabel b4 = new JLabel("bathroom_light");
        JLabel b5 = new JLabel("livingroom_light");
        JLabel b6 = new JLabel("frontporch_light");
        JLabel b7 = new JLabel("backporch_light");



        // Create 2 Radio buttons.
        JRadioButton ON1 = new JRadioButton("ON");
        ON1.setActionCommand("kitchen_light_on");
        JRadioButton OFF1 = new JRadioButton("OFF");
        OFF1.setActionCommand("kitchen_light_off");

        JRadioButton ON2 = new JRadioButton("ON");
        ON2.setActionCommand("bedroom2_light_on");
        JRadioButton OFF2 = new JRadioButton("OFF");
        OFF2.setActionCommand("bedroom2_light_off");

        JRadioButton ON3 = new JRadioButton("ON");
        ON3.setActionCommand("bedroom1_light_on");
        JRadioButton OFF3 = new JRadioButton("OFF");
        OFF3.setActionCommand("bedroom1_light_off");

        JRadioButton ON4 = new JRadioButton("ON");
        ON4.setActionCommand("bathroom_light_on");
        JRadioButton OFF4 = new JRadioButton("OFF");
        OFF4.setActionCommand("bathroom_light_off");

        JRadioButton ON5 = new JRadioButton("ON");
        ON5.setActionCommand("livingroom_light_on");
        JRadioButton OFF5 = new JRadioButton("OFF");
        OFF5.setActionCommand("livingroom_light_off");

        JRadioButton ON6 = new JRadioButton("ON");
        ON6.setActionCommand("frontporch_light_on");
        JRadioButton OFF6 = new JRadioButton("OFF");
        OFF6.setActionCommand("frontporch_light_off");

        JRadioButton ON7 = new JRadioButton("ON");
        ON7.setActionCommand("backporch_light_on");
        JRadioButton OFF7 = new JRadioButton("OFF");
        OFF7.setActionCommand("backporch_light_off");


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();

//        private ButtonGroup buttons;
         buttons = new ButtonGroup();
         buttons.add(ON1);
         buttons.add(OFF1);

        buttons2 = new ButtonGroup();
        buttons2.add(ON2);
        buttons2.add(OFF2);

        buttons3 = new ButtonGroup();
        buttons3.add(ON3);
        buttons3.add(OFF3);

        buttons4 = new ButtonGroup();
        buttons4.add(ON4);
        buttons4.add(OFF4);

        buttons5 = new ButtonGroup();
        buttons5.add(ON5);
        buttons5.add(OFF5);

        buttons6 = new ButtonGroup();
        buttons6.add(ON6);
        buttons6.add(OFF6);

        buttons7 = new ButtonGroup();
        buttons7.add(ON7);
        buttons7.add(OFF7);


        // Add buttons to the panel.
        panel1.add(b1);
        panel2.add(b2);
        panel3.add(b3);
        panel4.add(b4);
        panel5.add(b5);
        panel6.add(b6);
        panel7.add(b7);

        // Add Switches to the panel.
        panel1.add(ON1);
        panel1.add(OFF1);

        panel2.add(ON2);
        panel2.add(OFF2);

        panel3.add(ON3);
        panel3.add(OFF3);

        panel4.add(ON4);
        panel4.add(OFF4);

        panel5.add(ON5);
        panel5.add(OFF5);

        panel6.add(ON6);
        panel6.add(OFF6);

        panel7.add(ON7);
        panel7.add(OFF7);




        // Add button panels to the window.
        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
        add(panel5);
        add(panel6);
        add(panel7);

        ON1.addActionListener(new ButtonListener());
        OFF1.addActionListener(new ButtonListener());

        ON2.addActionListener(new ButtonListener());
        OFF2.addActionListener(new ButtonListener());

        ON3.addActionListener(new ButtonListener());
        OFF3.addActionListener(new ButtonListener());

        ON4.addActionListener(new ButtonListener());
        OFF4.addActionListener(new ButtonListener());

        ON5.addActionListener(new ButtonListener());
        OFF5.addActionListener(new ButtonListener());

        ON6.addActionListener(new ButtonListener());
        OFF6.addActionListener(new ButtonListener());

        ON7.addActionListener(new ButtonListener());
        OFF7.addActionListener(new ButtonListener());


        setVisible(true);

    }

     private class ButtonListener implements ActionListener
     {
         public void actionPerformed(ActionEvent e)
         {
             String actionCommand = e.getActionCommand();

             if(actionCommand.equals("bedroom1_light_on"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("bedroom1_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }

             }

             else if(actionCommand.equals("kitchen_light_on"))
             {
                // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("kitchen_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

            else if(actionCommand.equals("kitchen_light_off"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("kitchen_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }



             else if(actionCommand.equals("bedroom1_light_off"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("bedroom1_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("bedroom2_light_on"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("bedroom2_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("bedroom2_light_off"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("bedroom2_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

            else if(actionCommand.equals("bathroom_light_on"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("bathroom_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("bathroom_light_off"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("bathroom_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

           else  if(actionCommand.equals("frontporch_light_on"))
             {
                 System.out.println("hello");
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("frontporch_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("frontporch_light_off"))
             {
                 System.out.println("Hello GAIN");
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("frontporch_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("backporch_light_on"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("backporch_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("livingroom_light_on"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"on", "true"},
                             {"dim", "1"}};
                     Update.postData("livingroom_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("livingroom_light_off"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("livingroom_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else if(actionCommand.equals("backporch_light_off"))
             {
                 // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                 try {
                     String[][] temp = {{"off", "false"},
                             {"dim", "0"}};
                     Update.postData("backporch_light", temp);
                 } catch (IOException t) {
                     System.out.println("Website not found.");
                 }
             }

             else
             {
                 System.out.println("Error");
             }
             }



         }

     }




