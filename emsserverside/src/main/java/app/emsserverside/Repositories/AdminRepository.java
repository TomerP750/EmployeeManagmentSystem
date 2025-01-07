package app.emsserverside.Repositories;

import app.emsserverside.Beans.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    boolean existsByUserNameAndPassword(String username, String password);
}
