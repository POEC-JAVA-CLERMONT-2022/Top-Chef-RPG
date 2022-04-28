package TopChefRPG.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class TopChefException extends RuntimeException{
    private ErrorType exceptionType;

    private String exceptionDescription;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private HttpStatus httpStatus;

    public TopChefException(ErrorType errorType, String description, HttpStatus httpStatus)
    {
        this.exceptionType =errorType;
        this.exceptionDescription =description;
        this.httpStatus = httpStatus;
    }

    public ErrorType getExceptionType() {
        return exceptionType;
    }

    public String getExceptionDescription() {
        return exceptionDescription;
    }
}
