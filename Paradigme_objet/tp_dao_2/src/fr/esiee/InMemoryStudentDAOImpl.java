package fr.esiee;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentDAOImpl implements StudentDAO {
    private List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Étudiant ajouté en mémoire.");
    }

    @Override
    public Student getStudentById(int id) {
        return students.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == student.getId()) {
                students.set(i, student);
                System.out.println("Étudiant mis à jour en mémoire.");
                return;
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        System.out.println("Étudiant supprimé de la mémoire.");
    }
}
