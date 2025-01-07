package app.emsserverside.Controllers;


import app.emsserverside.Services.LoginManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private LoginManager loginManager;



}
