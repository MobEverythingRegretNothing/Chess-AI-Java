package chess.model;

import chess.model.enumeration.Color;
import chess.model.piece.Piece;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.EIGHT;
import static chess.model.enumeration.BoardRow.ONE;
import static chess.model.enumeration.Color.WHITE;
import static chess.model.enumeration.Color.toggle;

public class Move {
    private Piece piece;
    private Position startPosition;
    private Position endPosition;
    private boolean isLongCastle;
    private boolean isShortCastle;
    private boolean isCapture;
    private int moveNumber;
    private Color color;

    public Move(String moveString, GameState gameState) {

        Move lastMove = gameState.getMoveList().get(gameState.getMoveList().size() - 1);
        Color nextColor = toggle(lastMove.getColor());
        int nextMoveNumber = lastMove.getMoveNumber() + (lastMove.getColor() == WHITE ? 0 : 1);

        if (moveString.equalsIgnoreCase("O - O - O")) {
            if (lastMove.getColor() == WHITE) {
                this.startPosition = new Position(E, ONE);
                this.endPosition = new Position(C, ONE);
            } else {
                this.startPosition = new Position(E, EIGHT);
                this.endPosition = new Position(C, EIGHT);
            }

            this.isLongCastle = true;
            this.isShortCastle = false;
            this.isCapture = false;
            this.piece = gameState.getPieceAtLocation(startPosition);
            this.color = nextColor;
            this.moveNumber = nextMoveNumber;

        } else if (moveString.equalsIgnoreCase("O - O")) {
            if (lastMove.getColor() == WHITE) {
                this.startPosition = new Position(E, ONE);
                this.endPosition = new Position(G, ONE);
            } else {
                this.startPosition = new Position(E, EIGHT);
                this.endPosition = new Position(G, EIGHT);
            }

            this.isLongCastle = false;
            this.isShortCastle = true;
            this.isCapture = false;
            this.piece = gameState.getPieceAtLocation(startPosition);
            this.color = nextColor;
            this.moveNumber = nextMoveNumber;
        } else {
            if (moveString.contains("x")) {
                this.isCapture = true;
                String[] positions = moveString.split("x");
                this.startPosition = new Position(positions[0].charAt(0), positions[0].charAt(1));
                this.endPosition = new Position(positions[1].charAt(0), positions[1].charAt(1));
            } else {
                this.isCapture = false;
                String[] positions = moveString.split("->");
                this.startPosition = new Position(positions[0].charAt(0), positions[0].charAt(1));
                this.endPosition = new Position(positions[1].charAt(0), positions[1].charAt(1));
            }

            this.isLongCastle = false;
            this.isShortCastle = false;
            this.piece = gameState.getPieceAtLocation(startPosition);
            this.color = nextColor;
            this.moveNumber = nextMoveNumber;
        }
    }

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

    public boolean isLongCastle() {
        return isLongCastle;
    }

    public void setLongCastle(boolean longCastle) {
        isLongCastle = longCastle;
    }

    public boolean isShortCastle() {
        return isShortCastle;
    }

    public void setShortCastle(boolean shortCastle) {
        isShortCastle = shortCastle;
    }

    @Override
    public String toString() {
        return new StringBuilder(startPosition.toString()).append(isCapture ? "x" : " -> ").append(endPosition.toString()).toString();
    }
}
