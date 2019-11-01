package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.Collections;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;

public class Pawn implements Piece {
    private Color color;

    public Pawn(Color color) {
        this.color = color;
    }

    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        return Collections.emptyList();
    }

    public boolean isValidMove(Position startPosition, Position endPosition) {
        if (color == WHITE) {
            if (2 == startPosition.getBoardRow().getPosition()) {
                return endPosition.getBoardColumn().getPosition() - startPosition.getBoardColumn().getPosition() == 0
                        && endPosition.getBoardRow().getPosition() - startPosition.getBoardRow().getPosition() == 1 ||
                        endPosition.getBoardRow().getPosition() - startPosition.getBoardRow().getPosition() == 2;
            } else {
                return endPosition.getBoardColumn().getPosition() - startPosition.getBoardColumn().getPosition() == 0
                        && endPosition.getBoardRow().getPosition() - startPosition.getBoardRow().getPosition() == 1;
            }
        } else {
            if (7 == startPosition.getBoardRow().getPosition()) {
                return (endPosition.getBoardColumn().getPosition() - startPosition.getBoardColumn().getPosition() == 0
                        && endPosition.getBoardRow().getPosition() - startPosition.getBoardRow().getPosition() == -1
                        || endPosition.getBoardRow().getPosition() - startPosition.getBoardRow().getPosition() == -2);

            } else {
                return (endPosition.getBoardColumn().getPosition() - startPosition.getBoardColumn().getPosition() == 0
                        && endPosition.getBoardRow().getPosition() - startPosition.getBoardRow().getPosition() == -1);
            }
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wP" : "bP";
    }
}
