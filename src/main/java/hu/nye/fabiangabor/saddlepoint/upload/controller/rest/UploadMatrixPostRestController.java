package hu.nye.fabiangabor.saddlepoint.upload.controller.rest;

import hu.nye.fabiangabor.saddlepoint.matrix.domain.Matrix;
import hu.nye.fabiangabor.saddlepoint.upload.model.AddMatrixRequest;
import hu.nye.fabiangabor.saddlepoint.upload.transform.FileTo2DArrayTransformer;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
public class UploadMatrixPostRestController {

    @ModelAttribute("matrix")
    public Matrix createMatrixModel(@ModelAttribute AddMatrixRequest addMatrixRequest) {
        return new Matrix();
    }

    @PostMapping("/rest/matrix")
    public Matrix addMatrixPost(@Valid Matrix matrix, @RequestParam("file") MultipartFile file) throws IOException {

        FileTo2DArrayTransformer fileTo2DArrayTransformer = new FileTo2DArrayTransformer();
        return fileTo2DArrayTransformer.convertFileToMatrix(file);

    }
}
