package lk.ou.se.test.controller;

import lk.ou.se.test.entity.Employee;
import lk.ou.se.test.exception.NotFoundException;
import lk.ou.se.test.service.custom.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/employees")
@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> allEmployees = employeeService.findAllEmployee();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",allEmployees.size() + "");
        return new ResponseEntity<>(allEmployees,httpHeaders,HttpStatus.OK);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@PathVariable String id) {
        try {
            return employeeService.findEmployeeById(id);
        } catch (NullPointerException e) {
            throw new NotFoundException(e);
        }
    }

    @GetMapping(params = "q=last")
    public String getLastEmpId() {
        return employeeService.getLastEmployeeId();
    }

    @ResponseStatus(HttpStatus.CREATED)
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveCustomer(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "\"" + employee.getEmp_id() + "\"";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable String id,
                               @RequestBody Employee employee) {
        employee.setEmp_id(id);
        employeeService.updateEmployee(employee);
    }

}
