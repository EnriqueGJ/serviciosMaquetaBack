package com.uammero.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.uammero.dao.FileServiceDao;
import com.uammero.entity.FileEntity;


@Service
public class FileService {

	@Autowired
	private FileServiceDao fileServiceDao;
	
	public FileEntity saveFile(MultipartFile file) throws IOException {
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileEntity fileData = new FileEntity(fileName, file.getContentType(), file.getBytes());

	    return fileServiceDao.save(fileData);
	  }

	  public FileEntity getFile(String id) {
	    return fileServiceDao.findById(id).get();
	  }
	  
	  public boolean deleteFile(String id) {
		  try {
			  fileServiceDao.deleteById(id);
			  return true;
		  }
		  catch(Exception err){}
		   return false;
	  }
	  
	  public Stream<FileEntity> getAllFiles() {
	    return fileServiceDao.findAll().stream();
	  }
	
	
}
