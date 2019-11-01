package chess.model.piece;

import chess.model.GameState;
import chess.model.Move;
import chess.model.Position;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;
import static org.junit.Assert.*;

public class RookTest {

    @Test
    public void getValidMoves_EmptyBoard() {
        Rook whiteRook = new Rook(WHITE);
        GameState state = new GameState();
        state.getPieceMap().put(new Position(B, TWO), whiteRook);
        List<Move> validMoveList = whiteRook.getValidMoves(new Position(B, TWO), state);
        System.out.println(validMoveList.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Rook is missing valid moves", 14, validMoveList.size());
    }

    @Test
    public void getValidMoves_Capture() {
        Rook whiteRook = new Rook(WHITE);
        GameState state = new GameState();
        state.getPieceMap().put(new Position(B, TWO), whiteRook);
        state.getPieceMap().put(new Position(B, THREE), new Bishop(BLACK));
        List<Move> validMoveList = whiteRook.getValidMoves(new Position(B, TWO), state);
        System.out.println(validMoveList.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Rook is missing valid moves", 9, validMoveList.size());
        assertEquals("Invalid number of captures", 1, validMoveList.stream().filter(Move::isCapture).count());
    }

    @Test
    public void getValidMoves_Blocked() {
        Rook whiteRook = new Rook(WHITE);
        GameState state = new GameState();
        state.getPieceMap().put(new Position(B, TWO), whiteRook);
        state.getPieceMap().put(new Position(B, FOUR), new Bishop(WHITE));
        List<Move> validMoveList = whiteRook.getValidMoves(new Position(B, TWO), state);
        System.out.println(validMoveList.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Rook is missing valid moves", 9, validMoveList.size());
        assertEquals("Rook can capture it's own pieces", 0, validMoveList.stream().filter(Move::isCapture).count());
        assertFalse("Rook can go past it's own pieces", validMoveList.stream()
                .anyMatch(move -> move.getEndPosition().getBoardRow().getPosition() > FOUR.getPosition()));
    }

    @Test
    public void getValidMoves_BlockedByMulitple() {
        Rook whiteRook = new Rook(WHITE);
        GameState state = new GameState();
        state.getPieceMap().put(new Position(B, TWO), whiteRook);
        state.getPieceMap().put(new Position(B, FOUR), new Bishop(WHITE));
        state.getPieceMap().put(new Position(C, TWO), new King(WHITE));
        List<Move> validMoveList = whiteRook.getValidMoves(new Position(B, TWO), state);
        System.out.println(validMoveList.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Rook is missing valid moves", 3, validMoveList.size());
        assertEquals("Rook can capture it's own pieces", 0, validMoveList.stream().filter(Move::isCapture).count());
        assertFalse("Rook can go past it's own pieces (column)", validMoveList.stream()
                .anyMatch(move -> move.getEndPosition().getBoardRow().getPosition() > FOUR.getPosition()));
        assertFalse("Rook can go past it's own pieces (row)", validMoveList.stream()
                .anyMatch(move -> move.getEndPosition().getBoardColumn().getPosition() > B.getPosition()));
    }

    @Test
    public void getValidMoves_MultipleCaptures() {
        Rook whiteRook = new Rook(WHITE);
        GameState state = new GameState();
        state.getPieceMap().put(new Position(C, TWO), whiteRook);
        state.getPieceMap().put(new Position(B, TWO), new Bishop(BLACK));
        state.getPieceMap().put(new Position(C, ONE), new Queen(BLACK));
        List<Move> validMoveList = whiteRook.getValidMoves(new Position(C, TWO), state);
        System.out.println(validMoveList.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Rook is missing valid moves", 13, validMoveList.size());
        assertEquals("Rook can't capture other players pieces (multiple)", 2, validMoveList.stream().filter(Move::isCapture).count());
    }
}