package fi.ollipuljula;

import fi.ollipuljula.data.jpa.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
}
