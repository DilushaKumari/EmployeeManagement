package lk.ou.se.test.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee implements SuperEntity {

   @Id
    private String emp_id;
    private String emp_fname;
    private String emp_lname;
    private String emp_mobile;
    private double salary;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "super_visor")
    private Employee super_visor;

//    @JsonManagedReference
    @ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "department" )
//    @JsonIgnore
    private Department department;

 //  @JsonBackReference
//    @OneToMany(mappedBy = "employee",fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
//    private List<Dependent> dependents = new ArrayList<>();

    public Employee() {
    }

    public Employee(String emp_id, String emp_fname, String emp_lname, String emp_mobile, double salary, Employee super_visor, Department department) {
        this.setEmp_id(emp_id);
        this.setEmp_fname(emp_fname);
        this.setEmp_lname(emp_lname);
        this.setEmp_mobile(emp_mobile);
        this.setSalary(salary);
        this.setSuper_visor(super_visor);
        this.setDepartment(department);
    }


    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_fname() {
        return emp_fname;
    }

    public void setEmp_fname(String emp_fname) {
        this.emp_fname = emp_fname;
    }

    public String getEmp_lname() {
        return emp_lname;
    }

    public void setEmp_lname(String emp_lname) {
        this.emp_lname = emp_lname;
    }

    public String getEmp_mobile() {
        return emp_mobile;
    }

    public void setEmp_mobile(String emp_mobile) {
        this.emp_mobile = emp_mobile;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getSuper_visor() {
        return super_visor;
    }

    public void setSuper_visor(Employee super_visor) {
        this.super_visor = super_visor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

//    public List<Dependent> getDependents() {
//        return dependents;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_fname='" + emp_fname + '\'' +
                ", emp_lname='" + emp_lname + '\'' +
                ", emp_mobile='" + emp_mobile + '\'' +
                ", salary=" + salary +
                '}';
    }
}
