package tatsumibruno.springboot.it.sample.domain.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tatsumibruno.springboot.it.sample.domain.person.exception.PersonNotFoundException;
import tatsumibruno.springboot.it.sample.domain.person.model.Person;
import tatsumibruno.springboot.it.sample.domain.person.repository.IPersonRepository;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private IPersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person create(Person person) {
        return repository.create(person);
    }

    public Person findById(Long id) throws PersonNotFoundException {
        return repository.findById(id)
                .orElseThrow(PersonNotFoundException::new);
    }

    public void update(Person modified) throws PersonNotFoundException {
        findById(modified.getId());
        repository.update(modified);
    }

    public void delete(Long id) throws PersonNotFoundException {
        final Person person = findById(id);
        repository.delete(person);
    }
}
