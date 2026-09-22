// Dan Murlaga
// Written with assistance from Github Copilot

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {
        // Inititaes variables and objects
        ArrayList<VideoGame> gameLibrary = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String title, publisher, isOnline;
        double versionNumber;
        int releaseYear, numGames;

        // Prompts user for number of games to create
        System.out.print("Enter the number of games to add: ");
        numGames = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Main loop to create VideoGame objects
        for (int i = 0; i < numGames; i++) {
            System.out.print("Enter the title of the game: ");
            title = scanner.nextLine();

            System.out.print("Enter the publisher of the game: ");
            publisher = scanner.nextLine();

            System.out.print("Is this an online game? (yes/no): ");
            isOnline = scanner.nextLine();

            // Checks whether to create an OnlineGame or RPG object based on user input
            if (isOnline.equalsIgnoreCase("yes")) {
                System.out.print("Enter the version number: ");
                versionNumber = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                gameLibrary.add(new OnlineGame(title, publisher, versionNumber));
            } else {
                System.out.print("Enter the release year: ");
                releaseYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                gameLibrary.add(new RPG(title, publisher, releaseYear));
            }
        }

        scanner.close();

        // Displays all games in the gameLibrary
        System.out.println("\nGames in your library:");
        for (VideoGame game : gameLibrary) {
            System.out.println(game);
        }
    }
}