package chess.model.piece;

import chess.model.Move;
import chess.model.Position;
import chess.model.GameState;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;
import static org.junit.Assert.assertEquals;

public class BishopTest {

    @Test
    public void bishop_emptyBoard() {
        GameState gameState = new GameState();
        Bishop whiteBishop = new Bishop(WHITE);
        gameState.getPieceMap().put(new Position(C, TWO), whiteBishop);
        List<Move> validMoves = whiteBishop.getValidMoves(new Position(C, TWO), gameState);
        System.out.println(validMoves.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Missing valid moves", 9, validMoves.size());
    }

    @Test
    public void bishop_blockedByWhite() {
        GameState gameState = new GameState();
        Bishop whiteBishop = new Bishop(WHITE);
        gameState.getPieceMap().put(new Position(C, TWO), whiteBishop);
        gameState.getPieceMap().put(new Position(D, THREE), new Rook(WHITE));
        List<Move> validMoves = whiteBishop.getValidMoves(new Position(C, TWO), gameState);
        System.out.println(validMoves.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Missing valid moves", 4, validMoves.size());
    }

    @Test
    public void bishop_blockedByMultiple() {
        GameState gameState = new GameState();
        Bishop whiteBishop = new Bishop(WHITE);
        gameState.getPieceMap().put(new Position(C, TWO), whiteBishop);
        gameState.getPieceMap().put(new Position(D, THREE), new Rook(WHITE));
        gameState.getPieceMap().put(new Position(A, FOUR), new Queen(WHITE));
        List<Move> validMoves = whiteBishop.getValidMoves(new Position(C, TWO), gameState);
        System.out.println(validMoves.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Missing valid moves", 3, validMoves.size());
    }


    @Test
    public void bishop_capture() {
        GameState gameState = new GameState();
        Bishop whiteBishop = new Bishop(WHITE);
        gameState.getPieceMap().put(new Position(C, TWO), whiteBishop);
        gameState.getPieceMap().put(new Position(E, FOUR), new Rook(BLACK));
        List<Move> validMoves = whiteBishop.getValidMoves(new Position(C, TWO), gameState);
        System.out.println(validMoves.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Wrong number of moves, should be 6", 6, validMoves.size());
        assertEquals("Rook can't capture other players pieces", 1, validMoves.stream().filter(Move::isCapture).count());
    }

    @Test
    public void bishop_captureMultiple() {
        GameState gameState = new GameState();
        Bishop whiteBishop = new Bishop(WHITE);
        gameState.getPieceMap().put(new Position(C, TWO), whiteBishop);
        gameState.getPieceMap().put(new Position(E, FOUR), new Rook(BLACK));
        gameState.getPieceMap().put(new Position(D, ONE), new Queen(BLACK));
        List<Move> validMoves = whiteBishop.getValidMoves(new Position(C, TWO), gameState);
        System.out.println(validMoves.stream().map(Move::toString).collect(Collectors.joining(", ")));
        assertEquals("Wrong number of moves, should be 6", 6, validMoves.size());
        assertEquals("Wrong number of captures should be 2", 2, validMoves.stream().filter(Move::isCapture).count());
    }


}
