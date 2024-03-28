package neo.java.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmpException extends RuntimeException {

	private static final long serialVersionUID = -2451081849002310735L;

	public EmpException(String message) {
    super(message);
	}
}
