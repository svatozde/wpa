/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.dto;

/**
 *
 * @author marek
 */
public class TeacherDTO extends PersonDTO {

    private DepartmentDTO department;

    public TeacherDTO() {
    }
    
    public TeacherDTO(Long id, String username, String firstName, String surname, long birthNumber, DepartmentDTO department) {
        super(id, username, firstName, surname, birthNumber);
        this.department = department;
    }

    public DepartmentDTO getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentDTO department) {
        this.department = department;
    }
    
}
