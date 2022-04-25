package TopChefRPG.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class TopChefException extends RuntimeException{

    public ResponseEntity<Error> noUserFound( int id){
        Error error = new Error("no User found","no User was found with the id : "+id, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.httpStatus);
    }

}
