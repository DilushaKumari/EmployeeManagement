package lk.ou.se.test.service.custom.impl;

import lk.ou.se.test.dto.GetDependentDTO;
import lk.ou.se.test.entity.CustomEntity;
import lk.ou.se.test.entity.Employee;
import lk.ou.se.test.repository.EmployeeRepo;
import lk.ou.se.test.repository.impl.QueryRepoImpl;
import lk.ou.se.test.service.custom.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private QueryRepoImpl queryRepoImpl;
    @Override
    public void saveEmployee(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepo.findById(employee.getEmp_id()).orElse(null);
        existingEmployee.setEmp_fname(employee.getEmp_fname());
        existingEmployee.setEmp_lname(employee.getEmp_lname());
        existingEmployee.setEmp_mobile(employee.getEmp_mobile());
        existingEmployee.setSalary(employee.getSalary());
        employeeRepo.save(existingEmployee);

    }

    @Override
    public void deleteEmployee(String employeeId) {
        employeeRepo.deleteById(employeeId);
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findEmployeeById(String employeeId) {
        return employeeRepo.findById(employeeId).orElse(null);
    }

    @Override
    public String getLastEmployeeId() {
        String lastCustomerId = employeeRepo.getLastEmployeeId();
        return lastCustomerId;
    }

    @Override
    public List<GetDependentDTO> getDependentById(String  emp_id) {
        List<CustomEntity> dependentsById = queryRepoImpl.getDependentsById(emp_id);
        List<GetDependentDTO> sendDependents = new ArrayList<>();

        for (CustomEntity dependent : dependentsById
        ) {
            sendDependents.add(new GetDependentDTO(dependent.getEmp_id(), dependent.getDependent_fname(), dependent.getDependent_lname()));

        }
        return sendDependents;
    }
}
