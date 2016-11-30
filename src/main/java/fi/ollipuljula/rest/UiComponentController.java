package fi.ollipuljula.rest;

import fi.ollipuljula.bean.Kenttäsäännöt;
import fi.ollipuljula.bean.LasketutArvot;
import fi.ollipuljula.model.Dokumenttikenttä;
import fi.ollipuljula.model.Dokumenttiosio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ui")
public class UiComponentController {

    @Autowired
    private Kenttäsäännöt kenttäsäännöt;

    @Autowired
    private LasketutArvot lasketutArvot;

    @RequestMapping("HaeDokumenttiosiot")
    public DokumenttiosiotResponse dokumenttiosiot() {
        return new DokumenttiosiotResponse();
    }

    /**
     *  @param dokumenttiosio Dokumenttiosio enumin nimi
      */
    @RequestMapping("HaeDokumenttiosionKentat")
    public DokumenttiosioResponse dokumenttiosio(@RequestParam("avain") String dokumenttiosio) {
        return new DokumenttiosioResponse(Dokumenttiosio.valueOf(dokumenttiosio).getKentät());
    }

    // todo validointiin voi vaikuttaa muidenkin kenttien arvot
    /**
     *
     * @param dokumenttikenttä Dokumenttikenttä enumin nimi
     * @param arvo Em. kentän arvo
     * @return
     */
    @RequestMapping("/ValidoiKentta")
    public boolean validoiDokumenttikenttä(@RequestParam("avain") String dokumenttikenttä, @RequestParam("arvo") String arvo) {
        Dokumenttikenttä kenttä = Dokumenttikenttä.valueOf(dokumenttikenttä);
        return kenttäsäännöt.validoi(kenttä, arvo);
    }

    // todo arvoon voi vaikuttaa useamman kentän arvo
    /**
     *
     * @param mihinHalutaan Mihin kenttään halutaan arvo
     * @param mistäHalutaan Minkä kentän perusteella arvo lasketaan
     * @param arvo Em. kentän arvo
     * @return
     */
    @RequestMapping("/HaeKentänLaskettuArvo")
    public String laskeArvo(@RequestParam("mihin") Dokumenttikenttä mihinHalutaan,
                               @RequestParam("mista") Dokumenttikenttä mistäHalutaan,
                               @RequestParam("arvo") String arvo) {
        return this.lasketutArvot.laske(mihinHalutaan, mistäHalutaan, arvo);
    }

}
