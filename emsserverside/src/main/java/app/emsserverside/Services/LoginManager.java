package app.emsserverside.Services;

import app.emsserverside.Beans.Admin;
import app.emsserverside.Exceptions.ExistsException;
import app.emsserverside.Exceptions.InvalidInputException;
import app.emsserverside.Security.TokenManager;
import app.emsserverside.Security.TokenProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Date;
@Service
public class LoginManager {

    private ApplicationContext ctx;
    private TokenManager tokenManager;

    public LoginManager(ApplicationContext ctx, TokenManager tokenManager) {
        this.ctx = ctx;
        this.tokenManager = tokenManager;
    }

    public String login(String email, String password) throws ExistsException, InvalidInputException {

        AdminService adminService = ctx.getBean(AdminService.class);
        Admin adminFromDb = adminService.getAdminDetails(email, password);

        if (adminService.login(email, password)) {
            String token = tokenManager.createToken(email, adminFromDb.getUserName(), adminFromDb.getPassword());
            tokenManager.getActiveTokens().put(token, new TokenProperties(new Date(System.currentTimeMillis())));
            return token;
        } else {
            throw new InvalidInputException("Invalid username or password");
        }
    }

    public void logout(String token) {
        tokenManager.getActiveTokens().remove(token);
    }
}
