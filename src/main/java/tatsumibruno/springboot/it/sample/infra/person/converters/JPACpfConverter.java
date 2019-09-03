package tatsumibruno.springboot.it.sample.infra.person.converters;

import tatsumibruno.springboot.it.sample.domain.person.vo.Cpf;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class JPACpfConverter implements AttributeConverter<Cpf, String> {


    @Override
    public String convertToDatabaseColumn(Cpf cpf) {
        return cpf.getValue();
    }

    @Override
    public Cpf convertToEntityAttribute(String s) {
        return Cpf.of(s);
    }
}
