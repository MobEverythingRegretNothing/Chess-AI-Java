package chess.model.piece;


import chess.model.Position;
import org.junit.Test;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class KnightTest {

    @Test
    public void emptyBoard_knightMovesInL() {
        Knight knight = new Knight(BLACK);
        assertTrue(knight.isValidMove(
                new Position(A, ONE),
                new Position(B, THREE)));
    }

    @Test
    public void emptyBoard_knightCantMoveDiagonally() {
        Knight knight = new Knight(WHITE);
        assertFalse(knight.isValidMove(
                new Position(A, ONE),
                new Position(B, TWO)));
    }

    @Test
    public void emptyBoard_knightCantMoveStraight() {
        Knight knight = new Knight(WHITE);
        assertFalse(knight.isValidMove(
                new Position(A, ONE),
                new Position(A, FOUR)));
    }
}