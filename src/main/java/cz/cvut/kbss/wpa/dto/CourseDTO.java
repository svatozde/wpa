/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.kbss.wpa.dto;

/**
 *
 * @author marek
 */
public class CourseDTO extends AbstractDTO {
    
    private String courseId;

    private String name;
    
    public CourseDTO() {
    }

    public CourseDTO(Long id, String courseId, String name) {
        this.id = id;
        this.courseId = courseId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    
}
