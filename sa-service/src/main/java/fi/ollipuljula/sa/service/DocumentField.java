package fi.ollipuljula.sa.service;

import fi.ollipuljula.sa.form.engine.FieldType;
import fi.ollipuljula.sa.form.engine.Type;
import lombok.Getter;

public enum DocumentField implements Type {
    FIRSTNAME(FieldType.TEXTFIELD),
    LASTNAME(FieldType.TEXTFIELD),
    AGE(FieldType.NUMBER),
    PHONENUMBER(FieldType.PHONENUMBER),
    STREET_ADDRESS(FieldType.TEXTFIELD),
    ZIP_CODE(FieldType.TEXTFIELD),
    CITY(FieldType.TEXTFIELD),
    EMAIL(FieldType.EMAIL);

    @Getter
    private FieldType fieldType;

    public String getName() {
        return this.name();
    }

    DocumentField(FieldType fieldType) {
        this.fieldType = fieldType;
    }
}
