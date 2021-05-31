package com.example.challenge.javaspringdiceroller.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

@Component
public class DiceRoll {
  private int roll;
  private int guess;
  private Integer diceCount;
  private boolean correct;
  private String resultMessage;
  private List<String> diceDisplays;

  public DiceRoll() {
    diceDisplays = new ArrayList<>();
  }

  public int getRoll() {
    return roll;
  }

  public void setRoll(int roll) {
    this.roll = roll;
  }

  public int getGuess() {
    return guess;
  }

  public void setGuess(int guess) {
    this.guess = guess;
  }

  public void setCorrect(boolean correct) {
    this.correct = correct;
  }

  public String getResultMessage() {
    return resultMessage;
  }

  public void setResultMessage(String resultMessage) {
    this.resultMessage = resultMessage;
  }

  public int getDiceCount() {
    return diceCount;
  }

  public void setDiceCount(int diceCount) {
    this.diceCount = diceCount;
  }

  public List<String> getDiceDisplays() {
    return diceDisplays;
  }

  public void setDiceDisplays(List<String> diceDisplays) {
    this.diceDisplays = diceDisplays;
  }

  public void roll() {
    Random rand = new Random();
    if(this.diceCount != null && this.diceCount != 0) {
      int individualRoll = 0;
      for(int i = 0; i < this.diceCount; i++) {
        individualRoll = rand.nextInt(6) + 1;
        this.roll += individualRoll;
        this.diceDisplays.add(this.getDiceDisplay(individualRoll));
      }
    } else {
      this.roll = rand.nextInt(6) + 1;
      this.diceDisplays.add(this.getDiceDisplay(this.roll));
    }
  }

  public boolean isCorrect() {
    this.correct = this.guess == this.roll;
    return this.guess == this.roll;
  }

  public boolean isGreater() {
    return this.guess > this.roll;
  }

  public void evaluateRoll() {
    if(this.guess == 0) {
      this.resultMessage = "You can't win if you don't guess!";
    } else if(this.isCorrect()) {
      this.resultMessage = "YOU GUESSED THE NUMBER";
    } else if (this.isGreater()) {
      this.resultMessage = "Close. If we were playing price is right rules, you would have won.";
    } else {
      this.resultMessage = "Nope. Sorry. Try Again";
    }
  }

  public String getDiceDisplay(int individualRoll) {
    String display = "fas fa-dice-";
    switch(individualRoll)
    {
      case 1:
        display+= "one";
        break;
      case 2:
        display += "two";
        break;
      case 3:
        display += "three";
        break;
      case 4:
        display += "four";
        break;
      case 5:
        display += "five";
        break;
      case 6:
        display += "six";
        break;
    }
    return display;
  }

}
