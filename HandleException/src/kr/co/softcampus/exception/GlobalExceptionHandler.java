package kr.co.softcampus.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6348806573083644694L;

	@ExceptionHandler(Exception.class)
	public String handleException() {
		return "error2";
	}
}
