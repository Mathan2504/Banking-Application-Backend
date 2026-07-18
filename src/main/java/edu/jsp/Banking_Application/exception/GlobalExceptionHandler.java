package edu.jsp.Banking_Application.exception;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(value=NotFoundException.class) 
	public ResponseEntity<String> handleNotFoundException(NotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<HashMap<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
	{
		HashMap<String, String> map=new HashMap<>();
		List<FieldError> list=ex.getBindingResult().getFieldErrors();
		for(FieldError error:list)
		{
			map.put(error.getField(), error.getDefaultMessage());
			
		}
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		
	}

}
  