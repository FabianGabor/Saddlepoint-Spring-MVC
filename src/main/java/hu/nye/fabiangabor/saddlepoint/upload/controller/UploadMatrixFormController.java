package hu.nye.fabiangabor.saddlepoint.upload.controller;

import hu.nye.fabiangabor.saddlepoint.matrix.domain.Matrix;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UploadMatrixFormController {

    @ModelAttribute("matrix")
    public Matrix createMatrixModel(@ModelAttribute Matrix matrix) {
        return new Matrix();
    }

    @GetMapping("/")
    public String addMatrixForm() {
        return "upload.html";
    }
}
