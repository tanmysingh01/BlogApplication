package com.project.blogapplication.Controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.blogapplication.exceptions.ResourceNotFoundException;



@RestController


public class MyErrorController implements ErrorController {
	
	@RequestMapping("/error")
    public String handleError(HttpServletResponse res)
    {
        
		if (res.getStatus()==HttpStatus.NOT_FOUND.value()) {
			//System.out.println(ResourceNotFoundException);
			return String.valueOf("OOOPS!!!! Entity you are looking for is not available");
		}
		else
		return String.valueOf(res.getStatus());
    }
    
    
    

}
