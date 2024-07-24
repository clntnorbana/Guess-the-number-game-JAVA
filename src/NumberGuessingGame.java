import java.util.Random;
import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(100) + 1;
        int numberOfTries = 0;
        boolean hasGuessedCorrecty = false;
        final int MAX_LIMIT = 7;
        int guess;

        while (!hasGuessedCorrecty && numberOfTries < MAX_LIMIT) {
            System.out.print("Enter your guess: ");

            if(scan.hasNextInt()) {
                guess = scan.nextInt();
                numberOfTries++;
                hasGuessedCorrecty = checkGuess(guess, numberToGuess);
                int triedNumber = MAX_LIMIT - numberOfTries;

                if(!hasGuessedCorrecty) {
                    if(guess < numberToGuess) {
                        System.out.println("Higher, try again, " + triedNumber + " tries left");
                    } else {
                        System.out.println("Lower, try again, " + triedNumber + " tries left");
                    }
                }

            } else {
                System.out.println("Invalid input, please enter an integer");
                scan.next();
            }

            if(numberOfTries == MAX_LIMIT && !hasGuessedCorrecty) {
                System.out.println("Game Over! No tries remaining, the number is " + numberToGuess);
            }
        }

        System.out.println("Congratulations! you guessed the number in " + numberOfTries + " tries");
        scan.close();
    }

    public static boolean checkGuess(int guess, int numberToGuess) {
        return guess == numberToGuess;
    }
}