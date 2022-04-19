package hu.nye.fabiangabor.saddlepoint.upload.transform;

import hu.nye.fabiangabor.saddlepoint.matrix.domain.Matrix;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileTo2DArrayTransformer {

    MultipartFile file;

    public FileTo2DArrayTransformer() {
    }

    public FileTo2DArrayTransformer(MultipartFile file) {
        this.file = file;
    }

    @ModelAttribute("matrix")
    public int[][] transform() throws IOException {

        String fileContent = inputStreamToString(file);
        String[] numbers = fileContent.split("\n");
        int[][] tmp = new int[numbers.length][numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                tmp[i][j] = Integer.parseInt(numbers[i].split(" ")[j]);
            }
        }

        return tmp;
    }

    public Matrix convertFileToMatrix(MultipartFile file) throws IOException {
        this.file = file;
        int[][] tmp = transform();

        Matrix matrix = new Matrix(tmp);
        matrix.setSize(tmp.length);
        matrix.setData(tmp);

        return matrix;
    }


    private String inputStreamToString(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        return new String(bytes);
    }
}
