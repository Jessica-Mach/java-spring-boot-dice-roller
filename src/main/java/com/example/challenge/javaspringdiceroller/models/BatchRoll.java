package com.example.challenge.javaspringdiceroller.models;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BatchRoll {
  private int batchRollCount;
  private int batchGuess;
  private int batchDiceCount;
  private List<DiceRoll> diceRolls;

  public BatchRoll() {
    this.batchRollCount = 1;
    this.batchGuess = 0;
    this.batchDiceCount = 1;
    diceRolls = new ArrayList<>();
  }

  public int getBatchRollCount() {
    return batchRollCount;
  }

  public void setBatchRollCount(int batchRollCount) {
    this.batchRollCount = batchRollCount;
  }

  public int getBatchGuess() {
    return batchGuess;
  }

  public void setBatchGuess(int batchGuess) {
    this.batchGuess = batchGuess;
  }

  public int getBatchDiceCount() {
    return batchDiceCount;
  }

  public void setBatchDiceCount(int batchDiceCount) {
    this.batchDiceCount = batchDiceCount;
  }

  public List<DiceRoll> getDiceRolls() {
    return diceRolls;
  }

  public void setDiceRolls(List<DiceRoll> diceRolls) {
    this.diceRolls = diceRolls;
  }

  public void rollBatch() {
    for(int i = 0; i < batchRollCount; i++) {
      DiceRoll diceRoll = new DiceRoll();
      diceRoll.setGuess(this.batchGuess);
      diceRoll.setDiceCount(this.batchDiceCount);
      diceRoll.roll();
      diceRoll.evaluateRoll();
      diceRolls.add(diceRoll);
    }
  }
}
