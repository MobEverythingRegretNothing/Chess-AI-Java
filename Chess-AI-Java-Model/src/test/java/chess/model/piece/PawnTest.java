package chess.model.piece;

import chess.model.Position;
import org.junit.Test;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PawnTest {

    @Test
    public void emptyBoard_whitePawn_MovesOneUpBoard() {
        Pawn whitePawn = new Pawn(WHITE);
        assertTrue("White pawn can't move one up-board (empty board)",
                whitePawn.isValidMove(
                        new Position(A, TWO),
                        new Position(A, THREE)
                ));
    }

    @Test
    public void emptyBoard_whitePawn_MovesTwoUpBoard_SecondRow() {
        Pawn whitePawn = new Pawn(WHITE);
        assertTrue("White pawn can't move two up-board (second row, empty board)",
                whitePawn.isValidMove(
                        new Position(A, TWO),
                        new Position(A, FOUR)
                ));
    }

    @Test
    public void emptyBoard_whitePawn_CantMoveMoreThanTwoUpBoard_SecondRow() {
        Pawn whitePawn = new Pawn(WHITE);
        assertFalse("White pawn can move >2 up-board (second row, empty board)",
                whitePawn.isValidMove(
                        new Position(A, TWO),
                        new Position(A, FIVE)
                ));
    }

    @Test
    public void emptyBoard_whitePawn_CantMoveOneDownBoard() {
        Pawn whitePawn = new Pawn(WHITE);
        assertFalse("White pawn can move one down-board (empty board)",
                whitePawn.isValidMove(
                        new Position(A, THREE),
                        new Position(A, TWO)
                ));
    }

    @Test
    public void emptyBoard_whitePawn_CantMoveMultipleUpBoard() {
        Pawn whitePawn = new Pawn(WHITE);
        assertFalse("White pawn can move multiple up-board (not second row, empty board)",
                whitePawn.isValidMove(
                        new Position(C, THREE),
                        new Position(C, SEVEN)
                ));
    }

    @Test
    public void emptyBoard_whitePawn_CantMoveDiagonally() {
        Pawn whitePawn = new Pawn(WHITE);
        assertFalse("White pawn can move diagonally up-board (empty board)",
                whitePawn.isValidMove(
                        new Position(C, THREE),
                        new Position(D, FOUR)
                ));

        assertFalse("White pawn can move diagonally down-board (empty board)",
                whitePawn.isValidMove(
                        new Position(C, THREE),
                        new Position(B, TWO)
                ));
    }

    @Test
    public void emptyBoard_blackPawn_MovesOneDownBoard() {
        Pawn blackPawn = new Pawn(BLACK);
        assertTrue("Black pawn can't move one down-board (empty board)",
                blackPawn.isValidMove(
                        new Position(A, SEVEN),
                        new Position(A, SIX)
                ));
    }

    @Test
    public void emptyBoard_blackPawn_MovesTwoDownBoard_fromSeventhRow() {
        Pawn blackPawn = new Pawn(BLACK);
        assertTrue("Black pawn can't move two down-board from seventh row (empty board)",
                blackPawn.isValidMove(
                        new Position(B, SEVEN),
                        new Position(A, FIVE)
                ));
    }

    @Test
    public void emptyBoard_blackPawn_CantMoveOneUpBoard() {
        Pawn blackPawn = new Pawn(BLACK);
        assertFalse("Black pawn can move one up-board (empty board)",
                blackPawn.isValidMove(
                        new Position(B, THREE),
                        new Position(B, FOUR)
                ));
    }

    @Test
    public void emptyBoard_blackPawn_CantMoveMultipleDownBoard_nonSeventhRow() {
        Pawn blackPawn = new Pawn(BLACK);
        assertFalse("Black pawn can move multiple down-board (non-seventh row, empty board)",
                blackPawn.isValidMove(
                        new Position(B, SIX),
                        new Position(B, FOUR)
                ));
    }

    @Test
    public void emptyBoard_blackPawn_CantMoveDiagonal() {
        Pawn blackPawn = new Pawn(BLACK);
        assertFalse("Black pawn can move diagonal down-board (empty board)",
                blackPawn.isValidMove(
                        new Position(B, SIX),
                        new Position(C, FIVE)
                ));

        assertFalse("Black pawn can move diagonal up-board (empty board)",
                blackPawn.isValidMove(
                        new Position(A, SIX),
                        new Position(B, SEVEN)
                ));
    }
}