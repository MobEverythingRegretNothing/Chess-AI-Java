package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.Collections;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;

public class Knight implements Piece {

    private Color color;

    public Knight(Color color) {
        this.color = color;
    }

    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        return Collections.emptyList();
    }

    @Override
    public boolean isValidMove(Position startPosition, Position endPosition) {
        int yDistance = Math.abs(startPosition.getBoardColumn().getPosition() - endPosition.getBoardColumn().getPosition());
        int xDistance = Math.abs(startPosition.getBoardRow().getPosition() - endPosition.getBoardRow().getPosition());

        return xDistance + yDistance == 3 && xDistance != 0 && yDistance != 0;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wN" : "bN";
    }
}
