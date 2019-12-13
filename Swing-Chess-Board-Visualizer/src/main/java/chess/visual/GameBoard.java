package chess.visual;

import chess.model.GameState;
import chess.model.enumeration.BoardColumn;
import chess.model.enumeration.BoardRow;
import chess.model.enumeration.Color;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import static chess.model.enumeration.Color.WHITE;

public class GameBoard extends JPanel {

    private final GameState gameState;
    private final Color playerColor;
    private final int boardWidth;
    private final int boardHeight;

    public GameBoard(final GameState gameState, final Color playerColor, final int x, final int y) {
        super();
        this.gameState = gameState;
        this.playerColor = playerColor;
        boardWidth = x;
        boardHeight = y;
    }

    public void paint(Graphics g) {
        super.paint(g);

        final int squareWidth = boardWidth/8;
        final int squareHeight = boardWidth/8;
        g.fillRect(0, 563, 75, 75);

//        Piece[][] boardArray = playerColor == WHITE ? gameState.getBoardArray() : transpose(gameState.getBoardArray());


        for (int column = BoardColumn.A.getPosition(); column <=  BoardColumn.H.getPosition(); column++) {
            for (int row = BoardRow.ONE.getPosition(); row <= BoardRow.EIGHT.getPosition(); row++) {

                g.setColor(playerColor == WHITE ? java.awt.Color.WHITE : java.awt.Color.BLACK);

                int x = column * squareWidth;
                int y = boardHeight - (row) * squareHeight - squareHeight / 2;

                System.out.println(String.format("Filling Rectangle! %d, %d, %d, %d", x, y , squareWidth, squareHeight));

//                g.fillRect(x, y, squareWidth, squareHeight);

//                // TODO: Draw Piece if there
//                if (boardArray[row][column] != null) {
                    g.drawImage(getPieceImage(boardArray[row][column].toString()), )
//                }
            }
        }

    }

    private static void getPieceImage(String pieceString, Graphics g) {
        g.drawImage(ImageIO.read());
    }

}
