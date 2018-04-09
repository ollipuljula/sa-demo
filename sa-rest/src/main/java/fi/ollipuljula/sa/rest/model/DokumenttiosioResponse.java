package fi.ollipuljula.sa.rest.model;

import fi.ollipuljula.sa.service.DocumentField;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
public class DokumenttiosioResponse {
    @Getter
    Collection<DocumentField> dokumenttikentät;
}
