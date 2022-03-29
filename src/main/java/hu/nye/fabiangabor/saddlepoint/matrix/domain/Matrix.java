package hu.nye.fabiangabor.saddlepoint.matrix.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Matrix {
    private int size;
    private int[][] data;
    private Coord saddlePoint;

    public Matrix(int[][] data) {
        this.size = data.length;
        this.data = data;
        saddlePoint = findSaddlePoints();
    }

    public Coord findSaddlePoints() {
        for (int i = 0; i < data.length; i++) {
            boolean isSaddlePointPresentInRow = true;

            int minimum = data[i][0];
            int colIndexOfRowMinimum = 0;

            //Find minimum in row.
            for(int j=1; j< data[0].length; j++){
                if(data[i][j] < minimum){
                    minimum = data[i][j];
                    colIndexOfRowMinimum = j;
                }
            }

            //Find maximum in same column.
            for (int j = 0; j < data.length && isSaddlePointPresentInRow; j++) {
                if (minimum < data[j][colIndexOfRowMinimum]){
                    isSaddlePointPresentInRow = false;
                }
            }

            if(isSaddlePointPresentInRow){
                return new Coord(i, colIndexOfRowMinimum, data[i][colIndexOfRowMinimum]);
            }
        }
        return null;
    }
}
