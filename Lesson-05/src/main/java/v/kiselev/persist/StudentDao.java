package v.kiselev.persist;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class StudentDao {
    private final EntityManagerFactory emFactory;


    public StudentDao(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public Optional<Student> findById(Long id) {
        return executeForEntityManager(em ->
                Optional.ofNullable(em.find(Student.class, id)));
    }

    public List<Student> findAll() {
        return executeForEntityManager(em ->
                em.createQuery("select s from Student s", Student.class).getResultList());
    }

    private void insert(Student student) {
        executeTransaction(em ->
                em.persist(student));
    }

    private void save(Student student) {
        executeTransaction(em ->
                em.merge(student));
    }

    public void deleteById(Long id) {
        executeTransaction(em->
                em.createQuery("delete from Student where id = :id")
                        .setParameter("id",id)
                        .executeUpdate()
        );
    }

    public void saveOrUpdate(Student student) {
        if (Long.valueOf(student.getId()) == null) {
            insert(student);
        } else {
            save(student);
        }

    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function) {
        EntityManager em = emFactory.createEntityManager();
        try {
            return function.apply(em);
        } finally {
            em.close();
        }
    }

    private void executeTransaction (Consumer<EntityManager> student) {
        EntityManager em = emFactory.createEntityManager();
        try{
            em.getTransaction().begin();
            student.accept(em);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
