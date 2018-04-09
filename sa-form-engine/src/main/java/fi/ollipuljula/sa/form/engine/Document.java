package fi.ollipuljula.sa.form.engine;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName("document")
public interface Document {
    @JsonProperty("id")
    Long getId();

    @JsonProperty("name")
    String getName();

    @JsonProperty("sections")
    List<Section> getSections();
}
