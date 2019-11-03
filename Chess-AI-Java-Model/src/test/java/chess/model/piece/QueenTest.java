package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import org.junit.Test;

import java.util.List;

import static chess.model.enumeration.BoardColumn.C;
import static chess.model.enumeration.BoardRow.FIVE;
import static chess.model.enumeration.BoardRow.FOUR;
import static chess.model.enumeration.Color.BLACK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueenTest {


    @Test
    public void queen_getsValidMoves_emptyBoard() {
        Queen blackQueen = new Queen(BLACK, C, FIVE);
        GameState gameState = new GameState();
        gameState.getPieceList().add(blackQueen);
        List<Move> validMoves = blackQueen.getValidMoves(gameState);
        assertEquals("Black Queen has incorrect number of valid moves", 25, validMoves.size());
    }

    @Test
    public void queen_getsValidMoves_blocked() {
        Queen blackQueen = new Queen(BLACK, C, FIVE);
        GameState gameState = new GameState();
        gameState.getPieceList().add(blackQueen);
        gameState.getPieceList().add(new Rook(BLACK, C, FOUR));
        List<Move> validMoves = blackQueen.getValidMoves(gameState);
        assertEquals("Black Queen has incorrect number of valid moves", 21, validMoves.size());
        assertTrue("Black queen can move past it's own pieces",
                validMoves.stream().noneMatch(move -> move.getEndPosition().getBoardColumn().getPosition() == 2
                        && move.getEndPosition().getBoardRow().getPosition() <= 3));
    }
}