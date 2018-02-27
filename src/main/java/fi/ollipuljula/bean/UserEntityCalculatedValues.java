package fi.ollipuljula.bean;

import com.google.common.base.Function;
import fi.ollipuljula.data.DocumentField;
import fi.ollipuljula.data.jpa.UserEntity;
import fi.ollipuljula.model.Type;
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
