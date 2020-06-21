package lk.ou.se.test.controller;

import lk.ou.se.test.entity.Department;
import lk.ou.se.test.exception.NotFoundException;
import lk.ou.se.test.service.custom.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/departments")
@CrossOrigin
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartmrnts() {
        List<Department> allDepartments = departmentService.findAllDepartment();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-Count",allDepartments.size() + "");
        return new ResponseEntity<>(allDepartments,httpHeaders,HttpStatus.OK);
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Department getDepartment(@PathVariable String id) {
        try {
            return departmentService.findDepartmentsById(id);
        } catch (NullPointerException e) {
            throw new NotFoundException(e);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
        @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String saveDepartment(@RequestBody Department department) {
        departmentService.saveDepartment(department);
        return "\"" + department.getDep_id() + "\"";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable String id) {
        departmentService.deleteDepartment(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable String id,
                               @RequestBody Department department) {
        department.setDep_id(id);
        departmentService.updateDepartment(department);
    }

}
