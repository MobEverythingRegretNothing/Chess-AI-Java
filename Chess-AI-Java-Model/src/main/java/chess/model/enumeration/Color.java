package chess.model.enumeration;

public enum Color {
    WHITE, BLACK;

    public static Color toggle(Color color) {
        return color == WHITE ? BLACK : WHITE;
    }
}
