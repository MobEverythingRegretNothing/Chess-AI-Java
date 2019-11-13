package chess;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.Color;
import chess.output.BoardPrinter;

import java.util.Scanner;
import java.util.stream.Collectors;

import static chess.Util.isResignation;
import static chess.model.enumeration.Color.*;

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
            while (gameOngoing) {

                // TODO: Ask for input move OR resign
                System.out.print("Please input a move: ");
                String move = input.next();

                if (isResignation(move)) {
                    gameOngoing = false;
                } else {
                    // TODO: Validate player choice
                    if (gameState.getValidMoves().stream().map(Move::toString).collect(Collectors.toList()).contains(move)) {
                        Move currentMove = gameState.getMoveList().get(gameState.getMoveList().size() - 1);
                        System.out.println("Valid Move!");

                        // TODO: Do Move
                        System.out.println("Moving . . .");

                        // TODO: Check for CHECKMATE/CHECK/DRAW (REPETITION/NO VALID MOVES/MAX MOVES/TIME???)

                        // TODO: Add move to and advance gamestate
                        gameState.addMove(new Move(move, gameState));
                    }
                }



            }

        }
    }

}
