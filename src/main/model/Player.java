package model;

import static org.junit.jupiter.api.Assertions.fail;

public class Player {
  protected String name;
  protected String position;
  protected int evaluation;
  protected Boolean drinkingStatus;
  protected double attendaceTraining;
  protected Boolean injuryStatus;
  protected Boolean sleepingStatus;
  protected int totalTraining;
  protected int numTrainingAttended;
  protected int goal;

  // Requires: evaluation to be a number from 1 to 5
  // Modifies: this
  // Effects: set the fields to the initial state
  public Player(String name, String position, int evaluation) {

  }

 

  // Requires: int in the parameter has to be a positve integer
  // modifies: this
  // Effects add number of the goals in the parameter to the goal field
  public void score(int goal) {
    // stub
  }

  // Requires: none
  // Modifies: this
  // Effects: changes the injury status to true to false
  public void catchInjury(){
    // stub
  }
  // Requires: none
  // Modifies: this
  // Effects: changes the injuryStatus to false to true
  public void healInjury(){
    //stub
  }

  // Requires: none
  // Modifies: this
  // Effects: Changes the the attendance rate add 1 to the 
  // attendance and calculates the new rate and changes the attendanceTraining field
  public void attendTraining(){
    //
  }
  // Requires: none
  // Modifies: this
  // Effects: Changes the the attendance rate add 0 to the 
  // attendance and calculates the new rate and changes the attendanceTraining field
  public void missTraining(){
    //
  }

   // Requires: value of attendanceTraining and injuryStatus to have a value of
  // either false or true
  // modifies: none
  // Effects: returns if the player is available for the next game or not. This
  // will be decided for the
  public Boolean isAvailable() {
    return false;
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

  public double getAttendanceTraining() {
    return 0;

  }


  public Boolean getInjuryStatus() {
    return false;
  }

  public Boolean getSleepingStatus() {
    return false;
  }

  public int getGoal() {
    return 0;
  }

  public int getTotalTraining(){
    return 0;

  }

  public int getNumTrainingAttended(){
    return 0;
  }

}
