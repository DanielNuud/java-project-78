package hexlet.code;

<<<<<<< HEAD
public final class StringSchema extends BaseSchema {
    public StringSchema required() {
        addCheck(
                "required",
                value -> value != null && (value instanceof String && !((String) value).isEmpty())
        );
=======
public class StringSchema {
    private int minLength;
    private boolean required = false;
    private String contains;

    public StringSchema required() {
        this.required = true;
>>>>>>> 937ecdd (add StringSchema)
        return this;
    }

    public StringSchema minLength(int length) {
<<<<<<< HEAD
        addCheck(
                "minLength",
                value -> value == null || ((String) value).length() >= length
        );
        return this;
    }

    public StringSchema contains(String substring) {
        addCheck(
                "contains",
                value -> value == null || ((String) value).contains(substring)
        );
        return this;
    }
=======
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String text) {
        this.contains = text;
        return this;
    }

    public boolean isValid(String data) {
        if (required && data.isEmpty()) {
            return false;
        }

        if (!contains.isEmpty() && !data.contains(contains)) {
            return false;
        }

        if (data.length() < minLength) {
            return false;
        }

        return true;
    }
>>>>>>> 937ecdd (add StringSchema)
}
