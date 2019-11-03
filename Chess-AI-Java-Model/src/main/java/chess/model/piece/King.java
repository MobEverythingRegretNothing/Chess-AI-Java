package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.BoardRow;
import chess.model.enumeration.Color;
import chess.model.Position;

import java.util.ArrayList;
import java.util.List;

import static chess.model.Constants.*;
import static chess.model.Constants.yMax;
import static chess.model.enumeration.Color.WHITE;
import static chess.model.piece.Util.translateColor;

public class King implements Piece {

    private Color color;
    private Position position;

    public King(Color color, BoardColumn column, BoardRow row) {
        this.color = color;
        this.position = new Position(column, row);
    }

    @Override
    public List<Move> getValidMoves(GameState gameState) {
        List<Move> validMoves = new ArrayList<>();
        int[] x = {1, 1, 0, -1, -1, -1,  0,  1};
        int[] y = {0, 1, 1,  1,  0, -1, -1, -1};

        for (int i = 0; i < 8; i++) {
            int xPos = position.getBoardRow().getPosition() + x[i];
            int yPos = position.getBoardColumn().getPosition() + y[i];
            if (xPos >= xMin && yPos >= yMin && xPos < xMax && yPos < yMax && !gameState.getBoardArray()[xPos][yPos].contains(translateColor(color))) {
                validMoves.add(new Move(this,
                        position,
                        new Position(xPos, yPos),
                        !gameState.getBoardArray()[xPos][yPos].equals("  "),
                        gameState.getCurrentMove().moveNumber,
                        color));
            }
        }
        //TODO: Castling
        

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
        return color == WHITE ? "wK" : "bK";
    }
}
