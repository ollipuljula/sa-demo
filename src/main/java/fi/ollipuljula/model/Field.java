package fi.ollipuljula.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by olli on 11/05/2017.
 */
public abstract class Field<T, U> {
    @JsonIgnore
    @Getter(AccessLevel.PROTECTED)
    private T domainObject;

    public Field(T domainObject) {
        this.domainObject = domainObject;
    }

    @JsonProperty("disabled")
    boolean isDisabled() {
        return false;
    };

    @JsonProperty("visible")
    boolean isVisible() {
        return true;
    };

    @JsonProperty("validationErrors")
    List<ValidationError> validate() {
        return new ArrayList<ValidationError>();
    };

    @JsonProperty("type")
    abstract Kenttätyyppi getKenttätyyppi();

    @JsonProperty("value")
    abstract U value();

    @JsonProperty("name")
    abstract String getName();
}
