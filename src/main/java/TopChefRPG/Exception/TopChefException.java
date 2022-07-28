package TopChefRPG.Exception;

import org.springframework.http.HttpStatus;


public class TopChefException extends RuntimeException{
    private final ErrorType exceptionType;

    private final String exceptionDescription;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private final HttpStatus httpStatus;

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
