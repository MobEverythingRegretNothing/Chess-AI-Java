package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.Collections;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;

public class Queen implements Piece {

    private final Color color;

    public Queen(Color color) {
        this.color = color;
    }

    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        return Collections.emptyList();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wQ" : "bQ";
    }
}
