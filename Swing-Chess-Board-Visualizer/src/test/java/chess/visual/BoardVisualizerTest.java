package chess.visual;

import chess.model.GameState;
import chess.model.enumeration.Color;
import org.junit.Test;

public class BoardVisualizerTest {

    @Test
    public void visualizeChessBoard() {
        BoardVisualizer.drawBoard(new GameState(), Color.WHITE);
        while (true) {

        }
    }

}