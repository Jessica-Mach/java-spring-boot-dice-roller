package com.example.challenge.javaspringdiceroller.controllers;

import com.example.challenge.javaspringdiceroller.models.BatchRoll;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/batchRolls")
public class BatchRollsController {
  @GetMapping("/new")
  public String getNew(@RequestParam(required = false) Integer guess, @RequestParam(required = false) Integer diceCount, @RequestParam(required=false) Integer rollCount, Model model) {
    BatchRoll batchRoll = new BatchRoll();
    if(rollCount != null) {
      batchRoll.setBatchRollCount(rollCount);
    }
    if(guess != null) {
      batchRoll.setBatchGuess(guess);
    }
    if(diceCount !=null) {
      batchRoll.setBatchDiceCount(diceCount);
    }
    batchRoll.rollBatch();

    //this will allow you to use the variable `num` in your JSP/JSTL view
    model.addAttribute("batchRolls", batchRoll.getDiceRolls());

    //render src/main/webapp/rolls/show.jsp
    return "show";
  }

}
