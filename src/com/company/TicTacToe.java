package com.company;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    //region Methods

    //Start Game method: starts the Tic-Tac-Toe game
    public void StartGame(){
        //game variables
        String playerName;
        String opponentName;
        String[] listOfNames = {"James", "Sally", "Robert", "Emily", "Jacob", "Santa"};
        String opponentChoice;
        char[] boardSpaces = new char[9];
        Random randNum = new Random();
        int whoGoesFirst;
        int currentPlayer;
        int index;
        int winner = 0;
        int scoreboard = 0;
        int scoreWins = 0;
        int scoreLosses = 0;
        int scoreTies = 0;
        char playerToken;
        char opponentToken;
        boolean gameOver = false;
        boolean validated = false;

        //instantiate objects
        InputUtilities inputUtil = new InputUtilities();
        AppUtilities appUtil = new AppUtilities();

        //variables for user input
        Scanner input = new Scanner(System.in);
        String userInput = "";

        //display header
        appUtil.DisplayGameTwoHeader();

        //ask player for name
        System.out.print("Please enter player name: ");
        playerName = input.next();

        //loop until the game is over
        while(!gameOver){
            //reset game variables
            for(int i = 0; i < boardSpaces.length; i++){
                boardSpaces[i] = ' ';
            }
            winner = 0;

            //choose opponent
            index = randNum.nextInt(listOfNames.length);
            opponentName = listOfNames[index];
            System.out.println("\nYour opponent is " + opponentName + ".");

            //flip coin to see who goes first and assign token character X/O
            whoGoesFirst = randNum.nextInt(1, 3);

            if(whoGoesFirst == 1){
                playerToken = 'X';
                opponentToken = 'O';
                currentPlayer = 1;
                System.out.println("You will be first, using the '" + playerToken + "' mark.");
            }else{
                playerToken = 'O';
                opponentToken = 'X';
                currentPlayer = 2;
                System.out.println("You will be second, using the '" + playerToken + "' mark.");
            }

            //players alternate turns entering what spot they want to take
            do{
                appUtil.DisplayBoard(boardSpaces);

                switch(currentPlayer){
                    case 1:
                        //ask player for input
                        System.out.println(playerName + ", it is your turn.");
                        System.out.println("Where to put " + playerToken + "?");
                        System.out.println("(Ascending order from top-left to bottom-right [1-9])");
                        System.out.print("Choice: ");
                        //loop until user inputs valid options
                        do{
                            userInput = input.next();
                            validated = inputUtil.ValidateInput2(userInput);
                            if(validated) {
                                validated = appUtil.CheckBoard(currentPlayer, playerToken, userInput, boardSpaces);
                            }
                        }while(!validated);
                        currentPlayer = 2;
                        break;
                    case 2:
                        //opponent randomly chooses
                        System.out.println(opponentName + "'s turn.");
                        do{
                            opponentChoice = String.valueOf(randNum.nextInt(1,10));
                            validated = appUtil.CheckBoard(currentPlayer, opponentToken, opponentChoice, boardSpaces);
                        }while(!validated);
                        currentPlayer = 1;
                        break;
                    default:
                        System.out.println("*Error in selecting player. Please restart program" +
                            " and try again.");
                        break;
                }

                //check if board has 3 matching in a line
                winner = appUtil.CheckGame(playerToken, boardSpaces);

            }while(winner != 1 && winner != 2 && winner != 3);

            //display board (should be completely filled by now)
            appUtil.DisplayBoard(boardSpaces);

            //display who wins
            if(winner == 1){
                System.out.println("You win, " + playerName + "!");
            }else if(winner == 2){
                System.out.println(playerName + ", you lost.");
            }else{
                System.out.println("It is a tie.");
            }
            //call Compare Choice method and save the return value into scoreboard
            scoreboard = winner;

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
            do {
                userInput = input.next();
                gameOver = userInput.equals("n");

                if (!userInput.equals("y") && !userInput.equals("n")) {
                    System.out.print("Please enter y or n: ");
                }
            }while(!userInput.equals("y") && !userInput.equals("n"));
        }
    }
}

    //endregion
