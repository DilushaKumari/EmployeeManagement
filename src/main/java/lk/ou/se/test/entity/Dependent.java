package lk.ou.se.test.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Dependent implements SuperEntity {

    @Id
    private String dependent_id;

//    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "emp_id")
//    @JsonIgnore
    private Employee employee;

    private String dependent_fname;
    private String dependent_lname;

    public Dependent() {
    }

    public Dependent(String dependent_id, Employee employee, String dependent_fname, String dependent_lname, String dependent_mobile) {
        this.dependent_id = dependent_id;
        this.employee = employee;
        this.dependent_fname = dependent_fname;
        this.dependent_lname = dependent_lname;
        this.dependent_mobile = dependent_mobile;
    }

    private String dependent_mobile;

    public String getDependent_fname() {
        return dependent_fname;
    }

    public void setDependent_fname(String dependent_fname) {
        this.dependent_fname = dependent_fname;
    }

    public String getDependent_lname() {
        return dependent_lname;
    }

    public void setDependent_lname(String dependent_lname) {
        this.dependent_lname = dependent_lname;
    }

    public String getDependent_mobile() {
        return dependent_mobile;
    }

    public void setDependent_mobile(String dependent_mobile) {
        this.dependent_mobile = dependent_mobile;
    }

    public String getDependent_id() {
        return dependent_id;
    }

    public void setDependent_id(String dependent_id) {
        this.dependent_id = dependent_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "dependent_id='" + dependent_id + '\'' +
                ", dependent_fname='" + dependent_fname + '\'' +
                ", dependent_lname='" + dependent_lname + '\'' +
                ", dependent_mobile='" + dependent_mobile + '\'' +
                '}';
    }
}
