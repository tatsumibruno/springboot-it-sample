package tatsumibruno.springboot.it.sample.api.person;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import tatsumibruno.springboot.it.sample.domain.person.model.Person;

@Data
@ToString
@AllArgsConstructor
@JsonSerialize
public class PersonDTO {

    private Long id;

    private String name;

    private String cpf;

    public static PersonDTO from(Person person) {
        return new PersonDTO(person.getId(), person.getName(), person.getCpf());
    }

    public Person toEntity() {
        return Person.of(this.id, this.name, this.cpf);
    }

}
