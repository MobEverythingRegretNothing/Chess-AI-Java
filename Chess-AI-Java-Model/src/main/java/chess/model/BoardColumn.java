package chess.model;

public enum Alpha {
    A(1),
    B(2),
    C(3),
    D(4),
    E(5),
    F(6),
    G(7),
    H(8);

    private final int position;

    Alpha(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public String getLetter() {
        return this.name();
    }
 }
