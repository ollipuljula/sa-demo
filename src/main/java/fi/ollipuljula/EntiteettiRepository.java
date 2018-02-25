package fi.ollipuljula;

import fi.ollipuljula.model.Entiteetti;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by olli on 28/05/2017.
 */
public interface EntiteettiRepository extends CrudRepository<Entiteetti, Long> {
}
