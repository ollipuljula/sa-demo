package fi.ollipuljula.data;

import fi.ollipuljula.model.Field;
import fi.ollipuljula.model.Section;

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
