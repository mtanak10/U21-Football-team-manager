package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

        showTopScorerChart();

        viewTeamFrame.setVisible(true);

    }

    private void showTopScorerChart() {
        JFrame chartFrame = setChartFrame();

        JPanel panel = setPanel();

        List<Player> players = team.getTeam();
        players.sort((p1, p2) -> Integer.compare(p2.getGoal(), p1.getGoal()));

        int maxGoals = players.stream().mapToInt(Player::getGoal).max().orElse(1);

        for (Player player : players) {
            JPanel playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JLabel nameLabel = new JLabel(player.getName() + ": ");
            playerPanel.add(nameLabel);

            int goalCount = player.getGoal();
            String goalString = String.valueOf(goalCount);
            int barWidth = (int) ((goalCount / (double) maxGoals) * 300); // Scale bar width based on maxGoals
            JLabel bar = new JLabel();
            JLabel goals = new JLabel(goalString);
            bar.setOpaque(true);
            bar.setBackground(Color.BLUE);
            bar.setPreferredSize(new Dimension(barWidth, 20)); // Adjusted width

            playerPanel.add(bar);
            playerPanel.add(goals);
            panel.add(playerPanel);
        }

        chartFrame.add(panel);
        chartFrame.setVisible(true);
    }

    private JFrame setChartFrame() {
        JFrame chartFrame = new JFrame("Top Scorers Chart");
        chartFrame.setSize(800, 600);
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        return chartFrame;

    }

    private JPanel setPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(team.getTeam().size(), 1, 5, 5)); // Adding spacing between components
        return panel;
    }

}
