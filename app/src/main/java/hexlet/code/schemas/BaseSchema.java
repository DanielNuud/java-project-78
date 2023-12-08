package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema {
    protected Map<String, Predicate<Object>> checks = new LinkedHashMap<>();
    protected boolean required = false;

    protected final void addCheck(String name, Predicate<Object> validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(Object value) {
        if (required) {
            Predicate<Object> requiredCheck = checks.get("required");
            if (requiredCheck != null && !requiredCheck.test(value)) {
                return true;
            }
        }

        for (Predicate<Object> validate : checks.values()) {
            if (!validate.test(value)) {
                return false;
            }
        }

        return true;
    }
}
