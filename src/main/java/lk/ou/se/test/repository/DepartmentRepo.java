package lk.ou.se.test.repository;

import lk.ou.se.test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentRepo extends JpaRepository<Department, String> {


}
