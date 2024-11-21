package ui;

import javax.swing.*;

import model.*;

import java.awt.*;

public class TeamManagerGUI extends JFrame {

    private Team team;
    private CardLayout cardLayOut;

    public static void main(String[] args) {
        TeamManagerGUI ui = new TeamManagerGUI();
        ui.setVisible(true);
    }

    public TeamManagerGUI() {
        team = new Team();
        cardLayOut = new CardLayout();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel mainMenuPanel = new JPanel(cardLayOut);
        mainMenuPanel.setLayout(new GridLayout(8, 1));

        JButton addPlayerButton = new JButton("Add a Player");
        addPlayerButton.addActionListener(new AddPlayerActionListener(team));
        mainMenuPanel.add(addPlayerButton);

        JButton removePlayerButton = new JButton("Remove a Player");
        removePlayerButton.addActionListener(new RemovePlayerActionListener(team));
        mainMenuPanel.add(removePlayerButton);

        JButton viewTeamButton = new JButton("View the Team");
        viewTeamButton.addActionListener(new ViewTeamActionListener(team));
        mainMenuPanel.add(viewTeamButton);

        JButton checkButton = new JButton("Check the Availability of a Player");
        checkButton.addActionListener(new CheckActionListener(team));
        mainMenuPanel.add(checkButton);

        JButton updateButton = new JButton("Update Player Status");
        updateButton.addActionListener(new UpdateActionListener(team));
        mainMenuPanel.add(updateButton);

        JButton saveButton = new JButton("Save the Team");
        saveButton.addActionListener(new SaveTeamListener(team));
        mainMenuPanel.add(saveButton);

        JButton loadButton = new JButton("Load the Team");
        loadButton.addActionListener(new LoadTeamListener(team));
        mainMenuPanel.add(loadButton);

        add(mainMenuPanel, BorderLayout.CENTER);

    }

}