package hexlet.code;

import hexlet.code.schemas.StringSchema;

public class Main {
    public static void main(String[] args) {
        Validator v = new Validator();
        StringSchema schema = v.string();

        System.out.println(schema.isValid(null));
        schema.required();

        System.out.println(schema.isValid(null));


    }
}
