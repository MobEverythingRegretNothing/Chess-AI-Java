package chess;

import chess.model.GameState;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Util {

    private static final Set<String> RESIGNATION_OPTIONS = new HashSet<>(Arrays.asList("R", "Resign", "Resignation", "Give up", "Surrender"));

    public static boolean isResignation(String move) {
        return RESIGNATION_OPTIONS.contains(move);
    }

}
