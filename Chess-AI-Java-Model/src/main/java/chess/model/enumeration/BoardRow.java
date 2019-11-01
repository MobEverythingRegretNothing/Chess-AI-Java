package chess.model.enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum BoardRow {
    ONE(0),
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7);

    private final int position;

    BoardRow(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return this.name();
    }

    public static BoardRow getBoardRow(int position) {
        Optional<BoardRow> columnNumber = Arrays.stream(values())
                .filter(row -> row.position == position)
                .findFirst();
        return columnNumber.orElseThrow(RuntimeException::new);

    }

}

