package TopChefRPG.Service.DTO;

import org.springframework.http.HttpStatus;

public class EntityMessage {
    public String message = "";
    public HttpStatus httpStatus;

    public EntityMessage(String message, HttpStatus httpStatus){
        this.message=message;
        this.httpStatus=httpStatus;

    }
}
