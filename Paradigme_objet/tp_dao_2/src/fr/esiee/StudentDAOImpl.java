package fr.esiee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Connection connection;

    public StudentDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        String query = "INSERT INTO students VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, student.getId());
        stmt.setString(2, student.getFirstName());
        stmt.setString(3, student.getLastName());
        stmt.setInt(4, student.getAge());

        stmt.executeUpdate();
        System.out.println("Étudiant ajouté avec succès.");
    }

    @Override
    public Student getStudentById(int id) throws SQLException {
        String query = "SELECT * FROM students WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getInt("age")
                );
            }
        return null;
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            students.add(new Student(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getInt("age")
                ));
            }
        return students;
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET first_name = ?, last_name = ?, age = ? WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, student.getFirstName());
        stmt.setString(2, student.getLastName());
        stmt.setInt(3, student.getAge());
        stmt.setInt(4, student.getId());

        stmt.executeUpdate();
        System.out.println("Étudiant mis à jour avec succès.");
        }

    @Override
    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM students WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        System.out.println("Étudiant supprimé avec succès.");
        }
}