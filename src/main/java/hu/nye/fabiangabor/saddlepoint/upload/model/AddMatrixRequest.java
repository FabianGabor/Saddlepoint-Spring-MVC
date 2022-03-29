package hu.nye.fabiangabor.saddlepoint.upload.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

public class AddMatrixRequest {
	@NotNull
	private MultipartFile data;

	public MultipartFile getData() {
		return data;
	}

	public void setData(MultipartFile data) {
		this.data = data;
	}
}
