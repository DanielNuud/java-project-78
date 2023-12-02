package hexlet.code;

public class StringSchema<T> {
    private boolean required = false;
    private Integer minLength;
    private String contains;

    public StringSchema<T> required() {
        required = true;
        return this;
    }

    public StringSchema<T> minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema<T> contains(String substring) {
        contains = substring;
        return this;
    }

    public boolean isValid(T data) {
        if (data == null) {
            return !required;
        }

        if (data instanceof String) {
            String stringValue = (String) data;
            if (required && stringValue.isEmpty()) {
                return false;
            }

            if (minLength != null && stringValue.length() < minLength) {
                return false;
            }

            if (contains != null && !stringValue.contains(contains)) {
                return false;
            }

            return true;
        }

        return false;
    }
}