package chess.model;

import chess.model.enumeration.BoardColumn;
import chess.model.piece.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static chess.model.Constants.*;
import static chess.model.enumeration.BoardColumn.*;
import static chess.model.enumeration.BoardRow.*;
import static chess.model.enumeration.Color.BLACK;
import static chess.model.enumeration.Color.WHITE;

public class GameState {
    private List<Move> moveList;
    private List<Piece> pieceList;
    private List<Piece> captured;

    public GameState() {
        this.moveList = new ArrayList<>();
        this.pieceList = new ArrayList<>();
    }

    public GameState init() {
        setupStandardGameState();
        return this;
    }

    private void setupStandardGameState() {
       this.pieceList = new ArrayList<>();
       this.captured = new ArrayList<>();

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
    }

    public void addMove(Move nextMove) {
        // TODO: Add move to move list
        this.moveList.add(nextMove);
        // TODO: Change piece placement

        //TODO: Change currentMove

    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public Piece[][] getBoardArray() {
        Piece[][] board = new Piece[xMax][yMax];
        this.getPieceList().forEach(piece -> board[piece.getPosition().getBoardColumn().getPosition()]
                [piece.getPosition().getBoardRow().getPosition()] = piece);

        return board;
    }

    public List<Move> getValidMoves() {
        // TODO: Need to handle being in check
        return this.pieceList.stream().map(piece -> piece.getValidMoves(this)).flatMap(List::stream).collect(Collectors.toList());
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public Piece getPieceAtLocation(Position position) {
        return this.getBoardArray()[position.getBoardColumn().getPosition()][position.getBoardRow().getPosition()];
    }

    public List<Piece> getCaptured() {
        return captured;
    }

    public void setCaptured(List<Piece> captured) {
        this.captured = captured;
    }

    public int getMoveNumber() {
        return getMoveList().get(getMoveList().size() - 1).getMoveNumber();
    }
}
