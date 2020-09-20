package telran.stock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class AmountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4875532323639981060L;

}
