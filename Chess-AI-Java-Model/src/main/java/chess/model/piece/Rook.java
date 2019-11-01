package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.ArrayList;
import java.util.List;

import static chess.model.Constants.*;
import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.*;

public class Rook implements Piece {

    private Color color;

    public Rook(Color color) {
        this.color = color;
    }


    @Override
    public List<Move> getValidMoves(Position startPosition, GameState gameState) {
        List<Move> validMoves = new ArrayList<>();

        validMoves.addAll(getColumnMoves(startPosition, gameState, this));
        validMoves.addAll(getRowMoves(startPosition, gameState, this));

        return validMoves;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == WHITE ? "wR" : "bR";
    }
}
