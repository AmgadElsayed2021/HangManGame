
//Importing the java package
import java.util.Scanner;
import java.util.Random;
import java.util.LinkedList;
import java.net.*;
import java.io.*;

//Main class of the program
class Game{
    //Printing the user's guessed character
    public static void printArray(char[] array){
        for(int i =0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static boolean isTheWordGuessed(char[] array){
        for(int i =0; i < array.length; i++){
            if(array[i] == '_') {return false;}
        }
        return true;
    }

    //Main Class of the program
    public static void main(String[] args){
        //Creating the object of scanner class
        Scanner scanner = new Scanner(System.in);
        //Creating the object of random class
        Random random = new Random();
        //Array of available strings
        String[] guesses = {"stechies","tutorial","programming","google","facebook","sap","tomato"};

        boolean weArePlaying = true;
        //Checking with user that Are we still in the play
        while(weArePlaying){
            System.out.println("Welcome to my game of Hangman");
            char[] randomWordToGuess = guesses[random.nextInt(guesses.length)].toCharArray();

            int NumberOfGuesses = randomWordToGuess.length;
            char[] playerGuess = new char[NumberOfGuesses];

            for(int i = 0; i < playerGuess.length; i++){
                playerGuess[i] = '_';
            }

            boolean wordIsGuessed = false;
            int tries = 0;
            //Loop will till the number of guesses will not
            // equals to the available amount of guesses
            while( !wordIsGuessed && tries != NumberOfGuesses ){
                System.out.print("Current guesses : ");
                printArray(playerGuess);
                //Giving information to the user how many guesses are available
                System.out.printf("You have %d tries left.n", NumberOfGuesses - tries);
                //Telling user what to enter
                System.out.println("Enter a single character : ");
                char input = scanner.nextLine().charAt(0);
                //Increasing the tries counter
                tries++;

                if(input == '-'){
                    weArePlaying = false;
                    wordIsGuessed = true;
                }else{

                    for(int i = 0; i < randomWordToGuess.length; i++){
                        if(randomWordToGuess[i] == input) {
                            playerGuess[i] = input;
                        }
                    }

                    if(isTheWordGuessed(playerGuess)){
                        wordIsGuessed = true;
                        System.out.println("nn**************************nCongratulations you won!n**************************");
                    }

                }
            }
            //If loop if user out of moves
            if(!wordIsGuessed) System.out.println("You ran out of guesses :/");
            //Asking user if user wants to continue the game
            System.out.print("nDo you want to play another game? (y/n) : ");
            String anotherGame = scanner.nextLine();
            if(anotherGame.equals("n")) weArePlaying = false;
        }
        System.out.println("Game Over");
    }
}