package fi.ollipuljula.data;

import fi.ollipuljula.model.Field;
import fi.ollipuljula.model.Section;

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
