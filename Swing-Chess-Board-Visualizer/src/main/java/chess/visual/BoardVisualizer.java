package chess.visual;

import chess.model.GameState;
import chess.model.enumeration.Color;

import javax.swing.*;

public class BoardVisualizer  {

    public static void drawBoard(GameState gamestate, Color playerColor) {
        JFrame frame = new JFrame();
        frame.setSize(600, 600);
        frame.getContentPane().add(new GameBoard(new GameState(), playerColor, 600, 600));
        frame.setLocationRelativeTo(null);
        frame.setBackground(java.awt.Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}
