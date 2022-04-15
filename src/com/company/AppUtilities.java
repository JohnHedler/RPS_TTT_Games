package com.company;

public class AppUtilities {

    //region Methods

    //region Screen Methods

    //Clear Screen method: clears the space down on the screen to 'hide' previous output.
    public void ClearScreen(){
        System.out.println("\n\n\n\n\n\n");
    }

    //Display Header method: shows the title of the application.
    public void DisplayMainHeader(){
        System.out.println("=========================");
        System.out.println("=      Game Program     =");
        System.out.println("=========================");
        System.out.println("");
    }

    public void DisplayGameOneHeader(){
        System.out.println("=========================");
        System.out.println("= Rock, Paper, Scissors =");
        System.out.println("=========================");
        System.out.println("");
    }

    public void DisplayGameTwoHeader(){
        System.out.println("=========================");
        System.out.println("=     Tic, Tac, Toe     =");
        System.out.println("=========================");
        System.out.println("");
    }

    public void DisplayMainMenu(){
        System.out.println("\nWhich game do you want to play?");
        System.out.print("1) Rock, Paper, Scissors" +
                "\n2) Tic-Tac-Toe" +
                "\n3) Quit" +
                "\n\nChoice: ");
    }

    //End Program method: Thank user for playing at the end of program.
    public void EndProgram(){
        System.out.println("Thank you for playing!");
    }

    //endregion

    //region Rock, Paper, Scissors methods
    //Compare Choice method: compares and displays choices to user.
    //Returns three different values:
    //1) Win
    //2) Loss
    //3) Tie
    public int CompareChoice(String playerName, String playerChoice, String opponentName, String opponentChoice){
        System.out.println("");

        //display player and opponent choices
        switch(playerChoice){
            case "1": System.out.println(playerName + ", you chose rock."); break;
            case "2": System.out.println(playerName + ", you chose paper."); break;
            case "3": System.out.println(playerName + ", you chose scissors."); break;
        }

        switch(opponentChoice){
            case "1": System.out.println(opponentName + " chose rock."); break;
            case "2": System.out.println(opponentName + " chose paper."); break;
            case "3": System.out.println(opponentName + " chose scissors."); break;
        }
        
        //determine if player wins or not
        if(playerChoice.equals("1")){
            if(opponentChoice.equals("1")){
                System.out.println("It is a tie.");
                return 3;
            }else if(opponentChoice.equals("2")){
                System.out.println("Paper covers rock. You lose.");
                return 2;
            }else{
                System.out.println("Rock smashes scissors. You win!");
                return 1;
            }
        }

        if(playerChoice.equals("2")){
            if(opponentChoice.equals("1")){
                System.out.println("Paper covers rock. You win!");
                return 1;
            }else if(opponentChoice.equals("2")){
                System.out.println("It is a tie.");
                return 3;
            }else{
                System.out.println("Scissors cuts paper. You lose.");
                return 2;
            }
        }

        if(playerChoice.equals("3")){
            if(opponentChoice.equals("1")){
                System.out.println("Rock smashes scissors. You lose.");
                return 2;
            }else if(opponentChoice.equals("2")){
                System.out.println("Scissors cuts paper. You win!");
                return 1;
            }else{
                System.out.println("It is a tie.");
                return 3;
            }
        }

        //return tie by default
        return 3;
    }
    //endregion

    //region Tic-Tac-Toe methods

    //Display Board method: Displays board to the user.
    public void DisplayBoard(char[] boardSpaces){
        String gameBoard = String.format("""
                 %s | %s | %s 
                ---+---+---
                 %s | %s | %s 
                ---+---+---
                 %s | %s | %s 
                """, boardSpaces[0], boardSpaces[1], boardSpaces[2], boardSpaces[3],
                boardSpaces[4], boardSpaces[5], boardSpaces[6], boardSpaces[7], boardSpaces[8]);

        System.out.println(gameBoard);
    }

    public boolean CheckBoard(int player, char token, String choice, char[] boardSpaces){
        int index = 0;

        //try to convert choice to integer
        try{
            index = (Integer.parseInt(choice)) - 1;
        }
        catch(Exception e){
            System.out.println("*Invalid input. Please try again.");
        }

        //check if input matches a space on the board already taken
        if(boardSpaces[index] == 'X' || boardSpaces[index] == 'O'){
            if(player == 1){
                System.out.print("This space is already used. Please choose another: ");
            }
        }else{
            boardSpaces[index] = token;
            return true;
        }

        return false;
    }

    //Check Game method: Determine if a player has matched three in a row
    public int CheckGame(char playerToken, char[] boardSpaces){

        //check horizontal match
        if(boardSpaces[0] == 'X' && boardSpaces[1] == 'X' && boardSpaces[2] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[3] == 'X' && boardSpaces[4] == 'X' && boardSpaces[5] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[6] == 'X' && boardSpaces[7] == 'X' && boardSpaces[8] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[0] == 'O' && boardSpaces[1] == 'O' && boardSpaces[2] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[3] == 'O' && boardSpaces[4] == 'O' && boardSpaces[5] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[6] == 'O' && boardSpaces[7] == 'O' && boardSpaces[8] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }

        //check vertical match
        if(boardSpaces[0] == 'X' && boardSpaces[3] == 'X' && boardSpaces[6] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[1] == 'X' && boardSpaces[4] == 'X' && boardSpaces[7] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[2] == 'X' && boardSpaces[5] == 'X' && boardSpaces[8] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[0] == 'O' && boardSpaces[3] == 'O' && boardSpaces[6] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[1] == 'O' && boardSpaces[4] == 'O' && boardSpaces[7] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[2] == 'O' && boardSpaces[5] == 'O' && boardSpaces[8] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }

        //check diagonal
        if(boardSpaces[0] == 'X' && boardSpaces[4] == 'X' && boardSpaces[8] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[2] == 'X' && boardSpaces[4] == 'X' && boardSpaces[6] == 'X'){
            if(playerToken == 'X'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[0] == 'O' && boardSpaces[4] == 'O' && boardSpaces[8] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }
        if(boardSpaces[2] == 'O' && boardSpaces[4] == 'O' && boardSpaces[6] == 'O'){
            if(playerToken == 'O'){
                return 1;
            }else{
                return 2;
            }
        }

        //check if there is no winner (cat-scratch)
        if(boardSpaces[0] != ' ' && boardSpaces[1] != ' ' && boardSpaces[2] != ' ' && boardSpaces[3] != ' ' &&
                boardSpaces[4] != ' ' && boardSpaces[5] != ' ' && boardSpaces[6] != ' ' && boardSpaces[7] != ' ' &&
                boardSpaces[8] != ' '){
            return 3;
        }

        //return no winner yet by default
        return 0;
    }

    //endregion

    //endregion
}
