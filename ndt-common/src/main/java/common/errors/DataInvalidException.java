package main.java.common.errors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataInvalidException  extends RuntimeException{
    public DataInvalidException(final String message) {
        super(message);
    }
}
