package com.uammero.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uammero.entity.FileEntity;


public interface FileServiceDao extends JpaRepository<FileEntity, String>{

	
// save files in DB ->  save();
// get file data by id from DB -> findById();
// getAll files details from DB	-> getAll();
	
}