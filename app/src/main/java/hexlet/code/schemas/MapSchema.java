package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addCheck(
                "required",
                value -> value instanceof Map && !((Map) value).isEmpty() || value != null
        );
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                value -> value == null || ((Map) value).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                value -> value instanceof Map &&
                        schemas.entrySet().stream()
                                .allMatch(e -> e.getValue().isValid(((Map) value).get(e.getKey())))
        );
        return this;
    }
}
