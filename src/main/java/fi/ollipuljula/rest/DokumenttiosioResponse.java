package fi.ollipuljula.rest;

import fi.ollipuljula.model.Dokumenttikenttä;
import fi.ollipuljula.model.Dokumenttiosio;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

@AllArgsConstructor
public class DokumenttiosioResponse {
    @Getter
    Collection<Dokumenttikenttä> dokumenttikentät;
}
