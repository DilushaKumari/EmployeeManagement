package lk.ou.se.test.repository;

import lk.ou.se.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

    @Query(value = "SELECT id FROM Employee ORDER BY id DESC LIMIT 1", nativeQuery = true)
    String getLastEmployeeId() ;



}
