package chess.model.piece;

import chess.model.Color;
import chess.model.Position;
import org.junit.Test;

import static chess.model.BoardColumn.*;
import static chess.model.BoardRow.*;
import static chess.model.Color.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BishopTest {

    @Test
    public void emptyBoard_diagonalMove() {
        Bishop bishop = new Bishop(WHITE);
        assertTrue(bishop.isValidMove(
                new Position(A, ONE),
                new Position(B, TWO)));
    }

    @Test
    public void emptyBoard_diagonalBackwardsMove() {
        Bishop bishop = new Bishop(WHITE);
        assertTrue(bishop.isValidMove(
                new Position(C, THREE),
                new Position(B, TWO)));
    }

    @Test
    public void emptyBoard_nonDiagonalMove() {
        Bishop bishop = new Bishop(BLACK);
        assertFalse(bishop.isValidMove(
                new Position(A, ONE),
                new Position(A, TWO)));
    }
}
