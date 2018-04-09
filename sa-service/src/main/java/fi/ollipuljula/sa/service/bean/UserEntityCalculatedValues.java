package fi.ollipuljula.sa.service.bean;

import com.google.common.base.Function;
import fi.ollipuljula.sa.form.engine.Type;
import fi.ollipuljula.sa.orm.entity.UserEntity;
import fi.ollipuljula.sa.service.DocumentField;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserEntityCalculatedValues extends CalculatedValues<Type, UserEntity> {
    @Override
    public Map<Type, Function<UserEntity, Object>> getRules() {
        Map<Type, Function<UserEntity, Object>> rules = new HashMap<>();
        rules.put(DocumentField.AGE, userEntity -> 18);
        return rules;
    }
}
