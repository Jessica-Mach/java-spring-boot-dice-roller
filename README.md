# java-spring-boot-dice-roller
Description: Navigate to api endpoints to roll a dice or to roll batches of dice

Author: Jessica Mach

Technology: Java/Spring-Boot

Features: 

- Roll a Dice: When a user navigates to /rolls/new, the server will give a random number between 1 and 6

- Guess a Roll: When a user navigates to /rolls/new?guess=<num>, the system rolls a die and compares it to the supplied guess
    * If the visitor guesses correctly, it should say "YOU GUESSED THE NUMBER" in bold letters
    * If the guess was less than the number, it renders "Nope. Sorry. Try Again"
    * If the guess was more than the number, it renders "Close. If we were playing price is right rules, you would have won."

- Roll Multiple Dice: When a user navigates to /rolls/new?guess=<num>&diceCount=<number of dice>, the <number of dice> reflects
      the number of dice that are rolled.
      
- Roll Multiple Times: When a user navigates to /batchRolls/new?guess=<num>&diceCount=<number of dice>&rollCount=<number of rolls>, 
      the application renders the results of each roll.
      
- Render Dice Icons: Uses Font Awesome to render dice icons for the rolls.
