package tatsumibruno.springboot.it.sample.infra.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tatsumibruno.springboot.it.sample.domain.person.model.Person;

@Repository
public interface PersonJpaRepository extends CrudRepository<Person, Long> {
}
