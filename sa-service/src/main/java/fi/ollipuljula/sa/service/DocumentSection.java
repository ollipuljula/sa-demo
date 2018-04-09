package fi.ollipuljula.sa.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public enum DocumentSection {
    BASIC(DocumentField.FIRSTNAME, DocumentField.LASTNAME, DocumentField.AGE),
    CONTACT(DocumentField.PHONENUMBER, DocumentField.STREET_ADDRESS, DocumentField.ZIP_CODE, DocumentField.CITY);

    private Collection<DocumentField> fields;

    DocumentSection(DocumentField... documentFields) {
        this.fields = Arrays.asList(documentFields);
    }

    public Collection<DocumentField> getFields() {
        return Collections.unmodifiableCollection(fields);
    }
}
