package cz.cvut.kbss.wpa.service;

import cz.cvut.kbss.wpa.dao.GenericDAOIface;
import cz.cvut.kbss.wpa.dto.CourseDTO;
import cz.cvut.kbss.wpa.dto.DepartmentDTO;
import cz.cvut.kbss.wpa.dto.StudentDTO;
import cz.cvut.kbss.wpa.dto.TeacherDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cz.cvut.kbss.wpa.model.Course;
import cz.cvut.kbss.wpa.model.Student;
import cz.cvut.kbss.wpa.model.Teacher;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("schoolCenter")
public class SchoolCenter implements SchoolCenterIface, Serializable {

    
    @Autowired
    private GenericDAOIface genericDAO;
    

    @Override
    public StudentDTO createStudent(StudentDTO student, String password) {
        //em.merge(student);
        Student s = new Student(student, password);
        s.setSupervisor(genericDAO.getById(student.getSupervisor().getId(), Teacher.class));
        s.setEnrolledInCourses(new ArrayList<Course>());
        for (CourseDTO c : student.getEnrolledInCourses()) {
            s.getEnrolledInCourses().add(genericDAO.getById(c.getId(), Course.class));
        }
        s = genericDAO.saveOrUpdate(s);
        return createStudentDTO(s);
    }

    @Override
    public StudentDTO saveStudent(StudentDTO student) {
        Student s = genericDAO.getById(student.getId(), Student.class);
        s.setFirstName(student.getFirstName());
        s.setSurname(student.getSurname());
        s.setUsername(student.getUsername());
        //s.setBirthNumber(); to nepovolime menit
        s.setSupervisor(genericDAO.getById(student.getSupervisor().getId(), Teacher.class));
        s.getEnrolledInCourses().clear();
        for (CourseDTO c : student.getEnrolledInCourses()) {
            s.getEnrolledInCourses().add(genericDAO.getById(c.getId(), Course.class));
        }
        s = genericDAO.saveOrUpdate(s);
        return createStudentDTO(s);
    }
    
    @Override
    public void removeStudent(StudentDTO student) {
        //student = em.merge(student);
        //em.remove(student);
        genericDAO.removeById(student.getId(), Student.class);
    }

    @Override
    public StudentDTO getStudent(Long id) {
        //Student student = em.find(Student.class, birthNumber);
        Student s = genericDAO.getById(id, Student.class);
        if (s == null) {return null;}
        return createStudentDTO(s);
    }

    @Override
    public CourseDTO getCourse(String courseId) {
        //Course course = em.find(Course.class, courseId);
        List<Course> list = genericDAO.getByProperty("courseId", courseId, Course.class);
        if (list.isEmpty()){
            return null;
        } else if (list.size() == 1){
            Course c = list.get(0);
            return new CourseDTO(c.getId(), c.getCourseId(), c.getName());
        } else {
            throw new IllegalStateException("Illegal count of courses with the same courseId: " + list.size());
        }
    }

    @Override
    public TeacherDTO getTeacher(Long id) {
        //Teacher teacher = em.find(Teacher.class, birthNumber);
        Teacher t = genericDAO.getById(id, Teacher.class);
        if (t == null) {return null;}
        return new TeacherDTO(t.getId(), t.getUsername(), t.getFirstName(), t.getSurname(), t.getBirthNumber(), new DepartmentDTO(t.getDepartment().getName()));
    }

    @Override
    public List<CourseDTO> getAllCourses() {
        //return (List<Course>) em.createNamedQuery(Course.Q_GET_ALL_COURSES).getResultList();
        List<Course> courses = genericDAO.getAll(Course.class);
        List<CourseDTO> dtos = new ArrayList<CourseDTO>();
        for (Course c : courses){
            dtos.add(new CourseDTO(c.getId(), c.getCourseId(), c.getName()));
        }
        return dtos;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        //return (List<Student>) em.createQuery("SELECT s FROM Student s").getResultList();
        List<Student> students = genericDAO.getAll(Student.class);
        List<StudentDTO> dtos = new ArrayList<StudentDTO>();
        for (Student s : students){
            dtos.add(createStudentDTO(s));
        }
        return dtos;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        //return (List<Teacher>) em.createQuery("SELECT t FROM Teacher t").getResultList();
        List<Teacher> teachers = genericDAO.getAll(Teacher.class);
        List<TeacherDTO> dtos = new ArrayList<TeacherDTO>();
        for (Teacher t : teachers){
            dtos.add(new TeacherDTO(t.getId(), t.getUsername(), t.getFirstName(), t.getSurname(), t.getBirthNumber(), new DepartmentDTO(t.getDepartment().getName())));
        }
        return dtos;
    }

    private StudentDTO createStudentDTO(Student s) {
        List<CourseDTO> courseDTOs = new ArrayList<CourseDTO>();
        if (s.getEnrolledInCourses() != null) for (Course c : s.getEnrolledInCourses()) {
            courseDTOs.add(new CourseDTO(c.getId(), c.getCourseId(), c.getName()));
        }
        Teacher sv = s.getSupervisor();
        DepartmentDTO d = ((sv == null) || (sv.getDepartment() == null)) ? new DepartmentDTO("") : new DepartmentDTO(sv.getDepartment().getName());
        TeacherDTO t = (sv == null) ? new TeacherDTO() : new TeacherDTO(sv.getId(), sv.getUsername(), sv.getFirstName(), sv.getSurname(), sv.getBirthNumber(), d);
        return new StudentDTO(s.getId(), s.getUsername(), s.getFirstName(), s.getSurname(), s.getBirthNumber(), t, courseDTOs);
    }
    
}
