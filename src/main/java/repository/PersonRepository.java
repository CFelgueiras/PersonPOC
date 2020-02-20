package repository;

import domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Transactional(SUPPORTS)
public class PersonRepository {

    @PersistenceContext(unitName = "personPU")
    private EntityManager em;

    @Transactional(REQUIRED)
    public Person create(Person person) {
        em.persist(person);
        em.flush();
        return person;
    }

    public List<Person> findAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class)
                .getResultList();
    }

    public Person find(@NotNull Long id) {
        return em.find(Person.class, id);
    }

    @Transactional(REQUIRED)
    public void delete(Long id) {
        em.remove(em.getReference(Person.class, id));
    }
}
