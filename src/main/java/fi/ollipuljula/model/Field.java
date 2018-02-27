package fi.ollipuljula.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("field")
public abstract class Field<T, U> {
    @JsonIgnore
    @Getter(AccessLevel.PROTECTED)
    private T domainObject;

    public Field(T domainObject) {
        this.domainObject = domainObject;
    }

    @JsonProperty("disabled")
    public boolean isDisabled() {
        return false;
    };

    @JsonProperty("visible")
    public boolean isVisible() {
        return true;
    };

    @JsonProperty("validationErrors")
    public List<ValidationError> validate() {
        return new ArrayList<>();
    };

    @JsonProperty("fieldType")
    public FieldType getFieldType() {
        return getType().getFieldType();
    }

    @JsonProperty("value")
    public abstract U getValue();

    @JsonProperty("name")
    public String getName() {
        return getType().getName();
    }

    @JsonProperty("type")
    public abstract Type getType();
}
