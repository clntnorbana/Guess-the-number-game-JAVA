import java.util.Random;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        int triesLeft;
        int guess;
        final int MAXIMUM_TRIES = 7;
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly && numberOfTries < MAXIMUM_TRIES) {
            System.out.print("Enter your guess: ");

            if(scan.hasNextInt()) {
                guess = scan.nextInt();
                numberOfTries++;
                triesLeft = MAXIMUM_TRIES - numberOfTries;
 
                hasGuessedCorrectly = checkGuess(guess, numberToGuess);
                
                if(!hasGuessedCorrectly) {
                   System.out.println(takeAGuess(guess, numberToGuess, triesLeft));
                } else {
                    System.out.println("Congratulations! you guessed the number in " + numberOfTries + " tries");
                    scan.close();
                }

            } else {
                System.out.println("Invalid input, please enter an integer");
                scan.next();
            }

            if(numberOfTries == MAXIMUM_TRIES && !hasGuessedCorrectly) {
                System.out.println("Game Over! no tries remain, the number is " + numberToGuess);
            }
        }

    }

    public static boolean checkGuess(int guess, int numberToGuess) {
        return guess == numberToGuess;
    }

    public static String takeAGuess(int guess, int numberToGuess, int triesLeft) {
        String message;

        if(guess < numberToGuess) {
            message = "Higher! try again, " + triesLeft + " tries left";
        }  else {
            message = "Lower! try again, " + triesLeft + " tries left";
        }

        return message;
    }
}