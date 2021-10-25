package novi.hangman;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Welcome to Hangman! press 'p' to start a game\n");

                String line = scanner.nextLine();
                if (line.equals("p")) {
                    System.out.println(game.startNewGame());
                } else {
                    System.out.printf("%s is not a valid command\n", line);
                }

                while (game.isGameRunning()) {
                    String guess = scanner.nextLine();
                    var response = game.applyGuess(guess);
                    for (var responseLine : response) {
                        System.out.println(responseLine);
                    }
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("System.in was closed; exiting");
        } finally {
            scanner.close();
        }
    }
}
