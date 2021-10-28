package com.ecommerce.EasyCart.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.EasyCart.Repository.ImageRepository;
import com.ecommerce.EasyCart.Service.ImageService;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "api/images")
public class ImageController {
	@Autowired
	ImageRepository imageRepository;

    /*@Autowired
    public ImageService imageService;
    @PostMapping(value ="upload")
    public ResponseEntity uploadImage(@RequestParam("uploadfile")MultipartFile file){
        imageRepository.save(file.getOriginalFilename());
        return this.imageService.uploadToLocalFileSystem(file);
    }*/
    @GetMapping(
            value = "getImage/{imageName:.+}",
            produces = {MediaType.IMAGE_JPEG_VALUE,MediaType.IMAGE_GIF_VALUE,MediaType.IMAGE_PNG_VALUE}
    )
    /*public @ResponseBody byte[] getImageWithMediaType(@PathVariable(name = "imageName") String fileName) throws IOException {
        System.out.println(fileName);
    	return this.imageService.getImageWithMediaType(fileName);
    }*/
    public void getImage(@PathVariable("imageName") String fileName,HttpServletResponse response) throws IOException{
   	String path = "ProductImages/"+fileName+".jpeg";
    	System.out.println(path);
    	var imageFile = new ClassPathResource(path);
    	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    	StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    	
    	//return this.imageService.getImageWithMediaType(fileName, null);
    }
}
/*import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.EasyCart.Entity.ImageModel;
import com.ecommerce.EasyCart.Repository.ImageRepository;

@RestController
@RequestMapping("/imageupload")
public class ImageController {
	@Autowired
	ImageRepository imageRepository;
 
	 @PostMapping("/{customerId}")
	    public String uploadMultipartFile(@RequestParam("uploadfile") MultipartFile file,@PathVariable("customerId") Integer customerId) {
	    	try {
		    	String baseurl="http://localhost:8081/images/";
		    	String fname=file.getOriginalFilename();
		    	String url=baseurl.concat(fname);
		     	ImageModel filemode = new ImageModel(url,customerId);
		    	imageRepository.save(filemode);
		    	
		    	String uploadDir = "images";
		    	Path uploadPath = Paths.get(uploadDir);
		    	if (!Files.exists(uploadPath)) {
		    		Files.createDyirectories(uploadPath);
		    	}
		    	try(InputStream inputStream = file.getInputStream()) {
		    		Path filePath = uploadPath.resolve(fname);
		    		Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
		    	}
		    	catch(IOException e) {
		    		throw new IOException("could not save image file" +fname,e);
		    	}
		    return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
			} catch (	Exception e) {
				System.out.println(e);
				return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
			
			}    
	    }
	 
	 @GetMapping("/{imageId}")
	 public ImageModel getImage(@PathVariable("imageId") Integer imageId) {
	    	return 	imageRepository.findByImageId(imageId);
    
	    }
}*/