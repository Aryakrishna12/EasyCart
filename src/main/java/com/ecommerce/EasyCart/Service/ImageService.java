package com.ecommerce.EasyCart.Service;

import org.apache.commons.io.IOUtils;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.EasyCart.Repository.ImageRepository;

import org.springframework.http.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.http.HttpServletResponse;


@Service
public class ImageService {

    public final String storageDirectoryPath = "src/main/resources/ProductImages";
    public String fileDownloadUri;
 
    
    public ResponseEntity uploadToLocalFileSystem(MultipartFile file) {
        /* we will extract the file name (with extension) from the given file to store it in our local machine for now
        and later in virtual machine when we'll deploy the project
         */
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        //System.out.println(file.getOriginalFilename());

        /* The Path in which we will store our image . we could change it later
        based on the OS of the virtual machine in which we will deploy the project.
        In my case i'm using windows 10 .
         */
        Path storageDirectory = Paths.get(storageDirectoryPath);
        //System.out.println(storageDirectory);
        /*
        * we'll do just a simple verification to check if the folder in which we will store our images exists or not
        * */
        if(!Files.exists(storageDirectory)){ // if the folder does not exist
            try {
                Files.createDirectories(storageDirectory); // we create the directory in the given storage directory path
            }catch (Exception e){
                e.printStackTrace();// print the exception
            }
        }

        Path destination = Paths.get(storageDirectory.toString() + "/" + fileName);
         //System.out.println(destination);
        try {
            Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);// we are Copying all bytes from an input stream to a file

        } catch (IOException e) {
            e.printStackTrace();
        }
        // the response will be the download URL of the image
       /* String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/images/getImage/")
                .path(fileName)
                .toUriString();*/
        // return the download image url as a response entity
        //imageRepository.save(fileName);
        return ResponseEntity.ok(fileName);
    }

    public  byte[] getImageWithMediaType(String imageName,HttpServletResponse response) throws IOException {
        //Path destination = Paths.get(storageDirectoryPath+"/"+imageName);// retrieve the image by its name
        //System.out.println(destination);
        //return IOUtils.toByteArray(destination.toUri());
    	
    	/*String path = "ProductImages/"+imageName+".jpeg";
    	System.out.println(path);
    	var imageFile = new ClassPathResource(path);
    	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    	StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());*/
  

    	InputStream is = getClass()
    			.getResourceAsStream(fileDownloadUri);
    	//System.out.println(is);
    	return IOUtils.toByteArray(is);
    }

}
