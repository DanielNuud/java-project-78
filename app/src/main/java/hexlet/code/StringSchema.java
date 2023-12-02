package hexlet.code;

public class StringSchema {
    private boolean required = false;
    private Integer minLength;
    private String contains;

    public StringSchema required() {
        required = true;
        return this;
    }

    public StringSchema minLength(int length) {
        minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        contains = substring;
        return this;
    }

    public boolean isValid(Object data) {
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