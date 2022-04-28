package TopChefRPG.Exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorTopChef implements Serializable {
    public ErrorType name;
    public String description;
    public HttpStatus httpStatus;


    public ErrorTopChef(ErrorType name, String description, HttpStatus httpStatus) {
        this.name = name;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
