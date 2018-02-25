package fi.ollipuljula.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by olli on 11/05/2017.
 */
@AllArgsConstructor
@Getter
@Setter
public class ValidationError {
    private String key;
    private String description;
}
