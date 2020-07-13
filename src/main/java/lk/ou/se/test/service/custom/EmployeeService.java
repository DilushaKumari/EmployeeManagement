package lk.ou.se.test.service.custom;

import lk.ou.se.test.dto.GetDependentDTO;
import lk.ou.se.test.entity.Employee;
import lk.ou.se.test.service.SuperService;

import java.util.List;

public interface EmployeeService extends SuperService {

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(String employeeId) ;

    List<Employee> findAllEmployee() ;

    Employee findEmployeeById(String employeeId);

    String getLastEmployeeId();

    List<GetDependentDTO> getDependentById(String  emp_id) ;


}
