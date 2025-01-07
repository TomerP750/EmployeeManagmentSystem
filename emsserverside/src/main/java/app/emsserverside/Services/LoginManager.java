package app.emsserverside.Services;

public class LoginManager {

    private AdminService adminService;

    public LoginManager(AdminService adminService) {
        this.adminService = adminService;
    }

    //TODO create token after login and implement it in the authcontroller
//    public String login(String username, String password) {
//        if (adminService.login(username, password)) {
//            return "Login Successful";
//        }
//        return "Login Failed";
//    }
}
