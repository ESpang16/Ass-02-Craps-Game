import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;
        String userInput;
        while (playAgain) {
            int die1 = rollDie();
            int die2 = rollDie();
            int sum = die1 + die2;
            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = sum;
                System.out.println("Your point is " + point);
                boolean tryingForPoint = true;
                while (tryingForPoint) {
                    System.out.println("Rolling for the point...");
                    die1 = rollDie();
                    die2 = rollDie();
                    sum = die1 + die2;

                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made the point! You win.");
                        tryingForPoint = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7! You lose.");
                        tryingForPoint = false;
                    }
                }
            }
            do {
                System.out.print("Do you want to play again? (yes/no): ");
                userInput = scanner.nextLine().toLowerCase();
                if (!userInput.equals("yes") && !userInput.equals("no")) {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                }
            } while (!userInput.equals("yes") && !userInput.equals("no"));
            playAgain = userInput.equals("yes");
        }
        System.out.println("Thanks for playing!");
    }
    public static int rollDie() {
        Random rnd = new Random();
        return rnd.nextInt(6) + 1;
    }
}