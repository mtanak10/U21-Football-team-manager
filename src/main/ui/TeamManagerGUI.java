
package ui;

import javax.swing.*;

import model.*;

import java.awt.*;

// Main part of the gui it has the main display
public class TeamManagerGUI extends JFrame {

    private Team team;
    private CardLayout cardLayOut;

    public static void main(String[] args) {
        TeamManagerGUI ui = new TeamManagerGUI();
        ui.setVisible(true);
    }

    public TeamManagerGUI() {
        team = new Team();
        cardLayOut = setCard();

        JPanel mainMenuPanel = new JPanel(cardLayOut);
        mainMenuPanel.setLayout(new GridLayout(8, 1));

        addButtons(mainMenuPanel);

        add(mainMenuPanel, BorderLayout.CENTER);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            team.printEventLog();
        }));

    }

    // Modifies: this
    // EFFECTS: this will set the card layou and modifies and defines the size
    private CardLayout setCard() {

        cardLayOut = new CardLayout();
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        return cardLayOut;

    }

    // Effects: add all of the buttons needed to the Jfram main panel
    private void addButtons(JPanel mainMenuPanel) {
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

    }

}