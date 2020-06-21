package lk.ou.se.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department implements SuperEntity {

    @Id
    private
    String dep_id;
    private String dep_name;

    @JsonBackReference
    @OneToMany(mappedBy ="department",fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<>();

    public Department() {
    }

    public Department(String dep_id, String dep_name) {
        this.setDep_id(dep_id);
        this.setDep_name(dep_name);
    }


    public String getDep_id() {
        return dep_id;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
