package lk.ou.se.test.dto;


public class GetDependentDTO {
    private String emp_id;
    private String dependent_fname;
    private String dependent_lname;

    public GetDependentDTO() {

    }

    public GetDependentDTO(String emp_id, String dependent_fname, String dependent_lname) {
        this.setEmp_id(emp_id);
        this.setDependent_fname(dependent_fname);
        this.setDependent_lname(dependent_lname);
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

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
}
