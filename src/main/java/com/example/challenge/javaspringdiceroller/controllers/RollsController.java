package com.example.challenge.javaspringdiceroller.controllers;

import com.example.challenge.javaspringdiceroller.models.DiceRoll;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/rolls")
public class RollsController {
  @GetMapping("/new")
  public String getNew(@RequestParam(required = false) Integer guess, @RequestParam(required = false) Integer diceCount, Model model) {
    //Implement your logic here
    DiceRoll diceRoll = new DiceRoll();
    if(diceCount != null) {
      diceRoll.setDiceCount(diceCount);
    }
    if (guess != null && guess > 0) {
      diceRoll.setGuess(guess);
      diceRoll.roll();
      diceRoll.evaluateRoll();
      if(guess > diceRoll.getDiceCount() * 6) {
        diceRoll.setResultMessage("Guess not possible with this number of dice. Try again.");
      }
    } else {
      diceRoll.roll();
    }

    //this will allow you to use the variable `num` in your JSP/JSTL view
    model.addAttribute("diceRoll", diceRoll);

    //render src/main/webapp/rolls/show.jsp
    return "show";
  }
}
