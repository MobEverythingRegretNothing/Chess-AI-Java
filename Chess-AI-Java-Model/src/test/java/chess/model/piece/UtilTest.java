package chess.model.piece;

import org.junit.Test;

import java.util.Arrays;

import static chess.model.piece.Util.transpose;
import static org.junit.Assert.assertTrue;

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

        System.out.println(Arrays.deepToString(matrix));
        System.out.println(Arrays.deepToString(transpose));

        assertTrue(!matrix[0][1].equals(matrix[1][0]) && matrix[0][1].equals(transpose[1][0]));

    }

}