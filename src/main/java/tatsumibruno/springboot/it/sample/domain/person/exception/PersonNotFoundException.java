package tatsumibruno.springboot.it.sample.domain.person.exception;

public class PersonNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Person not found.";
    }
}
