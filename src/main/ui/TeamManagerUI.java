package ui;

import javax.swing.*;

import model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamManagerUI extends JFrame {

    private Team team;

    public static void main(String[] args) {
        TeamManagerUI  ui = new TeamManagerUI();
        ui.setVisible(true);
    }

    public TeamManagerUI(){
        team = new Team();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new GridLayout(7, 1));

        

        JButton addPlayerButton = new JButton("Add a Player");
        addPlayerButton.addActionListener(new AddPlayerActionListener());
        mainMenuPanel.add(addPlayerButton);
        
        JButton removePlayerButton = new JButton("Remove a Player");
        mainMenuPanel.add(removePlayerButton);

        JButton viewTeamButton = new JButton("View the Team");
        mainMenuPanel.add(viewTeamButton);

        JButton checkButton = new JButton("Check the Availability of a Player");
        mainMenuPanel.add(checkButton);

        JButton updateButton = new JButton("Update Fitness");
        mainMenuPanel.add(updateButton);

        JButton saveButton = new JButton("Save the Team");
        mainMenuPanel.add(saveButton);

        JButton loadButton = new JButton("Load the Team");
        mainMenuPanel.add(loadButton);

        add(mainMenuPanel, BorderLayout.CENTER);
        

    }


    

}