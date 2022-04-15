package com.company;
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    //region Methods

    //Start Game method: Begins the 'Rock, Paper, Scissors' game.
    public void StartGame(){
        //game variables
        String playerName;
        String opponentName;
        String[] listOfNames = {"James", "Sally", "Robert", "Emily", "Jacob", "Santa"};
        Random randNum = new Random();
        int index;
        int opponentChoice;
        int scoreboard = 0;
        int scoreWins = 0;
        int scoreLosses = 0;
        int scoreTies = 0;
        boolean gameOver = false;
        boolean validated = false;

        //instantiate objects
        InputUtilities inputUtil = new InputUtilities();
        AppUtilities appUtil = new AppUtilities();

        //variables for user input
        Scanner input = new Scanner(System.in);
        String userInput;

        //display header
        appUtil.DisplayGameOneHeader();

        //ask player for name
        System.out.print("Please enter player name: ");
        playerName = input.next();

        //loop until the game is over by user choice
        while(!gameOver) {
            //choose opponent
            index = randNum.nextInt(listOfNames.length);
            opponentName = listOfNames[index];
            System.out.println("\nYour opponent is " + opponentName + ".");

            //display choices to user
            System.out.println("\nPlease choose:" +
                    "\n(1) Rock" +
                    "\n(2) Paper" +
                    "\n(3) Scissors");
            System.out.print("Choice: ");

            //loop until user inputs valid options
            do{
                userInput = input.next();
                validated = inputUtil.ValidateInput(userInput);
            }while(!validated);

            //opponent randomly chooses
            opponentChoice = randNum.nextInt(1,4);

            //call Compare Choice method and save the return value into scoreboard
            scoreboard = appUtil.CompareChoice(playerName, userInput, opponentName, String.valueOf(opponentChoice));

            //increment scores
            if(scoreboard == 1){
                scoreWins++;
            }else if(scoreboard == 2){
                scoreLosses++;
            }else{
                scoreTies++;
            }

            //display score
            System.out.println("Wins: " + scoreWins +
                    " | Losses: " + scoreLosses +
                    " | Ties: " + scoreTies);

            //ask user to continue playing
            System.out.print("\nContinue playing? y/n: ");
            do{
                userInput = input.next();
                gameOver = userInput.equals("n");

                if(!userInput.equals("y") && !userInput.equals("n")){
                    System.out.print("Please enter y or n: ");
                }
            }while(!userInput.equals("y") && !userInput.equals("n"));
        }
    }



    //endregion




    //        //Random number generator
//        for(int i = 0; i<10;i++){
//            Random randNum = new Random();
//            System.out.println(randNum.nextInt(1,11));
//        }
}
