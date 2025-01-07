package app.emsserverside.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class TokenManager {

    private HashMap<String, TokenProperties> activeTokens = new HashMap<>();

    private ApplicationContext ctx;

    public TokenManager(ApplicationContext ctx) {
        this.ctx = ctx;
    }


    public String createToken(String userName, String email, String firstName) {
        String token = JWT.create()
                .withIssuer("EMS")
                .withSubject(userName)
                .withClaim("email", email)
                .sign(Algorithm.none());
        return token;
    }

    public HashMap<String, TokenProperties> getActiveTokens() {
        return activeTokens;
    }
}
