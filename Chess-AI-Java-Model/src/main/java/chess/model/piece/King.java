package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.BoardRow;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.Collections;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;

public class King implements Piece {

    private Color color;
    private Position position;

    public King(Color color, BoardColumn column, BoardRow row) {
        this.color = color;
        this.position = new Position(column, row);
    }

    @Override
    public List<Move> getValidMoves(GameState gameState) {

        return Collections.emptyList();
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wK" : "bK";
    }
}
