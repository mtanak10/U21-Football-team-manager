package model;

import static org.junit.jupiter.api.Assertions.fail;

public class Player {
  protected String name;
  protected String position;
  protected int evaluation;
  protected Boolean drinkingStatus;
  protected double attendanceTraining;
  protected Boolean injuryStatus;
  protected Boolean sleepingStatus;
  protected int totalTraining;
  protected int numTrainingAttended;
  protected int goal;

  // Requires: evaluation to be a number from 1 to 5
  // Modifies: this
  // Effects: set the fields to the initial state
  public Player(String name, String position, int evaluation) {
    this.name = name;
    this.position = position;
    this.evaluation = evaluation;
    this.drinkingStatus = false;
    this.attendanceTraining = 0;
    this.injuryStatus = false;
    this.sleepingStatus = false;
    this.totalTraining = 0;
    this.numTrainingAttended = 0; 
    this.goal = 0;


  }

  // Requires: int in the parameter has to be a positve integer
  // modifies: this
  // Effects add number of the goals in the parameter to the goal field
  public void score(int goal) {
    this.goal = this.goal += goal;
  }

  // Requires: none
  // Modifies: this
  // Effects: changes the injury status to true to false
  public void catchInjury() {
    this.injuryStatus = true;
  }

  // Requires: none
  // Modifies: this
  // Effects: changes the injuryStatus to false to true
  public void healInjury() {
    this.injuryStatus = false;
  }

  // Requires: none
  // Modifies: this
  // Effects: Changes the the attendance rate add 1 to the
  // attendance and calculates the new rate and changes the attendanceTraining
  // field
  public void attendTraining() {
    this.numTrainingAttended += 1;
    this.totalTraining += 1;
    this.attendanceTraining = (this.numTrainingAttended/totalTraining);
    //
  }

  // Requires: none
  // Modifies: this
  // Effects: Changes the the attendance rate add 0 to the
  // attendance and calculates the new rate and changes the attendanceTraining
  // field
  public void missTraining() {
    this.totalTraining++;
    this.attendanceTraining = this.numTrainingAttended/this.totalTraining;
    
    //
  }

  // Requires: value of attendanceTraining and injuryStatus to have a value of
  // either false or true
  // modifies: none
  // Effects: returns if the player is available for the next game or not. This
  // will be decided for the
  public Boolean isAvailable() {
    if(this.attendanceTraining >= 0.5 && this.injuryStatus == false){
      return true;
    } else {
      return false;
    }
  }

  public String getName() {
    return this.name;

  }

  public int getEvaluation() {
    return this.evaluation;

  }

  public String getPosition() {
    return this.position;

  }

  public Boolean getDrinkingStatus() {
    return this.drinkingStatus;
  }

  public double getAttendanceTraining() {
    return this.attendanceTraining;

  }

  public Boolean getInjuryStatus() {
    return this.injuryStatus;
  }

  public Boolean getSleepingStatus() {
    return this.sleepingStatus;
  }

  public int getGoal() {
    return this.goal;
  }

  public int getTotalTraining() {
    return this.totalTraining;

  }

  public int getNumTrainingAttended() {
    return this.numTrainingAttended;
  }

}
