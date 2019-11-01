package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.ArrayList;
import java.util.List;

import static chess.model.Constants.*;

class Util {

    static boolean isDiagonalMove(Position startPosition, Position endPosition) {
        return Math.abs(startPosition.getBoardRow().getPosition() - endPosition.getBoardRow().getPosition())
                == Math.abs(startPosition.getBoardColumn().getPosition() - endPosition.getBoardColumn().getPosition());
    }

    static boolean isStraightMoveAlongColumn(Position startPosition, Position endPosition) {
        return startPosition.getBoardColumn().getPosition() - endPosition.getBoardColumn().getPosition() == 0;
    }

    static boolean isStraightMoveAlongRow(Position startPosition, Position endPosition) {
        return startPosition.getBoardRow().getPosition() - endPosition.getBoardRow().getPosition() == 0;
    }

    public static List<Move> getColumnMoves(Position startPosition, GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = startPosition.getBoardColumn().getPosition();
        int yStart = startPosition.getBoardRow().getPosition();

        String[] column = transpose(gameState.getBoardArray())[xStart];

        boolean blocked = false;
        for (int y = yStart + 1; y < yMax && !blocked; y++) {
            if ("  ".equals(column[y])) {
                validMoves.add(
                        new Move(
                                piece, startPosition, new Position(xStart, y),
                                false, (int) gameState.getCurrentMove().moveNumber, piece.getColor()));
            } else {
                if (column[y].contains(translateColor(piece.getColor()))) {
                    blocked = true;
                } else {
                    validMoves.add(
                            new Move(
                                    piece, startPosition, new Position(xStart, y),
                                    true, (int) gameState.getCurrentMove().moveNumber, piece.getColor()
                            )
                    );
                    blocked = true;
                }
            }
        }

        blocked = false;
        for (int y = yStart - 1; y >= yMin && !blocked; y--) {
            if ("  ".equals(column[y])) {
                validMoves.add(
                        new Move(
                                piece, startPosition, new Position(xStart, y),
                                false, (int) gameState.getCurrentMove().moveNumber, piece.getColor()));
            } else {
                if (column[y].contains(translateColor(piece.getColor()))) {
                    blocked = true;
                } else {
                    validMoves.add(
                            new Move(
                                    piece, startPosition, new Position(xStart, y),
                                    true, (int) gameState.getCurrentMove().moveNumber, piece.getColor()
                            )
                    );
                    blocked = true;
                }
            }
        }

        return validMoves;
    }

    public static List<Move> getRowMoves(Position startPosition, GameState gameState, Piece piece) {
        List<Move> validMoves = new ArrayList<>();

        int xStart = startPosition.getBoardColumn().getPosition();
        int yStart = startPosition.getBoardRow().getPosition();

        String[] row = gameState.getBoardArray()[yStart];

        boolean blocked = false;
        for (int x = xStart + 1; x < xMax && !blocked; x++) {
            if ("  ".equals(row[x])) {
                validMoves.add(
                        new Move(
                                piece, startPosition, new Position(x, yStart),
                                false, (int) gameState.getCurrentMove().moveNumber, piece.getColor()));
            } else {
                if (row[x].contains(translateColor(piece.getColor()))) {
                    blocked = true;
                } else {
                    validMoves.add(
                            new Move(
                                    piece, startPosition, new Position(x, yStart),
                                    true, (int) gameState.getCurrentMove().moveNumber, piece.getColor()
                            )
                    );
                    blocked = true;
                }
            }
        }

        blocked = false;
        for (int x = xStart - 1; x >= xMin && !blocked; x--) {
            if ("  ".equals(row[x])) {
                validMoves.add(
                        new Move(
                                piece, startPosition, new Position(x, yStart),
                                false, (int) gameState.getCurrentMove().moveNumber, piece.getColor()));
            } else {
                if (row[x].contains(translateColor(piece.getColor()))) {
                    blocked = true;
                } else {
                    validMoves.add(
                            new Move(
                                    piece, startPosition, new Position(x, yStart),
                                    true, (int) gameState.getCurrentMove().moveNumber, piece.getColor()
                            )
                    );
                    blocked = true;
                }
            }
        }

        return validMoves;
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
