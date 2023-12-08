package hexlet.code.schemas;

import java.util.Map;

public final class MapSchema extends BaseSchema {
    public MapSchema required() {
        addCheck(
                "required",
                value -> value instanceof Map && !((Map<?, ?>) value).isEmpty() || value != null
        );
        return this;
    }


    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                value -> value == null || ((Map<?, ?>) value).size() == size
        );
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema> schemas) {
        addCheck(
                "shape",
                value -> {
                    if (value == null || !(value instanceof Map)) {
                        return false;
                    }

                    Map<?, ?> map = (Map<?, ?>) value;

                    for (Map.Entry<String, BaseSchema> entry : schemas.entrySet()) {
                        String key = entry.getKey();
                        BaseSchema schema = entry.getValue();

                        if (!map.containsKey(key) || !schema.isValid(map.get(key))) {
                            return false;
                        }
                    }

                    return true;
                }
        );
        return this;
    }
}
