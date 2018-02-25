package fi.ollipuljula.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Dokumenttikenttä {
    ETUNIMI(Kenttätyyppi.TEXTFIELD),
    SUKUNIMI(Kenttätyyppi.TEXTFIELD),
    // voi käyttää annotaatioitakin tyyliin @Kokonaisluku, @MinValue(18), @MaxValue(65)
    // ja ottaa ne huomioon säännöissä
    IKA(Kenttätyyppi.NUMBER),
    PUHELINNUMERO(Kenttätyyppi.PHONENUMBER),
    KATUOSOITE(Kenttätyyppi.TEXTFIELD);

    @Getter
    private Kenttätyyppi tyyppi;

    // JSON serialisointia varten
    public String getNimi() {
        return this.name();
    }

    Dokumenttikenttä(Kenttätyyppi kenttätyyppi) {
        this.tyyppi = kenttätyyppi;
    }
}
