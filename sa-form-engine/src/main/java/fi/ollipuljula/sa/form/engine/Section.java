package fi.ollipuljula.sa.form.engine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@JsonRootName("section")
public abstract class Section<T, U> {

    private List<Field<T, U>> fields;

    public Section(Field<T, U>... fields) {
        this.fields = Arrays.asList(fields);
    }

    @JsonProperty("id")
    public abstract Long getId();

    @JsonProperty("name")
    public abstract String getName();

    @JsonProperty("fields")
    public List<Field<T, U>> getFields() {
        return Collections.unmodifiableList(this.fields);
    }

}
