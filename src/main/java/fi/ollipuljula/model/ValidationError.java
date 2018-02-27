package fi.ollipuljula.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@JsonRootName("validationError")
public class ValidationError {
    @JsonProperty("key")
    private String key;

    @JsonProperty("message")
    private String message;
}
