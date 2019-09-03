package tatsumibruno.springboot.it.sample.domain.person.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tatsumibruno.springboot.it.sample.domain.person.vo.Cpf;
import tatsumibruno.springboot.it.sample.infra.person.converters.JPACpfConverter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@ToString
@EqualsAndHashCode(of = "cpf")
@Table(name = "person")
@NoArgsConstructor
public class Person {

    @Id
    @Getter
    @GeneratedValue(generator = "person_sequence")
    @SequenceGenerator(name = "person_sequence")
    private Long id;

    @Column
    @Getter
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @Convert(converter = JPACpfConverter.class)
    private Cpf cpf;

    public static Person of(Long id, String name, String cpf) {
        final Person person = of(name, cpf);
        person.id = id;
        return person;
    }

    public static Person of(String name, String cpf) {
        final Person person = new Person();
        person.name = name;
        person.cpf = Cpf.of(cpf);
        return person;
    }

    public String getCpf() {
        return cpf.getFormattedValue();
    }
}
