package br.com.caique.crud.infra;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import br.com.caique.crud.infra.DTO.response.ErrorHandlingResponseDTO;

@RestControllerAdvice
public class errorHandling {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> dealWith404(NoSuchElementException ex) {
		ErrorHandlingResponseDTO errorBody = fillBodyError(404, "Contact not found !");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> dealWith400(SQLIntegrityConstraintViolationException ex) {
		ErrorHandlingResponseDTO errorBody = fillBodyError(400, ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
	}
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<?> dealWith400(BadRequest ex) {
		ErrorHandlingResponseDTO errorBody = fillBodyError(400, ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
	}

	private ErrorHandlingResponseDTO fillBodyError(int statusCode, String message) {
		ErrorHandlingResponseDTO errorBody = new ErrorHandlingResponseDTO();

		errorBody.setMessage(message);
		errorBody.setCode(statusCode);

		return errorBody;
	}
}
