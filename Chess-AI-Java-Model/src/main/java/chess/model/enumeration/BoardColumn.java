package chess.model.enumeration;

import java.util.Arrays;
import java.util.Optional;

public enum BoardColumn {
    A(0),
    B(1),
    C(2),
    D(3),
    E(4),
    F(5),
    G(6),
    H(7);

    private final int position;

    BoardColumn(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getLetter() {
        return this.name();
    }

    public static BoardColumn getBoardColumn(int position) {
        Optional<BoardColumn> columnNumber = Arrays.stream(values())
                .filter(column -> column.position == position)
                .findFirst();
        return columnNumber.orElseThrow(RuntimeException::new);
    }

 }
