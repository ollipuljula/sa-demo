package fi.ollipuljula.sa.service.bean;

import com.google.common.base.Predicate;
import fi.ollipuljula.sa.form.engine.Type;
import fi.ollipuljula.sa.orm.entity.UserEntity;
import fi.ollipuljula.sa.service.DocumentField;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserEntityValidationRules extends ValidationRules<Type, UserEntity> {
    @Override
    public Map<Type, Predicate<UserEntity>> getRules() {
        Map<Type, Predicate<UserEntity>> rules = new HashMap<>();
        rules.put(DocumentField.AGE, userEntity -> false);

        return rules;
    }
}
