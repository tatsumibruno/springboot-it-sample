package tatsumibruno.springboot.it.sample.api.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tatsumibruno.springboot.it.sample.domain.person.exception.PersonNotFoundException;
import tatsumibruno.springboot.it.sample.domain.person.model.Person;
import tatsumibruno.springboot.it.sample.domain.person.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @GetMapping
    public List<Person> list() {
        return service.findAll();
    }

    @GetMapping(path = "/{id}")
    public Person getById(@PathVariable Long id) throws PersonNotFoundException {
        return service.findById(id);
    }

    @PostMapping
    public PersonDTO create(@RequestBody PersonDTO person) {
        final Person personIn = person.toEntity();
        final Person personOut = service.create(personIn);
        return PersonDTO.from(personOut);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Long id, @RequestBody PersonDTO person) throws PersonNotFoundException {
        person.setId(id);
        final Person personIn = person.toEntity();
        service.update(personIn);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Long id) throws PersonNotFoundException {
        this.service.delete(id);
    }
}
