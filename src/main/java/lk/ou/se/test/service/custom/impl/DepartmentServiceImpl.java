package lk.ou.se.test.service.custom.impl;

import lk.ou.se.test.entity.Department;
import lk.ou.se.test.repository.DepartmentRepo;
import lk.ou.se.test.service.custom.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepo departmentRepo;


    @Override
    public void saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void updateDepartment(Department department) {

        Department existingDepartment = departmentRepo.findById(department.getDep_id()).orElse(null);
        existingDepartment.setDep_name(department.getDep_name());

        departmentRepo.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(String dep_id) {
        departmentRepo.deleteById(dep_id);
    }

    @Override
    public List<Department> findAllDepartment() {
        return departmentRepo.findAll();
    }

    @Override
    public Department findDepartmentsById(String dep_id) {
        return departmentRepo.findById(dep_id).orElse(null);
    }
}
