package TopChefRPG.Exception;

import org.springframework.http.HttpStatus;

public class Error {
    public String name;
    public String description;
    public HttpStatus httpStatus;


    public Error(String name, String description, HttpStatus httpStatus) {
        this.name = name;
        this.description = description;
        this.httpStatus = httpStatus;
    }
}
