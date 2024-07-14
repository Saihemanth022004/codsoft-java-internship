import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        int rounds = 0;
        int totalAttempts = 0;

        while (playAgain) {
            // Generate a random number within the specified range
            Random random = new Random();
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nGuess the number between 1 and 100. You have up to 10 attempts.");

            // Loop until the user guesses correctly or runs out of attempts
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    guessedCorrectly = true;
                    System.out.println("Congratulations! Your guess is correct!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + number + ".");
            }

            rounds++;
            totalAttempts += attempts;

            // Ask the user if they want to play another round
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("You played " + rounds + " rounds with a total of " + totalAttempts + " attempts.");
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}
