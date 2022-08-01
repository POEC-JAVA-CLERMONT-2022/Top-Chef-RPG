package TopChefRPG.Security;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class JwtUtils {


    public String generateJwtToken(Authentication authentication){
        return "token";
    }

    public String getUserNameFromJwtToken(String token){
        return "toto";
    }

    public boolean validateJwtToken(String token){

        return true;
    }

}
