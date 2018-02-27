package fi.ollipuljula.rest;

import fi.ollipuljula.UserEntityRepository;
import fi.ollipuljula.bean.CalculatedValues;
import fi.ollipuljula.data.DocumentFactory;
import fi.ollipuljula.data.DocumentField;
import fi.ollipuljula.data.DocumentSection;
import fi.ollipuljula.data.jpa.UserEntity;
import fi.ollipuljula.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ui")
@CrossOrigin(origins = "http://localhost:3000")
public class UiComponentController {

    @Autowired
    private DocumentFactory documentFactory;

    @Autowired
    private CalculatedValues calculatedValues;

    @RequestMapping("HaeDokumenttiosiot")
    public DokumenttiosiotResponse dokumenttiosiot() {
        return new DokumenttiosiotResponse();
    }

    /**
     *  @param dokumenttiosio DocumentSection enumin nimi
      */
    @RequestMapping("HaeDokumenttiosionKentat")
    public DokumenttiosioResponse dokumenttiosio(@RequestParam("avain") String dokumenttiosio) {
        return new DokumenttiosioResponse(DocumentSection.valueOf(dokumenttiosio).getFields());
    }

    // todo validointiin voi vaikuttaa muidenkin kenttien arvot
    /**
     *
     * @param dokumenttikenttä DocumentField enumin nimi
     * @param arvo Em. kentän arvo
     * @return
     */
    @RequestMapping("/ValidoiKentta")
    public boolean validoiDokumenttikenttä(@RequestParam("avain") String dokumenttikenttä, @RequestParam("arvo") String arvo) {
        DocumentField kenttä = DocumentField.valueOf(dokumenttikenttä);
        //return kenttäsäännöt.validoi(kenttä, arvo);
        return false;
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
    public String laskeArvo(@RequestParam("mihin") DocumentField mihinHalutaan,
                               @RequestParam("mista") DocumentField mistäHalutaan,
                               @RequestParam("arvo") String arvo) {
        //return this.calculatedValues.laske(mihinHalutaan, mistäHalutaan, arvo);
        return null;
    }

    @Autowired
    private UserEntityRepository userEntityRepository;

    @RequestMapping("/document/{id}")
    public Document getDocument(@PathVariable long id) {
        UserEntity one = userEntityRepository.findOne(id);
        if (one == null) {
            throw new RuntimeException("id'llä ei löydy");
        }
        return documentFactory.create(one);
    }

    @RequestMapping("/document/new")
    public Document createNewDocument() {
        return documentFactory.create(new UserEntity());
    }

    @RequestMapping("/document/search")
    public List<UserEntity> searchDocuments() {
        Iterable<UserEntity> all = userEntityRepository.findAll();
        ArrayList<UserEntity> documents = new ArrayList<>();
        all.forEach(documents::add);
        return documents;
    }

    @RequestMapping(path = "/document/validate", method = RequestMethod.POST)
    public Document validateDocument(@RequestBody UserEntity userEntity) {
        System.out.println(userEntity);
        return documentFactory.create(userEntity);
    }

    @RequestMapping(path = "/document/save", method = RequestMethod.POST)
    public Document saveDocument(@RequestBody UserEntity userEntity) {
        System.out.println("before: " + userEntity);
        UserEntity save = userEntityRepository.save(userEntity);
        System.out.println("after: " + userEntity);
        return documentFactory.create(save);
    }
}
