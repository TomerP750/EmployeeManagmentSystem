package app.emsserverside.Controllers;


import app.emsserverside.Exceptions.InvalidInputException;
import app.emsserverside.Security.TokenManager;
import app.emsserverside.Services.AdminService;
import app.emsserverside.Services.LoginManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private LoginManager loginManager;
    private TokenManager tokenManager;

    public AuthController(LoginManager loginManager, TokenManager tokenManager) {
        this.loginManager = loginManager;
        this.tokenManager = tokenManager;
    }

    @PostMapping
    public String login(String username, String password) throws InvalidInputException {
        return loginManager.login(username, password);
    }

    @GetMapping("logout")
    public void logout(String token) {
        tokenManager.getActiveTokens().remove(token);
    }





}
