import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("*****Try to guess the number 1-100, 7 tries remain*****\n");

        boolean playAgain = true;

        while (playAgain) {
            playGuessingGame(scan);

            System.out.print("\nDo you want to play again? Press 'p' to play again, other case to quit: ");
            String playAgainInput = scan.next();

            System.out.println("\n");

            if(!playAgainInput.equalsIgnoreCase("p")) { 
                playAgain = false;

                System.out.println("Thank you for playing the game!");
            }
        }

        scan.close();
    }

    public static void playGuessingGame(Scanner scan) {
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int triesLeft;
        int guess;
        final int MAXIMUM_TRY = 7;
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly && numberOfTries < MAXIMUM_TRY) {
            System.out.print("Enter your guess: ");

            if(scan.hasNextInt()) {
                guess = scan.nextInt();
                numberOfTries++;
                triesLeft = MAXIMUM_TRY - numberOfTries;
                hasGuessedCorrectly = checkGuess(guess, numberToGuess);

                if(!hasGuessedCorrectly) {
                    System.out.println(takeAGuess(guess, numberToGuess, triesLeft));
                } else {
                    System.out.println("Congratulations! you guessed the number in " + numberOfTries + " tries!");
                }

                if(numberOfTries == MAXIMUM_TRY && !hasGuessedCorrectly) {
                    System.out.println("Game Over! no tries remain, the number is " + numberToGuess);
                } 


            } else {
                System.out.println("Invalid input, please enter an integer");
                scan.next();
            }
        }
    }

    public static boolean checkGuess(int guess, int numberToGuess) {
        return guess == numberToGuess;
    }

    public static String takeAGuess(int guess, int numberToGuess, int triesLeft) {
        String message;

        if(guess < numberToGuess) {
            message = "Higher! try again, " + triesLeft + " left";
        } else {
            message = "Lower! try again, " + triesLeft + " left";
        }

        return message;
    }
}