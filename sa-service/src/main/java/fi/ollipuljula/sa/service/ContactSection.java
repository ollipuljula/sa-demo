package fi.ollipuljula.sa.service;

import fi.ollipuljula.sa.form.engine.Field;
import fi.ollipuljula.sa.form.engine.Section;

public class ContactSection<T, U> extends Section<T, U> {
    public ContactSection(Field<T, U>... fields) {
        super(fields);
    }

    @Override
    public Long getId() {
        return 2L;
    }

    @Override
    public String getName() {
        return "contactSection";
    }
}
