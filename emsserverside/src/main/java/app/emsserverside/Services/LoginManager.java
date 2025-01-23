package app.emsserverside.Services;

import app.emsserverside.Beans.Admin;
import app.emsserverside.Exceptions.ExistsException;
import app.emsserverside.Exceptions.InvalidInputException;
import app.emsserverside.Security.SessionManager;
import app.emsserverside.Security.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.sql.Date;
@Service
public class LoginManager {

    private ApplicationContext ctx;
    private SessionManager sessionManager;

    public LoginManager(ApplicationContext ctx, SessionManager sessionManager) {
        this.ctx = ctx;
        this.sessionManager = sessionManager;
    }

    public String login(String email, String password) throws ExistsException, InvalidInputException {
        //TODO MOVE THEM UNDER THE IF
        AdminService adminService = ctx.getBean(AdminService.class);
        Admin adminFromDb = adminService.getAdminDetails(email, password);

        if (adminService.login(email, password)) {
            String token = sessionManager.createToken(email, adminFromDb.getUserName());
            sessionManager.getActiveTokens().put(token, new Session(new Date(System.currentTimeMillis())));
            return token;
        } else {
            throw new InvalidInputException("Invalid email or password");
        }
    }

    public void logout(String token) {
        sessionManager.getActiveTokens().remove(token);
    }
}
