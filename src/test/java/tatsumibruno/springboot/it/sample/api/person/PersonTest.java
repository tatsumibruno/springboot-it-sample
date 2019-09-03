package tatsumibruno.springboot.it.sample.api.person;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tatsumibruno.springboot.it.sample.configuration.PostgresSQLConfigTest;
import tatsumibruno.springboot.it.sample.domain.person.exception.PersonNotFoundException;
import tatsumibruno.springboot.it.sample.domain.person.model.Person;
import tatsumibruno.springboot.it.sample.domain.person.service.PersonService;
import tatsumibruno.springboot.it.sample.infra.person.PersonJpaRepository;
import tatsumibruno.springboot.it.sample.infra.person.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
        PostgresSQLConfigTest.class,
        PersonController.class,
        PersonService.class,
        PersonJpaRepository.class,
        PersonRepository.class
})
public class PersonTest {

    @Autowired
    private PersonController controller;

    @Test
    public void successCrudOperations() throws PersonNotFoundException {
        final PersonDTO created = controller.create(new PersonDTO(1L, "Bruno", "39217082813"));
        final Person byId = controller.getById(created.getId());
        Assert.assertThat(byId, Matchers.notNullValue());
        controller.delete(created.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void failOnCreation() {
        controller.create(new PersonDTO(1L, "Bruno", "123"));
    }

    @Test(expected = PersonNotFoundException.class)
    public void failOnUpdate() throws PersonNotFoundException {
        controller.update(999L, new PersonDTO(1L, "Bruno", "39217082813"));
    }

    @Test(expected = PersonNotFoundException.class)
    public void failOnDelete() throws PersonNotFoundException {
        controller.delete(999L);
    }
}
