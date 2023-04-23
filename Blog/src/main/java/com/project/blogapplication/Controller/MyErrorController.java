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
	
	/**
	 * @param res
	 * @return
	 */
	@RequestMapping("/error")
    public String handleError(HttpServletResponse res)
    {
        
		if (res.getStatus()==HttpStatus.NOT_FOUND.value()) {
			
			//ResourceNotFoundException.getFieldValue();
			return ResourceNotFoundException
							.ResourceNotFoundMessagebody("Post", "id", ResourceNotFoundException.getFieldValue());
		}
		else
		return String.valueOf(res.getStatus());
    }
    
    
    

}
