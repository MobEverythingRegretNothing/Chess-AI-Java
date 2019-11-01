package chess;

import chess.model.GameState;
import chess.model.enumeration.Color;
import chess.output.BoardPrinter;

import java.util.Scanner;

import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;

public class GameController {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Play a game of chess!");
            System.out.println("Which side would you prefer?\n\tW. White\n\tB. Black\n\tR. Random");
            String option = input.next();
            Color playerColor;

            switch (option) {
                case "W":
                case "w":
                    playerColor = WHITE;
                    break;
                case "B":
                case "b":
                    playerColor = BLACK;
                    break;
                default:
                    playerColor = (Math.random() <= 0.5) ? BLACK : WHITE;
                    break;
            }

            System.out.println(String.format("You are %s!", playerColor.toString()));
            GameState gameState = new GameState().init();

            BoardPrinter.printBoard(gameState, playerColor);
            System.out.println("Your move...");

            boolean gameOngoing = true;
            Color turnIndicator = WHITE;

            while (gameOngoing) {
                





            }

        }
    }

}
