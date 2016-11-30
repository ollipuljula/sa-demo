package fi.ollipuljula.rest;

import fi.ollipuljula.model.Dokumenttiosio;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;

public class DokumenttiosiotResponse {
    @Getter
    Collection<Dokumenttiosio> dokumenttiosiot = Arrays.asList(Dokumenttiosio.values());
}
