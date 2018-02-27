package fi.ollipuljula.data;

import fi.ollipuljula.bean.UserEntityCalculatedValues;
import fi.ollipuljula.bean.UserEntityValidationRules;
import fi.ollipuljula.data.jpa.UserEntity;
import fi.ollipuljula.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DocumentFactory {

    @Autowired
    private UserEntityCalculatedValues calculatedValues;

    @Autowired
    private UserEntityValidationRules validationRules;

    public Document create(UserEntity userEntity) {

        // BASIC

        Field<UserEntity, String> firstNameField = new Field<UserEntity, String>(userEntity) {
            @Override
            public String getValue() {
                return getDomainObject().getFirstName();
            }

            @Override
            public Type getType() {
                return DocumentField.FIRSTNAME;
            }
        };

        Field<UserEntity, String> lastNameField = new Field<UserEntity, String>(userEntity) {
            @Override
            public String getValue() {
                return getDomainObject().getLastName();
            }

            @Override
            public Type getType() {
                return DocumentField.LASTNAME;
            }
        };

        Field<UserEntity, Integer> ageField = new Field<UserEntity, Integer>(userEntity) {
            @Override
            public Integer getValue() {
                return (Integer) calculatedValues.calculate(getType(), userEntity);
            }

            @Override
            public Type getType() {
                return DocumentField.AGE;
            }

            @Override
            public List<ValidationError> validate() {
                List<ValidationError> errors = super.validate();

                boolean valid = validationRules.validate(getType(), userEntity);

                if(!valid) {
                    errors.add(new ValidationError(getType().getName(), "did not pass validation"));
                }

                return errors;
            }
        };

        BasicSection<UserEntity, String> basicSection = new BasicSection(firstNameField, lastNameField, ageField);

        // CONTACT

        Field<UserEntity, String> emailField = new Field<UserEntity, String>(userEntity) {
            @Override
            public String getValue() {
                return getDomainObject().getEmail();
            }

            @Override
            public Type getType() {
                return DocumentField.EMAIL;
            }
        };

        Field<UserEntity, String> phoneNumberField = new Field<UserEntity, String>(userEntity) {
            @Override
            public String getValue() {
                return getDomainObject().getPhoneNumber();
            }

            @Override
            public Type getType() {
                return DocumentField.PHONENUMBER;
            }
        };

        ContactSection contactSection = new ContactSection(emailField, phoneNumberField);

        // DOCUMENT

        return new Document() {
            @Override
            public Long getId() {
                return userEntity.getId();
            }

            @Override
            public String getName() {
                return "userDocument";
            }

            @Override
            public List<Section> getSections() {
                return Arrays.asList(basicSection, contactSection);
            }
        };
    }
}
