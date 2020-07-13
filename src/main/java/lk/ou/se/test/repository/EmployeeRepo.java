package lk.ou.se.test.repository;

import lk.ou.se.test.dto.GetDependentDTO;
import lk.ou.se.test.entity.CustomEntity;
import lk.ou.se.test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, String> {

    @Query(value = "SELECT emp_id FROM Employee ORDER BY emp_id DESC LIMIT 1", nativeQuery = true)
    String getLastEmployeeId();


}
