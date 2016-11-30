package fi.ollipuljula.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public enum Dokumenttiosio {
    PERUSTIEDOT(Dokumenttikenttä.ETUNIMI, Dokumenttikenttä.SUKUNIMI, Dokumenttikenttä.IKA),
    YHTEYSTIEDOT(Dokumenttikenttä.PUHELINNUMERO, Dokumenttikenttä.KATUOSOITE);

    private Collection<Dokumenttikenttä> kentät;

    Dokumenttiosio(Dokumenttikenttä... dokumenttikentät) {
        this.kentät = Arrays.asList(dokumenttikentät);
    }

    public Collection<Dokumenttikenttä> getKentät() {
        return Collections.unmodifiableCollection(kentät);
    }
}
