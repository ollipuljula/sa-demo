package fi.ollipuljula.bean;

import com.google.common.base.Predicate;
import fi.ollipuljula.model.Dokumenttikenttä;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Kenttäsäännöt {

    private Map<Dokumenttikenttä, Set<Predicate<String>>> säännöt = new HashMap<Dokumenttikenttä, Set<Predicate<String>>>();

    public Kenttäsäännöt() {
        HashSet<Predicate<String>> predikaatit = new HashSet<Predicate<String>>();
        predikaatit.add(new Predicate<String>() {
            @Override
            public boolean apply(String obj) {
                try {
                    Integer value = Integer.valueOf(obj);
                    return value > 0;
                } catch (NumberFormatException e) {}
                return false;
            }
        });

        säännöt.put(Dokumenttikenttä.IKA, predikaatit);
    }

    public boolean validoi(Dokumenttikenttä dokumenttikenttä, String arvo) {
        for (Predicate<String> predicate : this.säännöt.get(dokumenttikenttä)) {
            if(!predicate.apply(arvo)) {
                return false;
            };
        }
        return true;
    }
}
