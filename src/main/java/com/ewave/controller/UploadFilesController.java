package com.ewave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ewave.message.ResponseMessage;
import com.ewave.service.UploadFilesService;

@Controller
@CrossOrigin("http://localhost:4200")
public class UploadFilesController {
	
	@Autowired
	UploadFilesService uploadFilesService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

		try {
			uploadFilesService.processFileXML(file.getInputStream());
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Upload realizado com sucesso."));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Não foi possível fazer o upload do arquivo"));
		}

	}

}
