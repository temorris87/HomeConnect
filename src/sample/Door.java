package sample;
import thingspace.Update;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Akash Patel on 4/23/2017.
 */
public class Door extends JFrame {
    final int WINDOW_WIDTH = 210;
    final int WINDOW_HEIGHT = 225;
    private JLabel front_door, back_door;
    private JRadioButton locked, unlocked;
    private JPanel panel, panel2;
    private ButtonGroup buttons, buttons2;

    public Door() {
        setTitle("Door");

        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(1, 0));

        front_door = new JLabel("Front_door");
        back_door = new JLabel("Back door");

        JRadioButton d1 = new JRadioButton("locked");
        d1.setActionCommand("Front_door_locked");
        JRadioButton o1 = new JRadioButton("unlocked");
        o1.setActionCommand("Front_door_unlocked");

        JRadioButton d2 = new JRadioButton("locked");
        d2.setActionCommand("Back_door_locked");
        JRadioButton o2 = new JRadioButton("unlocked");
        o2.setActionCommand("Back_door_unlocked");

        buttons = new ButtonGroup();
        buttons.add(d1);
        buttons.add(o1);

        buttons2 = new ButtonGroup();
        buttons2.add(d2);
        buttons2.add(o2);

        panel = new JPanel();
        panel2 = new JPanel();

        panel.add(front_door);
        panel.add(d1);
        panel.add(o1);

        panel2.add(back_door);
        panel2.add(d2);
        panel2.add(o2);

        add(panel);
        add(panel2);

        d1.addActionListener(new ButtonListener());
        o1.addActionListener(new ButtonListener());

        d2.addActionListener(new ButtonListener());
        o2.addActionListener(new ButtonListener());

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();

            if (actionCommand.equals("Front_door_unlocked")) {
                // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                try {
                    String[][] temp = {{"locked", "true"}};

                    Update.postData("frontporch_door", temp);
                } catch (IOException t) {
                    System.out.println("Website not found.");
                }

            }

            if (actionCommand.equals("Front_door_locked")) {
                // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                try {
                    String[][] temp = {{"locked", "false"}};

                    Update.postData("frontporch_door", temp);
                } catch (IOException t) {
                    System.out.println("Website not found.");
                }

            }

            if (actionCommand.equals("Back_door_unlocked")) {
                // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                try {
                    String[][] temp = {{"locked", "true"}};

                    Update.postData("backporch_door", temp);
                } catch (IOException t) {
                    System.out.println("Website not found.");
                }

            }

            if (actionCommand.equals("Back_door_locked")) {
                // JOptionPane.showMessageDialog(null, "Light 1 is ON")
                try {
                    String[][] temp = {{"locked", "false"}};

                    Update.postData("backporch_door", temp);
                } catch (IOException t) {
                    System.out.println("Website not found.");
                }

            }


        }
    }
}
