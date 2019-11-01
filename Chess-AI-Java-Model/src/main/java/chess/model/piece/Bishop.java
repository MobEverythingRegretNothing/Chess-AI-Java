package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.List;

import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.getDiagonalMoves;

public class Bishop implements Piece {

    private Color color;

    public Bishop(Color color) {
        this.color = color;
    }

    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        return getDiagonalMoves(startPosition, gameState, this);
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
