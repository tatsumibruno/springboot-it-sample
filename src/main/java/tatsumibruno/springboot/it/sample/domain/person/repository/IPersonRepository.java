package tatsumibruno.springboot.it.sample.domain.person.repository;

import tatsumibruno.springboot.it.sample.domain.person.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonRepository {

    List<Person> findAll();

    Person create(Person person);

    Optional<Person> findById(Long id);

    void update(Person person);

    void delete(Person person);
}
