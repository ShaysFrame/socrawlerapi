package pub.shay.socrawlerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
			IllegalArgumentException ex, WebRequest request) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("status", HttpStatus.BAD_REQUEST.value());
		errorDetails.put("error", "Bad Request");
		errorDetails.put("message", ex.getMessage());
		errorDetails.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, Object>> handleRuntimeException(
			RuntimeException ex, WebRequest request) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.put("error", "Internal Server Error");
		errorDetails.put("message", "An unexpected error occurred");
		errorDetails.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleGlobalException(
			Exception ex, WebRequest request) {

		Map<String, Object> errorDetails = new HashMap<>();
		errorDetails.put("timestamp", LocalDateTime.now());
		errorDetails.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorDetails.put("error", "Internal Server Error");
		errorDetails.put("message", "An unexpected error occurred");
		errorDetails.put("path", request.getDescription(false).replace("uri=", ""));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
