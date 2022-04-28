package TopChefRPG.web;

import TopChefRPG.Exception.ErrorTopChef;
import TopChefRPG.Exception.TopChefException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleException (Exception exception, WebRequest webRequest)
    {
        // gestion des erreurs ici pour tous les controlleurs qui ont un throws
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    @ExceptionHandler(value = TopChefException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity handleExceptionbis (TopChefException exception, WebRequest webRequest)
    {
        // gestion des erreurs ici pour tous les controlleurs qui ont un throws
        ErrorTopChef error = new ErrorTopChef(exception.getExceptionType(), exception.getExceptionDescription(), exception.getHttpStatus());

        return new ResponseEntity<>(error, exception.getHttpStatus()) ;

    }

}

