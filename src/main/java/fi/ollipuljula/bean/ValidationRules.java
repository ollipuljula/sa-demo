package fi.ollipuljula.bean;

import com.google.common.base.Predicate;

import java.util.Map;

abstract public class ValidationRules<T, U> {

    abstract public Map<T, Predicate<U>> getRules();

    public boolean validate(T type, U entity) {
        Predicate<U> predicate = getRules().get(type);
        return predicate.apply(entity);
    }

}
