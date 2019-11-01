package chess.model.piece;

import chess.model.Position;
import org.junit.Test;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QueenTest {

    @Test
    public void emptyBoard_queenMovesInRow() {
        Queen whiteQueen = new Queen(WHITE);
        assertTrue(
                "White Queen can't move forward in row (empty board)",
                whiteQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(G, ONE)
                ));

        Queen blackQueen = new Queen(BLACK);
        assertTrue(
                "Black Queen can't move forward in row (empty board)",
                blackQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(G, ONE)
                ));
    }

    @Test
    public void emptyBoard_queenMovesBackwardsInRow() {
        Queen whiteQueen = new Queen(WHITE);
        assertTrue(
                "White Queen can't move backwards in row (empty board)",
                whiteQueen.isValidMove(
                        new Position(F, EIGHT),
                        new Position(E, EIGHT)
                ));

        Queen blackQueen = new Queen(BLACK);
        assertTrue(
                "Black Queen can't move backwards in row (empty board)",
                blackQueen.isValidMove(
                        new Position(F, EIGHT),
                        new Position(E, EIGHT)
                ));
    }

    @Test
    public void emptyBoard_queenMovesInColumn() {
        Queen whiteQueen = new Queen(WHITE);
        assertTrue(
                "White Queen can't move forward in column (empty board)",
                whiteQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(E, SIX)
                ));

        Queen blackQueen = new Queen(BLACK);
        assertTrue(
                "Black Queen can't move forward in column (empty board)",
                blackQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(E, SIX)
                ));
    }

    @Test
    public void emptyBoard_queenMovesBackwardsInColumn() {
        Queen whiteQueen = new Queen(WHITE);
        assertTrue(
                "White Queen can't move backwards in column (empty board)",
                whiteQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(E, SIX)
                ));

        Queen blackQueen = new Queen(BLACK);
        assertTrue(
                "Black Queen can't move backwards in column (empty board)",
                blackQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(E, SIX)
                ));
    }


    @Test
    public void emptyBoard_queenCantMoveInL() {
        Queen whiteQueen = new Queen(WHITE);
        assertFalse(
                "White Queen can move in L shape (empty board)",
                whiteQueen.isValidMove(
                        new Position(A, ONE),
                        new Position(B, THREE)
                ));

        Queen blackQueen = new Queen(BLACK);
        assertFalse(
                "Black Queen can move in L shape (empty board)",
                blackQueen.isValidMove(
                        new Position(E, ONE),
                        new Position(D, THREE)
                ));
    }

}