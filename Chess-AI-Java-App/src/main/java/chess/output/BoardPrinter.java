package chess.output;

import chess.model.GameState;
import chess.model.enumeration.Color;

import java.util.Arrays;
import java.util.stream.Collectors;

import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.transpose;

public class BoardPrinter {

    public static void printBoard(GameState gameState, Color playerColor) {
        System.out.println("-----------------------------------------");
        for (int i = 1; i < 9; i++) {
            System.out.println(getRowString(gameState, i, playerColor));
            System.out.println("-----------------------------------------");
        }
    }

    private static String getRowString(GameState gameState, int rowNumber, Color playerColor) {
        return "| " + Arrays.stream(transpose(gameState.getBoardArray())[playerColor == WHITE ?  8 - rowNumber : rowNumber - 1])
                .map(piece -> piece == null ? "  " : piece.toString()).collect(Collectors.joining(" | ")) + " |";
    }
}
