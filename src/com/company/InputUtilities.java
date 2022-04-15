package com.company;

import java.util.Scanner;

public class InputUtilities {

    //region Methods

    //Select Game method: check users input to determine what game to play
    public String SelectGame(){
        //variables for user input
        String userInput;
        Scanner input = new Scanner(System.in);
        boolean validated = false;

        //loop until user selects appropriate
        do{
            userInput = input.next();
            validated = ValidateInput(userInput);
        }while(!validated);

        return userInput;
    }

    //Validate Input method: Rock, Paper, Scissors input validation to prevent unwanted user input.
    public boolean ValidateInput(String input){
        //validation boolean
        boolean validated = false;

        //check if input is blank or empty
        if(input.isBlank() || input.isEmpty()){
            System.out.print("*Choice cannot be empty/blank (1, 2, 3): ");
        }

        switch(input){
            case "1":case "2":case "3": validated = true; break;
            default: System.out.print("*Please choose the appropriate options (1, 2, 3): "); break;
        }
        return validated;
    }

    //Validate Input method: Tic-Tac-Toe input validation to prevent unwanted user input.
    public boolean ValidateInput2(String input){
        //validation boolean
        boolean validated = false;

        //check if input is blank or empty
        if(input.isBlank() || input.isEmpty()){
            System.out.print("*Choice cannot be empty/blank (1-9): ");
        }

        switch(input){
            case "1": case "2": case "3": case "4": case "5": case "6": case "7": case "8": case "9": validated = true; break;
            default: System.out.print("*Please choose the appropriate options (1-9): "); break;
        }
        return validated;
    }

    //endregion
}
