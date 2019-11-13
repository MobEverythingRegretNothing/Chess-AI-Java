package chess.model.piece;

import org.junit.Test;

import java.util.Arrays;

import static chess.model.piece.Util.flip;
import static chess.model.piece.Util.transpose;
import static org.junit.Assert.*;

public class UtilTest {

    @Test
    public void transpose_switchesRowsAndColumns() {
        String[][] matrix = new String[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = String.valueOf((int) (Math.random() * 100));
            }
        }
        String[][] transpose = transpose(matrix);

        assertTrue(Arrays.deepEquals(transpose(transpose), matrix));
        assertFalse(Arrays.deepEquals(transpose, matrix));

        for (int k = 0; k < matrix.length; k++) {
            for (int l = 0; l < matrix[0].length; l++) {
                assertEquals(transpose[k][l], matrix[l][k]);
            }
        }
    }
//
//    @Test
//    public void flip_flipsBoard() {
//        String[][] matrix = new String[8][8];
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = String.valueOf((int) (Math.random() * 100));
//            }
//        }
//        String[][] flipped = flip(matrix);
//        for (int k = 0; k < matrix.length; k++) {
//            for (int l = 0; l < matrix[0].length; l++) {
//                assertEquals(flipped[k][l], matrix[k][matrix.length - 1 - l]);
//            }
//        }
//    }


}