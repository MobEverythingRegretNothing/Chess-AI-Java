package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.Collections;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;

public class King implements Piece {

    private Color color;

    public King(Color color) {
        this.color = color;
    }

    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        return Collections.emptyList();
    }

    @Override
    public boolean isValidMove(Position startPosition, Position endPosition) {
        return Math.abs(startPosition.getBoardColumn().getPosition() - endPosition.getBoardColumn().getPosition()) < 2 &&
                Math.abs(startPosition.getBoardRow().getPosition() - endPosition.getBoardRow().getPosition()) < 2;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wK" : "bK";
    }
}
