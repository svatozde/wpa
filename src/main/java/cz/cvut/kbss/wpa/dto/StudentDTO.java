/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.dto;

import java.util.List;

public class StudentDTO extends PersonDTO {
    
    private TeacherDTO supervisor;
    
    private List<CourseDTO> enrolledInCourses;
    
    public StudentDTO() {
    }

    public StudentDTO(Long id, String username, String firstName, String surname, long birthNumber, TeacherDTO supervisor, List<CourseDTO> enrolledInCourses) {
        super(id, username, firstName, surname, birthNumber);
        this.supervisor = supervisor;
        this.enrolledInCourses = enrolledInCourses;
    }

    public TeacherDTO getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(TeacherDTO supervisor) {
        this.supervisor = supervisor;
    }

    public List<CourseDTO> getEnrolledInCourses() {
        return enrolledInCourses;
    }

    public void setEnrolledInCourses(List<CourseDTO> enrolledInCourses) {
        this.enrolledInCourses = enrolledInCourses;
    }
    
}
