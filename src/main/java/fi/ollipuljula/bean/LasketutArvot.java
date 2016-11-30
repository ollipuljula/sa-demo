package fi.ollipuljula.bean;

import fi.ollipuljula.model.Dokumenttikenttä;

public class LasketutArvot {

    public String laske(Dokumenttikenttä mihinHalutaan, Dokumenttikenttä mistäHalutaan, String arvo) {
        if(Dokumenttikenttä.IKA.equals(mihinHalutaan)) {
            if (Dokumenttikenttä.ETUNIMI.equals(mistäHalutaan) && "olli".equals(arvo)) {
                return "18";
            }
        }
        throw new RuntimeException("Arvo ei ole laskettavissa annetuilla parametreilla");
    }
}
