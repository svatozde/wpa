package cz.cvut.kbss.wpa.service;

import cz.cvut.kbss.wpa.dto.CourseDTO;
import cz.cvut.kbss.wpa.dto.StudentDTO;
import cz.cvut.kbss.wpa.dto.TeacherDTO;
import java.util.List;
import java.util.Map;
import org.springframework.security.access.annotation.Secured;
import org.springframework.transaction.annotation.Transactional;

public interface SchoolCenterIface {

    @Secured({"ROLE_student", "ROLE_teacher"})
    @Transactional(readOnly=true)
    CourseDTO getCourse(String course);

    @Secured({"ROLE_student", "ROLE_teacher"})
    @Transactional(readOnly=true)
    List<CourseDTO> getAllCourses();

    @Secured({"ROLE_student", "ROLE_teacher"})
    @Transactional(readOnly=true)
    StudentDTO getStudent(Long id);

    @Secured("ROLE_teacher")
    @Transactional
    StudentDTO createStudent(StudentDTO student, String password);

    @Secured("ROLE_teacher")
    @Transactional
    StudentDTO saveStudent(StudentDTO student);

    @Secured({"ROLE_student", "ROLE_teacher"})
    @Transactional(readOnly=true)
    public List<StudentDTO> getAllStudents();

    @Secured("ROLE_teacher")
    @Transactional
    public void removeStudent(StudentDTO student);

    @Secured({"ROLE_student", "ROLE_teacher"})
    @Transactional(readOnly=true)
    public List<TeacherDTO> getAllTeachers();

    @Secured({"ROLE_student", "ROLE_teacher"})
    @Transactional(readOnly=true)
    public TeacherDTO getTeacher(Long id);
    
}
