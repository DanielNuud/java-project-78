package hexlet.code;

public class Validator<T> {
    public StringSchema<T> string() {
        return new StringSchema<T>();
    }

}
