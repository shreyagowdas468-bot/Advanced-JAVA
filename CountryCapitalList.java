package swings;
/*6c. Develop a Swing program in Java to add the countries USA, India, Vietnam, Canada,
Denmark, France, Great Britain, Japan, Africa, Greenland, Singapore into a JList and
display the capital of the countries on console whenever the countries are selected on the list.*/

import javax.swing.*;
import java.awt.event.*;
import java.util.HashMap;

public class CountryCapitalList extends JFrame {

    JList<String> countryList;
    HashMap<String, String> capitals;

    public CountryCapitalList() {

        setTitle("Country Capital List");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] countries = {
                "USA", "India", "Vietnam", "Canada",
                "Denmark", "France", "Great Britain",
                "Japan", "Africa", "Greenland", "Singapore"
        };

        // Map countries to capitals
        capitals = new HashMap<>();
        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "Addis Ababa");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        countryList = new JList<>(countries);
        add(new JScrollPane(countryList));

        countryList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = countryList.getSelectedValue();
                System.out.println("Capital of " + selected + " is: " + capitals.get(selected));
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CountryCapitalList();
    }
}