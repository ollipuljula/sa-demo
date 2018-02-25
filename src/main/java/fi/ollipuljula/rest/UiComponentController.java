package fi.ollipuljula.rest;

import fi.ollipuljula.EntiteettiRepository;
import fi.ollipuljula.bean.Kenttäsäännöt;
import fi.ollipuljula.bean.LasketutArvot;
import fi.ollipuljula.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ui")
@CrossOrigin(origins = "http://localhost:3000")
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

    @Autowired
    private EntiteettiRepository entiteettiRepository;

    @RequestMapping("/document/{id}")
    public Document getDocument(@PathVariable long id) {
        Entiteetti one = entiteettiRepository.findOne(id);
        if (one == null) {
            throw new RuntimeException("id'llä ei löydy");
        }
        return DocumentFactory.create(one);
    }

    @RequestMapping("/document/new")
    public Document createNewDocument() {
        return DocumentFactory.create(new Entiteetti());
    }

    @RequestMapping("/document/search")
    public List<Entiteetti> searchDocuments() {
        Iterable<Entiteetti> all = entiteettiRepository.findAll();
        ArrayList<Entiteetti> documents = new ArrayList<>();
        all.forEach(documents::add);
        return documents;
    }

    @RequestMapping(path = "/document/validate", method = RequestMethod.POST)
    public Document validateDocument(@RequestBody Entiteetti entiteetti) {
        System.out.println(entiteetti);
        return DocumentFactory.create(entiteetti);
    }

    @RequestMapping(path = "/document/save", method = RequestMethod.POST)
    public Document saveDocument(@RequestBody Entiteetti entiteetti) {
        System.out.println("before: " +entiteetti);
        Entiteetti save = entiteettiRepository.save(entiteetti);
        System.out.println("after: " +entiteetti);
        return DocumentFactory.create(save);
    }
}
