package hu.nye.fabiangabor.saddlepoint.matrix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coord {
    private int row;
    private int col;
    private int value;
}
