// Dan Murlaga
// Written with assistance from Github Copilot

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {
        // Inititaes variables and objects
        ArrayList<VideoGame> gameLibrary = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);
        File libraryData = new File("library.csv");
        try {
            int invalid = 0;
            Scanner libraryScanner = new Scanner(libraryData);
            while (libraryScanner.hasNextLine()) {
                try {
                    String[] currentRow = libraryScanner.nextLine().split(",");
                    if (currentRow[0].equals("S")) {
                        gameLibrary.add(
                                new SinglePlayerGame(currentRow[1], currentRow[2], Integer.valueOf(currentRow[3])));
                    } else if (currentRow[0].equals("O")) {
                        gameLibrary.add(new OnlineGame(currentRow[1], currentRow[2], Double.valueOf(currentRow[3])));
                    } else {
                        invalid++;
                    }
                } catch (NumberFormatException e) {
                    invalid++;
                }
            }
            if (invalid > 0) {
                System.out.printf("%d invalid library entr%s found.\n", invalid, invalid == 1 ? "y" : "ies");
                System.out.println("Removing invalid entries...");
                updateLibrary(libraryData, gameLibrary);
            }
            libraryScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Initializing empty library...");
        }

        boolean shouldExit = false;

        while (!shouldExit) {
            System.out.print(
                """
                Game Library Manager
                1: Show Game Library
                2: Add Game
                3: Remove Game
                4: Quit
                """
            );
            System.out.print("> ");
            String input = userInput.nextLine();
            switch (input) {
                case "1":
                    System.out.println("Games in library:");
                    if (gameLibrary.isEmpty()) {
                        System.out.println("(No games in library)");
                    } else {
                        for (int i = 0; i < gameLibrary.size(); i++) {
                            System.out.printf("%d: %s\n", i + 1, gameLibrary.get(i).toString());
                        }
                    }
                    System.out.print("> (Press Enter to continue)");
                    userInput.nextLine();
                    break;
                case "2":
                    VideoGame game = createVideoGameFromInput(userInput);
                    if (gameLibrary.contains(game)) {
                        boolean proceed = false;
                        boolean shouldDelete = false;
                        while (!proceed) {
                            System.out.print(
                                """
                                Are you sure you want to overwrite a
                                preexisting game in your library?
                                1: Yes
                                2: No
                                """
                            );
                            System.out.print("> ");
                            String response = userInput.nextLine();
                            if (response.equals("1")) {
                                proceed = true;
                                shouldDelete = true;
                            } else if (response.equals("2")) {
                                proceed = true;
                            }
                        }
                        if (shouldDelete) {
                            gameLibrary.remove(game);
                            gameLibrary.add(game);
                        }
                    } else {
                        gameLibrary.add(game);
                    }
                    updateLibrary(libraryData, gameLibrary);
                    break;
                case "3":
                    System.out.println("Delete a selected game from your library:");
                    if (gameLibrary.isEmpty()) {
                        System.out.println("(No games in library to delete)");
                        System.out.print("> (Press Enter to continue)");
                        userInput.nextLine();
                    } else {
                        for (int i = 0; i < gameLibrary.size(); i++) {
                            System.out.printf("%d: %s\n", i + 1, gameLibrary.get(i).toString());
                        }
                        System.out.println("(Type \"exit\" to cancel deletion)");
                        boolean proceed = false;
                        while (!proceed) {
                            String response = userInput.nextLine();
                            if (response.equalsIgnoreCase("exit")) {
                                proceed = true;
                            } else {
                                try {
                                    int index = Integer.parseInt(response);
                                    if (index >= 1 && index <= gameLibrary.size()) {
                                        proceed = true;
                                        gameLibrary.remove(index - 1);
                                    }
                                } catch (NumberFormatException e) {
                                }
                            }
                        }
                        updateLibrary(libraryData, gameLibrary);
                    }
                    break;
                case "4":
                    updateLibrary(libraryData, gameLibrary);
                    shouldExit = true;
                    break;
                default:
                    break;
            }
        }

        // String title, publisher, isOnline;
        // double versionNumber;
        // int releaseYear, numGames;

        // // Prompts user for number of games to create
        // System.out.print("Enter the number of games to add: ");
        // numGames = scanner.nextInt();
        // scanner.nextLine(); // Consume newline

        // // Main loop to create VideoGame objects
        // for (int i = 0; i < numGames; i++) {
        // System.out.print("Enter the title of the game: ");
        // title = scanner.nextLine();

        // System.out.print("Enter the publisher of the game: ");
        // publisher = scanner.nextLine();

        // System.out.print("Is this an online game? (yes/no): ");
        // isOnline = scanner.nextLine();

        // // Checks whether to create an OnlineGame or RPG object based on user input
        // if (isOnline.equalsIgnoreCase("yes")) {
        // System.out.print("Enter the version number: ");
        // versionNumber = scanner.nextDouble();
        // scanner.nextLine(); // Consume newline
        // gameLibrary.add(new OnlineGame(title, publisher, versionNumber));
        // } else {
        // System.out.print("Enter the release year: ");
        // releaseYear = scanner.nextInt();
        // scanner.nextLine(); // Consume newline
        // gameLibrary.add(new SinglePlayerGame(title, publisher, releaseYear));
        // }
        // }

        userInput.close();

        // Displays all games in the gameLibrary
        // System.out.println("\nGames in your library:");
        // for (VideoGame game : gameLibrary) {
        //     System.out.println(game);
        // }

    }

    public static void updateLibrary(File file, ArrayList<VideoGame> games) {
        try {
            PrintWriter writer = new PrintWriter(file);
            games.forEach(g -> writer.println(g.serialize()));
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Something went wrong with updating your library.");
            System.out.println("Aborting library update.");
        }
    }

    public static VideoGame createVideoGameFromInput(Scanner input) {
        boolean shouldAdvance = false;
        boolean isSingleplayer = false;
        while (!shouldAdvance) {
            System.out.print(
                """
                Is the game a multiplayer or single player game?
                1: Multiplayer
                2: Single Player
                """
            );
            System.out.print("> ");
            String response = input.nextLine();
            if (response.equals("1")) {
                shouldAdvance = true;
            } else if (response.equals("2")) {
                shouldAdvance = true;
                isSingleplayer = true;
            }
        }
        System.out.println("What is the title of the game?");
        String title = input.nextLine();
        System.out.println("Who is the publisher of the game?");
        String publisher = input.nextLine();
        while (true) {
            try {
                if (isSingleplayer) {
                    System.out.println("When was the game released?");
                    int year = input.nextInt();
                    input.nextLine();
                    return new SinglePlayerGame(title, publisher, year);
                } else {
                    System.out.println("What is the game's version?");
                    double version = input.nextDouble();
                    input.nextLine();
                    return new OnlineGame(title, publisher, version);
                }
            } catch (InputMismatchException e) {
            }
        }
    }
}