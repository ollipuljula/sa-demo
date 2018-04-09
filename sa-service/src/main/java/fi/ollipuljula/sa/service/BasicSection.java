package fi.ollipuljula.sa.service;

import fi.ollipuljula.sa.form.engine.Field;
import fi.ollipuljula.sa.form.engine.Section;

public class BasicSection <T, U> extends Section<T, U> {
    public BasicSection(Field<T, U>... fields) {
        super(fields);
    }

    @Override
    public Long getId() {
        return 1L;
    }

    @Override
    public String getName() {
        return "basicSection";
    }
}
