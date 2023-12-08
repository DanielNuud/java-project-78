package hexlet.code;

public final class StringSchema extends BaseSchema {
    public StringSchema required() {
        addCheck(
                "required",
                value -> value != null && (value instanceof String && !((String) value).isEmpty())
        );
        return this;
    }

    public StringSchema minLength(int length) {
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

}
