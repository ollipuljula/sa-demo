package fi.ollipuljula.sa.orm.dao;

import fi.ollipuljula.sa.orm.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
}
