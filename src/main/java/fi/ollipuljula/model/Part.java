package fi.ollipuljula.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by olli on 12/05/2017.
 */
public abstract class Part {
    @Getter(AccessLevel.PRIVATE)
    private List<Field> fields;

    public Part(Field... fields) {
        this.fields = Arrays.asList(fields);
    }

    @JsonProperty("name")
    abstract String getName();

    @JsonProperty("fields")
    List<Field> getFields() {
        return Collections.unmodifiableList(this.fields);
    }

}
