package app.emsserverside.Threads;

import app.emsserverside.Beans.Employee;
import app.emsserverside.Repositories.EmployeeRepository;
import org.springframework.scheduling.annotation.Scheduled;

public class ExpireredDateEmployeesJob implements Runnable {

    private EmployeeRepository employeeRepository;

    public ExpireredDateEmployeesJob(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Scheduled(cron = "0 1 0 * * *")
    public void run() {
        employeeRepository.deleteExpiredEmployee();
    }
}
