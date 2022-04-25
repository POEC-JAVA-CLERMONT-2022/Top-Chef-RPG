package TopChefRPG.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handleException (Exception exception, WebRequest webRequest)
    {
        // gestion des erreurs ici pour tous les controlleurs qui ont un throws
        return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;

    }

}

