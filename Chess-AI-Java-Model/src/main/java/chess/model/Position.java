package chess.model;

import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.BoardRow;

public class Position {

    private BoardColumn boardColumn;
    private BoardRow boardRow;

    public Position(BoardColumn boardColumn, BoardRow boardRow) {
        this.boardColumn = boardColumn;
        this.boardRow = boardRow;
    }

    public Position(int boardColumn, int boardRow) {
        this.boardColumn = BoardColumn.getBoardColumn(boardColumn);
        this.boardRow = BoardRow.getBoardRow(boardRow);
    }

    public BoardColumn getBoardColumn() {
        return boardColumn;
    }

    public BoardRow getBoardRow() {
        return boardRow;
    }

    public String prettyPrint() {
        return String.format("%s%d", boardColumn.getLetter(), boardRow.getPosition() + 1);
    }

    @Override
    public String toString() {
        return boardColumn.getLetter() + (boardRow.getPosition() + 1);
    }
}
