package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
	    Create a Rock-Paper-Scissors game that allows 2 people to play against each other.
	    Requirements:
	    - use Scanner to get user input
	    - use control-flow statements to determine the winner and print it out
	    - allow players to repeatedly play many games
	    - must make use of at least one class
	    - Make your own Git Repo and paste the link in the excel sheet.
	    Stretch Goals:
	    - allow players to enter their name for a more personalized experience
	    - keep track of score
	    - Extend your game to be tic-tac-toe instead of Rock-Paper-Scissors
	 */

        //main variables
        String userInput;

        //region Main program

        //instantiate the other classes as objects
        InputUtilities inputUtil = new InputUtilities();
        AppUtilities appUtil = new AppUtilities();
        RockPaperScissors game1 = new RockPaperScissors();
        TicTacToe game2 = new TicTacToe();

        //loop until player decides to quit the program
        do{
            //call methods from objects
            appUtil.ClearScreen();
            appUtil.DisplayMainHeader();

            //ask user which game to play
            appUtil.DisplayMainMenu();

            //get user input
            userInput = inputUtil.SelectGame();

            switch(userInput){
                case "1": game1.StartGame(); break;
                case "2": game2.StartGame(); break;
                case "3": break;
                default: System.out.println("*Invalid option Please choose an option (1-3).\n"); break;
            }

        }while(!userInput.equals("3"));

        //end program
        appUtil.EndProgram();

        //endregion
    }
}
