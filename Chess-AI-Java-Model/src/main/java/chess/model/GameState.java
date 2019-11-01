package chess.model;

import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.Color;
import chess.model.piece.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;

public class GameState {
    private List<Move> moveList;
    private Map<Position, Piece> pieceMap;
    private MoveTuple currentMove;


    public GameState() {
        this.moveList = new ArrayList<>();
        this.pieceMap = new HashMap<>();
        currentMove = new MoveTuple(1, WHITE);
    }

    public GameState init() {
        setupStandardGameState();
        return this;
    }

    private void setupStandardGameState() {
       this.pieceMap = new HashMap<>();

        // White pieces
        for (int i = 0; i < 8; i++) {
            pieceMap.put(new Position(BoardColumn.values()[i], TWO), new Pawn(WHITE));
        }

        pieceMap.put(new Position(A, ONE), new Rook(WHITE));
        pieceMap.put(new Position(H, ONE), new Rook(WHITE));

        pieceMap.put(new Position(B, ONE), new Knight(WHITE));
        pieceMap.put(new Position(G, ONE), new Knight(WHITE));

        pieceMap.put(new Position(C, ONE), new Bishop(WHITE));
        pieceMap.put(new Position(F, ONE), new Bishop(WHITE));

        pieceMap.put(new Position(D, ONE), new Queen(WHITE));
        pieceMap.put(new Position(E, ONE), new King(WHITE));


        //Black pieces
        for (int i = 0; i < 8; i++) {
            pieceMap.put(new Position(BoardColumn.values()[i], SEVEN), new Pawn(BLACK));
        }

        pieceMap.put(new Position(A, EIGHT), new Rook(BLACK));
        pieceMap.put(new Position(H, EIGHT), new Rook(BLACK));

        pieceMap.put(new Position(B, EIGHT), new Knight(BLACK));
        pieceMap.put(new Position(G, EIGHT), new Knight(BLACK));

        pieceMap.put(new Position(C, EIGHT), new Bishop(BLACK));
        pieceMap.put(new Position(F, EIGHT), new Bishop(BLACK));

        pieceMap.put(new Position(D, EIGHT), new Queen(BLACK));
        pieceMap.put(new Position(E, EIGHT), new King(BLACK));
    }


    public Map<Position, Piece> getPieceMap() {
        return pieceMap;
    }

    public String[][] getBoardArray() {


        String[][] board = new String[8][8];
        this.getPieceMap().forEach((key, value) -> board[key.getBoardColumn().getPosition()]
                [key.getBoardRow().getPosition()] = value.toString());

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {
                if (null == board[x][y]) {
                    board[x][y] = "  ";
                }
            }
        }

        return board;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public MoveTuple getCurrentMove() {
        return currentMove;
    }

    public static class MoveTuple {
        public Integer moveNumber;
        public Color color;

        public MoveTuple(Integer moveNumber, Color color) {
            this.moveNumber = moveNumber;
            this.color = color;
        }
    }
}
