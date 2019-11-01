package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.Collections;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.isDiagonalMove;

public class Bishop implements Piece {

    private Color color;

    public Bishop(Color color) {
        this.color = color;
    }

    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        return Collections.emptyList();
    }

    @Override
    public boolean isValidMove(Position startPosition, Position endPosition) {
        return isDiagonalMove(startPosition, endPosition);
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wB": "bB";
    }
}
