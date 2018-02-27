package fi.ollipuljula.rest;

import fi.ollipuljula.data.DocumentSection;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;

public class DokumenttiosiotResponse {
    @Getter
    Collection<DocumentSection> dokumenttiosiot = Arrays.asList(DocumentSection.values());
}
