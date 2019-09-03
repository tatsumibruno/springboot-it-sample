package tatsumibruno.springboot.it.sample.domain.person.vo;

import com.google.common.base.Preconditions;
import lombok.*;

@ToString
@EqualsAndHashCode(of = "value")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Cpf {

    @Getter
    private String value;

    public static Cpf of(String value) {
        Preconditions.checkNotNull(value);
        String clearString = value.replaceAll("[-.]", "");
        Preconditions.checkArgument(clearString.matches("[0-9]{11}"), "CPF %s inválido.", value);
        return new Cpf(clearString);
    }

    public final String getFormattedValue() {
        return String.format("%s.%s.%s-%s",
                value.substring(0, 3),
                value.substring(3, 6),
                value.substring(6, 9),
                value.substring(9, 11));
    }

}
