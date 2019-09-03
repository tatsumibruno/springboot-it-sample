package tatsumibruno.springboot.it.sample.infra.person;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tatsumibruno.springboot.it.sample.domain.person.model.Person;
import tatsumibruno.springboot.it.sample.domain.person.repository.IPersonRepository;

import java.util.List;
import java.util.Optional;

@Repository
public class PersonRepository implements IPersonRepository {

    @Autowired
    private PersonJpaRepository jpaRepository;

    @Override
    public List<Person> findAll() {
        return Lists.newArrayList(jpaRepository.findAll());
    }

    @Override
    public Person create(Person person) {
        return jpaRepository.save(person);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public void update(Person person) {
        if (jpaRepository.existsById(person.getId())) {
            jpaRepository.save(person);
        }
    }

    @Override
    public void delete(Person person) {
        jpaRepository.delete(person);
    }
}
