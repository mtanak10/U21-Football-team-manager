package model;

import static org.junit.jupiter.api.Assertions.fail;

public class Player {
  protected String name;
  protected String position;
  protected int evaluation;
  protected Boolean wentDrinking;
  protected int attendaceTraining;
  protected int peformanceTraining;
  protected Boolean injuryStatus;
  protected Boolean sleepingStatus;
  protected int Goal;

  // Requires: none
  // Modifies: this
  // Effects: sets some of the fields
  public Player(String name, String position, int evaluation) {

  }

  // Requires: value of attendanceTraining and injuryStatus to have a value of
  // either false or true
  // modifies: none
  // Effects: returns if the player is available for the next game or not. This
  // will be decided for the
  public Boolean isAvailable() {
    return false;
  }

  // Requires: int in the parameter has to be a positve integer
  // modifies: this
  // Effects add number of the goals in the parameter to the goal field
  public void Score(int goal) {
    // stub
  }

  public String getName() {
    return "";

  }

  public int getEvaluation() {
    return 0;

  }

  public String getPosition() {
    return "";

  }

  public Boolean getDrinkingStatus() {
    return false;
  }

  public int getattendanceTraining() {
    return 0;

  }

  public int getpeformanceTraining() {
    return 0;

  }

  public Boolean getinjuryStatus() {
    return false;
  }

  public Boolean getsleepingStatus() {
    return false;
  }

  public int getGoal() {
    return 0;
  }

}
