package com.blog.api.servicesImpl;

import com.blog.api.services.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

        //File Name
        String fileName = file.getOriginalFilename();

        String randomId= UUID.randomUUID().toString();
        assert fileName != null;
        String randomFileName=path+randomId.concat(fileName.substring(fileName.lastIndexOf(".")));

        //FullPath
        String filePath=path+ File.separator+randomFileName;

        //create folder
        File f=new File(path);
        if(!f.exists()){
            f.mkdir();
        }

        //file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;
        return new FileInputStream(fullPath);
    }
}
