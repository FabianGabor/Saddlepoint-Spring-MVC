package hu.nye.fabiangabor.saddlepoint.upload.transform;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileTo2DArrayTransformer {

    MultipartFile file;

    public FileTo2DArrayTransformer(MultipartFile file) {
        this.file = file;
    }

    @ModelAttribute("matrix")
    public int[][] transform() throws IOException {
        byte[] content = file.getBytes();
        List<Integer> list = new ArrayList<>();

        for (byte b : content) {
            if (b != ' ' && b != '\n') {
                int value = Character.getNumericValue(b);
                list.add(value);
            }
        }

        int[][] tmp = new int[(int) Math.sqrt(list.size())][(int) Math.sqrt(list.size())];

        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp.length; j++) {
                tmp[i][j] = list.get(i*tmp.length+j);
            }
        }

        return tmp;
    }
}
