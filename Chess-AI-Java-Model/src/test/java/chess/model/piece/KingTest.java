package chess.model.piece;

import chess.model.Position;
import org.junit.Test;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.*;
import static org.junit.Assert.*;

public class KingTest {

    @Test
    public void emptyBoard_kingMovesOneDiagonally() {
        King whiteKing = new King(WHITE);
        assertTrue("White King can't move diagonally (empty board)",
                whiteKing.isValidMove(
                        new Position(D, ONE),
                        new Position(C, TWO)));

        King blackKing = new King(BLACK);
        assertTrue("Black King can't move diagonally (emptyBoard)",
                blackKing.isValidMove(
                        new Position(E, ONE),
                        new Position(D, TWO)));
    }

    @Test
    public void emptyBoard_kingMovesOneRowWise() {
        King whiteKing = new King(WHITE);
        assertTrue("White King can't move one row-wise (empty board)",
                whiteKing.isValidMove(
                        new Position(D, ONE),
                        new Position(C, ONE)));

        King blackKing = new King(BLACK);
        assertTrue("Black King can't move one row-wise (empty board)",
                blackKing.isValidMove(
                        new Position(D, ONE),
                        new Position(C, ONE)));
    }

    @Test
    public void emptyBoard_kingMovesOneColumnWise() {
        King whiteKing = new King(WHITE);
        assertTrue("White King can't move one column-wise (empty board)",
                whiteKing.isValidMove(
                        new Position(D, ONE),
                        new Position(D, TWO)));

        King blackKing = new King(WHITE);
        assertTrue("Black King can't move one column-wise (empty board)",
                blackKing.isValidMove(
                        new Position(H, FOUR),
                        new Position(H, FIVE)));
    }

    @Test
    public void kingCantMoveMoreThanOne() {
        King whiteKing = new King(WHITE);
        assertFalse("White King can move more than one space (empty board)",
                whiteKing.isValidMove(
                        new Position(D, ONE),
                        new Position(D, THREE)));

        assertFalse("White King can move more than one space diagonally (empty board)",
                whiteKing.isValidMove(
                        new Position(D, ONE),
                        new Position(F, THREE)));

        King blackKing = new King(WHITE);
        assertFalse("Black King can move more than one space (empty board)",
                blackKing.isValidMove(
                        new Position(D, ONE),
                        new Position(D, THREE)));
    }

}