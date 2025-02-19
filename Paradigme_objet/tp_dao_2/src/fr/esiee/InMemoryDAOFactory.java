package fr.esiee;

public class InMemoryDAOFactory implements DAOFactory {
    private static final InMemoryStudentDAOImpl studentDAO = new InMemoryStudentDAOImpl();

    @Override
    public StudentDAO getStudentDAO() {
        return studentDAO;
    }
}
