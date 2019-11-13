package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.BoardRow;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static chess.model.Constants.*;
import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.translateColor;

public class Knight implements Piece {

    private Color color;
    private Position position;

    public Knight(Color color, BoardColumn column, BoardRow row) {
        this.color = color;
        this.position = new Position(column, row);
    }

    @Override
    public List<Move> getValidMoves(GameState gameState) {
        List<Move> validMoves = new ArrayList<>();
        int[] x = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] y = {1, 2, 2, 1, -1 - 2, -2, -1};

        for (int i = 0; i < 8; i++) {
            int xPos = position.getBoardRow().getPosition() + x[i];
            int yPos = position.getBoardColumn().getPosition() + y[i];
            if (xPos >= xMin && yPos >= yMin && xPos < xMax && yPos < yMax && !(gameState.getBoardArray()[xPos][yPos].getColor() == color)) {
                validMoves.add(new Move(this,
                        position,
                        new Position(xPos, yPos),
                        !Objects.isNull(gameState.getBoardArray()[xPos][yPos]),
                        gameState.getCurrentMove().moveNumber,
                        color));
            }
        }

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
        return color == WHITE ? "wN" : "bN";
    }
}
