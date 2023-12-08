package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    /**
     * Validates a string.
     *
     * @return a StringSchema for additional validation.
     */
    public StringSchema string() {
        return new StringSchema();
    }
    /**
     * Validates a number.
     *
     * @return a NumberSchema for additional validation.
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Validates a map.
     *
     * @return a MapSchema for additional validation.
     */
    public MapSchema map() {
        return new MapSchema();
    }

}
