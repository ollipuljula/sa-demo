package fi.ollipuljula.model;

import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

/**
 * Created by olli on 12/05/2017.
 */
@JsonRootName("document")
public interface Document {
    Long getId();
    List<Part> getParts();
}
