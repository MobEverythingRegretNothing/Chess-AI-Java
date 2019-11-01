package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.ArrayList;
import java.util.List;

import static chess.model.Constants.*;

class Util {

    static List<Move> getColumnMoves(Position startPosition, GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = startPosition.getBoardColumn().getPosition();
        int yStart = startPosition.getBoardRow().getPosition();

        boolean blocked = false;
        for (int y = yStart + 1; y < yMax && !blocked; y++) {
            blocked = addMove(startPosition, xStart, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int y = yStart - 1; y >= yMin && !blocked; y--) {
            blocked = addMove(startPosition, xStart, y, gameState, piece, validMoves);
        }

        return validMoves;
    }

    static List<Move> getRowMoves(Position startPosition, GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = startPosition.getBoardColumn().getPosition();
        int yStart = startPosition.getBoardRow().getPosition();

        boolean blocked = false;
        for (int x = xStart + 1; x < xMax && !blocked; x++) {
            blocked = addMove(startPosition, x, yStart, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart - 1; x >= xMin && !blocked; x--) {
            blocked = addMove(startPosition, x, yStart, gameState, piece, validMoves);
        }

        return validMoves;
    }

    static List<Move> getDiagonalMoves(Position startPosition, GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = startPosition.getBoardColumn().getPosition();
        int yStart = startPosition.getBoardRow().getPosition();

        boolean blocked = false;

        for (int x = xStart + 1, y = yStart + 1; x < xMax && y < yMax && !blocked; x++, y++) {
            blocked = addMove(startPosition, x, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart - 1, y = yStart + 1; x >= xMin && y < yMax && !blocked; x--, y++) {
            blocked = addMove(startPosition, x, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart + 1, y = yStart - 1; x < xMax && y >= yMin && !blocked; x++, y--) {
            blocked = addMove(startPosition, x, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart - 1, y = yStart - 1; x >= xMin && y >= yMin && !blocked; x--, y--) {
            blocked = addMove(startPosition, x, y, gameState, piece, validMoves);
        }

        return validMoves;
    }

    private static boolean addMove(Position startPosition, int x, int y,
                                   GameState gameState, Piece piece, List<Move> validMoves) {
        String[][] boardArray = gameState.getBoardArray();

        if ("  ".equals(boardArray[x][y])) {
            validMoves.add(new Move(piece,
                    startPosition,
                    new Position(x, y), false,
                    gameState.getCurrentMove().moveNumber,
                    piece.getColor()));
            return false;
        } else {
            if (boardArray[x][y].contains(translateColor(piece.getColor()))) {
                return true;
            } else {
                validMoves.add(
                        new Move(piece, startPosition, new Position(x, y),
                                true, gameState.getCurrentMove().moveNumber, piece.getColor()
                        )
                );
                return true;
            }
        }
    }


    static String translateColor(Color color) {
        switch (color) {
            case BLACK:
                return "b";
            case WHITE:
                return "w";
            default:
                return "";
        }
    }

    static String[][] transpose(String[][] matrix) {
        int n = matrix.length;
        String[][] transpose = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
