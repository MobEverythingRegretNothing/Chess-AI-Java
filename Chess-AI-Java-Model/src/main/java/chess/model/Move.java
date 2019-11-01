package chess.model;

import chess.model.enumeration.Color;
import chess.model.piece.Piece;

public class Move {
    private Piece piece;
    private Position startPosition;
    private Position endPosition;
    private boolean isCapture;
    private int moveNumber;
    private Color color;

    public Move(Piece piece, Position startPosition, Position endPosition, boolean isCapture, int moveNumber, Color color) {
        this.piece = piece;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
        this.isCapture = isCapture;
        this.moveNumber = moveNumber;
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getStartPosition() {
        return startPosition;
    }

    public Position getEndPosition() {
        return endPosition;
    }

    public boolean isCapture() {
        return isCapture;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return new StringBuilder(startPosition.toString()).append(isCapture ? "x" : " -> ").append(endPosition.toString()).toString();
    }
}
