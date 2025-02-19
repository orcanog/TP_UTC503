package fr.esiee;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            //Choisir entre base de données ou mémoire
            boolean useDatabase = false;

            DAOFactory factory = useDatabase ? new DatabaseDAOFactory() : new InMemoryDAOFactory();
            StudentDAO studentDAO = factory.getStudentDAO();

            Student student1 = new Student(1, "Alice", "Durand", 20);
            Student student2 = new Student(2, "Bob", "Martin", 22);
            Student student3 = new Student(3, "Charlie", "Dupont", 21);

            studentDAO.addStudent(student1);
            studentDAO.addStudent(student2);
            studentDAO.addStudent(student3);
            System.out.println("\nÉtudiants ajoutés !");

            List<Student> students = studentDAO.getAllStudents();
            System.out.println("\nListe des étudiants :");
            for (Student s : students) {
                System.out.println(s.getId() + " - " + s.getFirstName() + " " + s.getLastName() + ", " + s.getAge() + " ans");
            }

            Student retrieved = studentDAO.getStudentById(2);
            if (retrieved != null) {
                System.out.println("\nÉtudiant trouvé : " + retrieved.getFirstName() + " " + retrieved.getLastName());
            }

            student2.setAge(23);
            studentDAO.updateStudent(student2);
            System.out.println("\nÉtudiant mis à jour : " + studentDAO.getStudentById(2).getFirstName() + " a maintenant " + studentDAO.getStudentById(2).getAge() + " ans.");

            studentDAO.deleteStudent(1);
            System.out.println("\nÉtudiant supprimé !");
            
            students = studentDAO.getAllStudents();
            System.out.println("\nListe des étudiants après suppression :");
            for (Student s : students) {
                System.out.println(s.getId() + " - " + s.getFirstName() + " " + s.getLastName() + ", " + s.getAge() + " ans");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
