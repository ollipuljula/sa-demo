package fi.ollipuljula.rest;

import fi.ollipuljula.data.DocumentField;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
public class DokumenttiosioResponse {
    @Getter
    Collection<DocumentField> dokumenttikentät;
}
