package com.uammero.controller;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.uammero.common.ResponseData;
import com.uammero.common.ResponseMessage;
import com.uammero.entity.FileEntity;
import com.uammero.service.FileService;


@Controller
//@RequestMapping("/api/v1")
@CrossOrigin("http://localhost:8092")
public class FileController {

	@Autowired
	  private FileService fileService;
	
	  

	  @PostMapping("/api/v1/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	    	fileService.saveFile(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	  
	  @DeleteMapping("/api/v1/delete/{id}")
	  public ResponseEntity<ResponseMessage> deleteFile(@PathVariable("id") String id) {
	    String message = "";
	    try {
	    	fileService.deleteFile(id);
	 
	    	message = "Delete file successfully: " + id;
	    	return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

	      
	    } catch (EmptyResultDataAccessException e) {
	      message = "Could not delete the file: " + id + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }

	  @GetMapping("/api/v1/files")
	  public ResponseEntity<List<ResponseData>> getListFiles() {
	    List<ResponseData> files = fileService.getAllFiles().map(fileData -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/api/v1/files/")
	          .path(fileData.getId())
	          .toUriString();

	      return new ResponseData(
	    	  fileData.getName(),
	          fileDownloadUri,
	          fileData.getType(),
	          fileData.getData().length,
	          fileData.getId());
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }

	  @GetMapping("/api/v1/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		  FileEntity fileData = fileService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileData.getName() + "\"")
	        .body(fileData.getData());
	  }
	
}
