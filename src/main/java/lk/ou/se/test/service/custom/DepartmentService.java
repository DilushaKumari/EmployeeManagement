package lk.ou.se.test.service.custom;

import lk.ou.se.test.entity.Department;
import lk.ou.se.test.service.SuperService;

import java.util.List;

public interface DepartmentService extends SuperService {

    void saveDepartment(Department department);

    void updateDepartment(Department department);

    void deleteDepartment(String dep_id) ;

    List<Department> findAllDepartment() ;

    Department findDepartmentsById(String dep_id);



}
