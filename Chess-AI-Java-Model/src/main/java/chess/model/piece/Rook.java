package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.BoardRow;
import chess.model.enumeration.Color;

import java.util.ArrayList;
import java.util.List;

import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.getColumnMoves;
import static chess.model.piece.Util.getRowMoves;

public class Rook implements Piece {

    private Color color;
    private Position position;

    public Rook(Color color, BoardColumn column, BoardRow row) {
        this.color = color;
        this.position = new Position(column, row);
    }

    @Override
    public List<Move> getValidMoves(GameState gameState) {
        List<Move> validMoves = new ArrayList<>();

        validMoves.addAll(getColumnMoves(gameState, this));
        validMoves.addAll(getRowMoves(gameState, this));

        return validMoves;
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
        return color == WHITE ? "wR" : "bR";
    }
}
