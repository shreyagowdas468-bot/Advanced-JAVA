/*Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass  is pressed” depending upon the Jbutton with image  either  Digital Clock or  Hour Glass is pressed by implementing the event handling mechanism with addActionListener( ).*/
package program5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonImageDemo {
	public static void main(String[] args) {

        JFrame frame = new JFrame("Button Event Handling");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Click a button");
        label.setBounds(120, 20, 200, 30);
        frame.add(label);

        
        ImageIcon clockIcon = new ImageIcon(ButtonImageDemo.class.getResource("clock.png"));
        ImageIcon hourGlassIcon = new ImageIcon(ButtonImageDemo.class.getResource("hourglass.png"));

        JButton clockBtn = new JButton(clockIcon);
        clockBtn.setBounds(50, 80, 100, 100);

        JButton hourGlassBtn = new JButton(hourGlassIcon);
        hourGlassBtn.setBounds(200, 80, 100, 100);  
 
        frame.add(clockBtn);
        frame.add(hourGlassBtn);

        clockBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        hourGlassBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        frame.setVisible(true);
    }

}
