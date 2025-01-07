package app.emsserverside.Controllers;

import app.emsserverside.Beans.Employee;
import app.emsserverside.Exceptions.InvalidInputException;
import app.emsserverside.Services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/emp/all")
    public List<Employee> getAllEmployees() {
        return adminService.getAllEmployees();
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return adminService.getOneEmployee(id);
    }

    @PostMapping("/emp/add")
    public void addEmployee(@RequestBody Employee employee) throws InvalidInputException {
        adminService.addEmployee(employee);
    }

    @PutMapping("/emp/update")
    public void updateEmployee(@RequestBody Employee employee) throws InvalidInputException {
        adminService.updateEmployee(employee);
    }

    @DeleteMapping("/emp/del")
    public void deleteEmployee(int id) throws InvalidInputException {
        adminService.deleteEmployee(id);
    }
}
