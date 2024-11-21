package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.Player;
import model.Team;

public class ViewTeamActionListener implements ActionListener {

    private JFrame viewTeamFrame;
    private Team team;

    public ViewTeamActionListener(Team team) {
        viewTeamFrame = new JFrame("Add Player");
        this.team = team;
        viewTeamFrame.setSize(400, 300);
        viewTeamFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        viewTeamFrame.setLayout(new GridLayout(7, 2));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        viewTeamFrame.getContentPane().removeAll();

        JLabel teamDisplay = new JLabel("Squad");
        viewTeamFrame.add(teamDisplay);

        for (Player player : team.getTeam()) {
            JLabel p = new JLabel("\tName: " + player.getName() + "   " + "Position: " + player.getPosition()
                    + " Availability: " + player.isAvailable());
            viewTeamFrame.add(p);
        }

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTeamFrame.dispose(); // Close the add player window
            }
        });
        viewTeamFrame.add(exitButton);

        viewTeamFrame.setVisible(true);

    }

}
