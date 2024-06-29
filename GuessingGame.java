import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;
        int roundsWon = 0;
        int totalRounds = 0;
        boolean playAgain = true;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("Guess a number between 1 and 100:");

            while (attempts < maxAttempts && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("Correct! You've guessed the number.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was: " + numberToGuess);
            }

            totalRounds++;
            System.out.println("Do you want to play again? (yes/no)");
            scanner.nextLine(); // Consume the newline character
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over. You won " + roundsWon + " out of " + totalRounds + " rounds.");
        scanner.close();
    }
}
