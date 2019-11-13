package chess.model;

import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.Color;
import chess.model.piece.*;

import java.util.ArrayList;
import java.util.List;

import static chess.model.Constants.*;
import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;

public class GameState {
    private List<Move> moveList;
    private List<Piece> pieceList;
    private MoveTuple currentMove;


    public GameState() {
        this.moveList = new ArrayList<>();
        this.pieceList = new ArrayList<>();
        currentMove = new MoveTuple(1, WHITE);
    }

    public GameState init() {
        setupStandardGameState();
        return this;
    }

    private void setupStandardGameState() {
       this.pieceList = new ArrayList<>();

        // White pieces
        for (int i = xMin; i < xMax; i++) {
            pieceList.add(new Pawn(WHITE, BoardColumn.values()[i], TWO));
        }

        pieceList.add(new Rook(WHITE, A, ONE));
        pieceList.add(new Rook(WHITE, H, ONE));

        pieceList.add(new Knight(WHITE, B, ONE));
        pieceList.add(new Knight(WHITE, G, ONE));

        pieceList.add(new Bishop(WHITE, C, ONE));
        pieceList.add(new Bishop(WHITE, F, ONE));

        pieceList.add(new Queen(WHITE, D, ONE));
        pieceList.add(new King(WHITE, E, ONE));


        //Black pieces
        for (int i = xMin; i < xMax; i++) {
            pieceList.add(new Pawn(BLACK, BoardColumn.values()[i], SEVEN));
        }

        pieceList.add(new Rook(BLACK, A, EIGHT));
        pieceList.add(new Rook(BLACK, H, EIGHT));

        pieceList.add(new Knight(BLACK, B, EIGHT));
        pieceList.add(new Knight(BLACK, G, EIGHT));

        pieceList.add(new Bishop(BLACK, C, EIGHT));
        pieceList.add(new Bishop(BLACK, F, EIGHT));

        pieceList.add(new Queen(BLACK, D, EIGHT));
        pieceList.add(new King(BLACK, E, EIGHT));
        
        this.currentMove = new MoveTuple(1, WHITE);
    }


    public List<Piece> getPieceList() {
        return pieceList;
    }

    public String[][] getBoardArray() {


        String[][] board = new String[xMax][yMax];
        this.getPieceList().forEach(piece -> board[piece.getPosition().getBoardColumn().getPosition()]
                [piece.getPosition().getBoardRow().getPosition()] = piece.toString());

        for(int x = xMin; x < xMax; x++) {
            for(int y = yMin; y < yMax; y++) {
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
