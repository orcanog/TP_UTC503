package fr.esiee;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    void addStudent(Student student) throws SQLException;
    Student getStudentById(int id) throws SQLException;
    List<Student> getAllStudents() throws SQLException;
    void updateStudent(Student student) throws SQLException;
    void deleteStudent(int id) throws SQLException;
}