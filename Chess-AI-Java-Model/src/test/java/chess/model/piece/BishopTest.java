package chess.model.piece;

import chess.model.Position;
import org.junit.Test;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BishopTest {

    @Test
    public void emptyBoard_diagonalMove() {
        Bishop whiteBishop = new Bishop(WHITE);
        assertTrue("White Bishop can't move diagonally (empty board)",
                whiteBishop.isValidMove(
                        new Position(A, ONE),
                        new Position(B, TWO)));

        Bishop blackBishop = new Bishop(BLACK);
        assertTrue("Black Bishop can't move diagonally (empty board)",
                blackBishop.isValidMove(
                        new Position(A, ONE),
                        new Position(B, TWO)));
    }

    @Test
    public void emptyBoard_diagonalBackwardsMove() {
        Bishop whiteBishop = new Bishop(WHITE);
        assertTrue("White Bishop can't move diagonally (empty board)",
                whiteBishop.isValidMove(
                        new Position(C, THREE),
                        new Position(B, TWO)));

        Bishop blackBishop = new Bishop(BLACK);
        assertTrue("Black Bishop can't move diagonally (empty board)",
                blackBishop.isValidMove(
                        new Position(C, THREE),
                        new Position(B, TWO)));
    }

    @Test
    public void emptyBoard_bishopCantMoveStraight() {
        Bishop whiteBishop = new Bishop(WHITE);
        assertFalse("White Bishop can move in straight line up-board (empty board)",
                whiteBishop.isValidMove(
                        new Position(A, ONE),
                        new Position(A, TWO)));

        Bishop blackBishop = new Bishop(BLACK);
        assertFalse("Black Bishop can move in straight line down-board (empty board)",
                blackBishop.isValidMove(
                        new Position(C, THREE),
                        new Position(C, TWO)));
    }
}
