package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import chess.model.enumeration.Color;

import java.util.List;

public interface Piece {

    List<Move> getValidMoves(Position startPosition, GameState gameState);

    Color getColor();
}
