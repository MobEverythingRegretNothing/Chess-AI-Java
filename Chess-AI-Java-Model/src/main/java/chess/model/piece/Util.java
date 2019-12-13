package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.ArrayList;
import java.util.List;

import static chess.model.Constants.*;

public class Util {

    static List<Move> getColumnMoves(GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = piece.getPosition().getBoardColumn().getPosition();
        int yStart = piece.getPosition().getBoardRow().getPosition();

        boolean blocked = false;
        for (int y = yStart + 1; y < yMax && !blocked; y++) {
            blocked = addMove(piece.getPosition(), xStart, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int y = yStart - 1; y >= yMin && !blocked; y--) {
            blocked = addMove(piece.getPosition(), xStart, y, gameState, piece, validMoves);
        }

        return validMoves;
    }

    static List<Move> getRowMoves(GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = piece.getPosition().getBoardColumn().getPosition();
        int yStart = piece.getPosition().getBoardRow().getPosition();

        boolean blocked = false;
        for (int x = xStart + 1; x < xMax && !blocked; x++) {
            blocked = addMove(piece.getPosition(), x, yStart, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart - 1; x >= xMin && !blocked; x--) {
            blocked = addMove(piece.getPosition(), x, yStart, gameState, piece, validMoves);
        }

        return validMoves;
    }

    static List<Move> getDiagonalMoves(GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = piece.getPosition().getBoardColumn().getPosition();
        int yStart = piece.getPosition().getBoardRow().getPosition();

        boolean blocked = false;

        for (int x = xStart + 1, y = yStart + 1; x < xMax && y < yMax && !blocked; x++, y++) {
            blocked = addMove(piece.getPosition(), x, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart - 1, y = yStart + 1; x >= xMin && y < yMax && !blocked; x--, y++) {
            blocked = addMove(piece.getPosition(), x, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart + 1, y = yStart - 1; x < xMax && y >= yMin && !blocked; x++, y--) {
            blocked = addMove(piece.getPosition(), x, y, gameState, piece, validMoves);
        }

        blocked = false;
        for (int x = xStart - 1, y = yStart - 1; x >= xMin && y >= yMin && !blocked; x--, y--) {
            blocked = addMove(piece.getPosition(), x, y, gameState, piece, validMoves);
        }

        return validMoves;
    }

    private static boolean addMove(Position startPosition, int x, int y,
                                   GameState gameState, Piece piece, List<Move> validMoves) {
        Piece[][] boardArray = gameState.getBoardArray();

        if (null == boardArray[x][y]) {
            validMoves.add(new Move(piece,
                    startPosition,
                    new Position(x, y), false,
                    gameState.getMoveNumber(),
                    piece.getColor()));
            return false;
        } else {
            if (boardArray[x][y].getColor() == piece.getColor()) {
                return true;
            } else {
                validMoves.add(
                        new Move(piece, startPosition, new Position(x, y),
                                true, gameState.getMoveNumber(), piece.getColor()
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

    public static Piece[][] transpose(Piece[][] matrix) {
        int n = matrix.length;
        Piece[][] transpose = new Piece[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }

    static Piece[][] flip(Piece[][] matrix) {
        int n = matrix.length;
        Piece[][] flipped = new Piece[n][n];
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                flipped[x][y] = flipped[x][n - 1 - y];
            }
        }

        return flipped;
    }
}
