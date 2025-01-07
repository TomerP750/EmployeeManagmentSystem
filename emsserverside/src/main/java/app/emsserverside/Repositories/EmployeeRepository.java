package app.emsserverside.Repositories;

import app.emsserverside.Beans.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    boolean existsById(int id);

    @Query(value = "DELETE FROM employees WHERE end_date <= CURDATE()", nativeQuery = true)
    void deleteExpiredEmployee();
}
