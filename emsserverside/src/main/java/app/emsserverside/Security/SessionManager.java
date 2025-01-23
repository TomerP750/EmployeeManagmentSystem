package app.emsserverside.Security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class SessionManager {

    private HashMap<String, Session> activeTokens = new HashMap<>();

    private ApplicationContext ctx;

    public SessionManager(ApplicationContext ctx) {
        this.ctx = ctx;
    }


    public String createToken(String email, String username) {
        String token = JWT.create()
                .withIssuer("EMS")
                .withSubject(username)
                .withClaim("email", email)
                .withClaim("userName", username)
                .sign(Algorithm.none());
        return token;
    }

    public HashMap<String, Session> getActiveTokens() {
        return activeTokens;
    }


    @Scheduled(cron = "0 1 0 * * *")
    public void clearExpiredTokens() {
        for (String token : activeTokens.keySet()) {
            // TODO if value of the token is expired end session

        }
    }
}
