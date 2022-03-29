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
        Coord min = new Coord(0, 0, Integer.MAX_VALUE);
        Coord max = new Coord(0, 0, Integer.MIN_VALUE);

        for (int row = 0; row < size; row++) {
            min.setValue(data[row][0]);
            min.setRow(row);
            min.setCol(0);

            int col;
            for (col = 0; col < size; col++) {
                if (min.getValue() >= data[row][col]) {
                    min.setValue(data[row][col]);
                    min.setRow(row);
                    min.setCol(col);
                }
            }

            col = min.getCol();
            max.setValue(data[0][col]);
            max.setRow(0);
            max.setCol(col);

            for (int row2 = 0; row2 < size; row2++) {
                if (max.getValue() <= data[row2][col]) {
                    max.setValue(data[row2][col]);
                    max.setRow(row2);
                    max.setCol(col);
                }
            }
        }

        if (min.getValue() == max.getValue()) {
            this.saddlePoint = min;
            return saddlePoint;
        }
        return null;
    }
}
