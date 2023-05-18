package com.blog.services.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.blog.services.FileService;
@Service
public class FileServiceImpl implements FileService{

	@Override
	public String uploadImage(String path, MultipartFile multipartFile) throws IOException {
		//file name
		String fileName1=multipartFile.getOriginalFilename();
		//generate random file name
		String randomId = UUID.randomUUID().toString();
		String fileName2=randomId.concat(fileName1.substring(fileName1.lastIndexOf(".")));
		//fullpath
		String filePath=path+File.separator+fileName2;
		//create folder if not created
		File f=new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		//file copy
		
		Files.copy(multipartFile.getInputStream(), Paths.get(filePath));
		
		return fileName2;
	}

	@Override
	public InputStream getResInputStream(String path, String fileName) throws FileNotFoundException 
	{
		String fullPath=path+File.separator+fileName;
		InputStream is=new FileInputStream(fullPath);
		return is;
	}

}
