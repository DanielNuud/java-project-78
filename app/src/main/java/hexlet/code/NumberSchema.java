package hexlet.code;

public final class NumberSchema extends BaseSchema {
    public NumberSchema required() {
        addCheck(
                "required",
                value -> value != null
        );
        return this;
    }

    public NumberSchema positive() {
        addCheck(
                "positive",
                value -> value == null || (value instanceof Integer && (int) value > 0)
        );
        return this;
    }

    public NumberSchema range(int min, int max) {
        addCheck(
                "range",
                value -> value == null || ((int) value >= min && (int) value <= max)
        );
        return this;
    }
}
