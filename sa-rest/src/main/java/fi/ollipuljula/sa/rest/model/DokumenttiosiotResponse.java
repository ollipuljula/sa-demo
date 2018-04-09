package fi.ollipuljula.sa.rest.model;

import fi.ollipuljula.sa.service.DocumentSection;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collection;

public class DokumenttiosiotResponse {
    @Getter
    Collection<DocumentSection> dokumenttiosiot = Arrays.asList(DocumentSection.values());
}
