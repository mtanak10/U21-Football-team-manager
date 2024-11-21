package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPlayerActionListener implements ActionListener{

    private JTextField nameField;
    private JTextField positionField;
    private JTextField evaluationField;


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Add Player button clicked"); // Debug statement
        JPanel addPlayerPanel = new JPanel();
        addPlayerPanel.setLayout(new GridLayout(8,2));

        addPlayerPanel.add(new JLabel("Name:"));
            nameField = new JTextField();
            addPlayerPanel.add(nameField);

            addPlayerPanel.add(new JLabel("Position (GK, DF, MF, FW):"));
            positionField = new JTextField();
            addPlayerPanel.add(positionField);

            addPlayerPanel.add(new JLabel("Evaluation (1-5):"));
            evaluationField = new JTextField();
            addPlayerPanel.add(evaluationField);
    }
    
}
