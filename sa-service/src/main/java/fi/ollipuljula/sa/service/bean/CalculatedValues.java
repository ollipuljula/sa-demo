package fi.ollipuljula.sa.service.bean;

import com.google.common.base.Function;

import java.util.Map;

abstract public class CalculatedValues<T, U> {

    abstract public Map<T, Function<U, Object>> getRules();

    public Object calculate(T type, U entity) {
        Function<U, Object> function = getRules().get(type);
        return function.apply(entity);
    }
}
