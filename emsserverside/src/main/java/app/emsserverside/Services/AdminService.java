package app.emsserverside.Services;

import app.emsserverside.Beans.Admin;
import app.emsserverside.Beans.Employee;
import app.emsserverside.Exceptions.ExistsException;
import app.emsserverside.Exceptions.InvalidInputException;
import app.emsserverside.Repositories.AdminRepository;
import app.emsserverside.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {
    private EmployeeRepository employeeRepository;
    private AdminRepository adminRepository;

    public AdminService(EmployeeRepository employeeRepository, AdminRepository adminRepository) {
        this.employeeRepository = employeeRepository;
        this.adminRepository = adminRepository;
    }

    public boolean login(String username, String password) {
        return adminRepository.existsByUserNameAndPassword(username, password);
    }

    public void addEmployee(Employee employee) throws InvalidInputException {
        if (employee.getStartDate().after(employee.getEndDate())) {
            throw new InvalidInputException("Invalid Date Input");
        }
        //TODO Add all attributes
        if (employee.getFirstName().equals("") ) {
            throw new InvalidInputException("All field must be filled");
        }
    }

    public void updateEmployee(Employee employee) throws InvalidInputException {
        Employee employeeFromDb = employeeRepository.findById(employee.getId()).orElseThrow(()->new ExistsException("Not found"));
        if (employee.getId() != employeeFromDb.getId() ) {
            throw new InvalidInputException("Cannot change id");
        }
        //TODO add more validation
    }

    public void deleteEmployee(int id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
    }

    public Employee getOneEmployee(int id) {
        return employeeRepository.findById(id).orElseThrow(()->new ExistsException("Employee Not Found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Admin getAdminDetails(String email, String password) {
        return adminRepository.findByEmailAndPassword(email, password);
    }

}
