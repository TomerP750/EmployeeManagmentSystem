package app.emsserverside.Controllers;


import app.emsserverside.Exceptions.InvalidInputException;
import app.emsserverside.Security.SessionManager;
import app.emsserverside.Services.LoginManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private LoginManager loginManager;
    private SessionManager sessionManager;

    public AuthController(LoginManager loginManager, SessionManager sessionManager) {
        this.loginManager = loginManager;
        this.sessionManager = sessionManager;
    }

    @PostMapping
    public String login(String username, String password) throws InvalidInputException {
        return loginManager.login(username, password);
    }

    @GetMapping("logout")
    public void logout(String token) {
        sessionManager.getActiveTokens().remove(token);
    }





}
