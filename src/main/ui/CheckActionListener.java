package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Player;
import model.Team;

public class CheckActionListener implements ActionListener {

    private JFrame checkFrame;
    private Team team;

    public CheckActionListener(Team team) {
        checkFrame = new JFrame("Add Player");
        this.team = team;
        checkFrame.setSize(400, 300);
        checkFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkFrame.setLayout(new GridLayout(7, 2));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        checkFrame.getContentPane().removeAll();

        checkFrame.add(new JLabel("Name:"));
        JTextField nameField = new JTextField();
        checkFrame.add(nameField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                System.out.print(name);

                checking(name);

                checkFrame.dispose();
            }
        });
        checkFrame.add(submitButton);
        checkFrame.setVisible(true);

    }

    public void checking(String name) {

        for (int i = 0; i < team.getTeam().size(); i++) {
            if (team.getTeam().get(i).getName().equalsIgnoreCase(name)) {
                Player player = team.getTeam().get(i);
                if (player.isAvailable()) {

                    JOptionPane.showMessageDialog(checkFrame, "THIS PLAYER IS READY TO PLAY", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(checkFrame, "!!CURRENTLY UNABLE TO PLAY!!", "Fail",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(checkFrame, "Player is not registered in the Team", "Fail",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }
}
