package fi.ollipuljula.bean;

import com.google.common.base.Predicate;
import fi.ollipuljula.data.DocumentField;
import fi.ollipuljula.data.jpa.UserEntity;
import fi.ollipuljula.model.Type;
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
