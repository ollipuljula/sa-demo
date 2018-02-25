package fi.ollipuljula.model;

import java.util.*;

/**
 * Created by olli on 12/05/2017.
 */
public class DocumentFactory {
    public static Document create(Entiteetti entiteetti) {
        Field<Entiteetti, String> firstNameField = new Field<Entiteetti, String>(entiteetti) {
            @Override
            Kenttätyyppi getKenttätyyppi() {
                return Kenttätyyppi.TEXTFIELD;
            }

            @Override
            String value() {
                return getDomainObject().getFirstName();
            }

            @Override
            String getName() {
                return "firstName";
            }

            @Override
            boolean isDisabled() {
                return "Olli".equals(getDomainObject().getFirstName());
            }
        };

        Field<Entiteetti, String> lastNameField = new Field<Entiteetti, String>(entiteetti) {
            @Override
            Kenttätyyppi getKenttätyyppi() {
                return Kenttätyyppi.TEXTFIELD;
            }

            @Override
            String value() {
                return getDomainObject().getLastName();
            }

            @Override
            String getName() {
                return "lastName";
            }

            @Override
            List<ValidationError> validate() {
                if ("foobar".equals(getDomainObject().getLastName())) {
                    List<ValidationError> result = new ArrayList<ValidationError>();
                    result.add(new ValidationError("911", "virheellinen sukunimi"));
                    return result;
                }
                return null;
            }
        };

        final Part perustiedot = new Part(firstNameField, lastNameField) {
            @Override
            String getName() {
                return "Perustiedot";
            }
        };

        final Part yhteystiedot = new Part(new Field<Entiteetti, String>(entiteetti) {
            @Override
            Kenttätyyppi getKenttätyyppi() {
                return Kenttätyyppi.EMAIL;
            }

            @Override
            String value() {
                return getDomainObject().getEmail();
            }

            @Override
            String getName() {
                return "email";
            }
        }, new Field<Entiteetti, String>(entiteetti) {
            @Override
            Kenttätyyppi getKenttätyyppi() {
                return Kenttätyyppi.PHONENUMBER;
            }

            @Override
            String value() {
                return getDomainObject().getPhoneNumber();
            }

            @Override
            String getName() {
                return "phoneNumber";
            }

            @Override
            List<ValidationError> validate() {
                if ("foobar".equals(getDomainObject().getLastName())) {
                    List<ValidationError> result = new ArrayList<ValidationError>();
                    result.add(new ValidationError("112", "foobarilla ei voi olla puhelinnumeroa"));
                    return result;
                }
                return null;
            }
        }) {
            @Override
            String getName() {
                return "Yhteystiedot";
            }
        };

        final Part issue = new Part(new Field<Entiteetti, Date>(entiteetti) {
            @Override
            Kenttätyyppi getKenttätyyppi() {
                return Kenttätyyppi.DATE;
            }

            @Override
            Date value() {
                return getDomainObject().getContactRequestDate();
            }

            @Override
            String getName() {
                return "contactRequestDate";
            }
            @Override
            List<ValidationError> validate() {
                if ("foobar".equals(getDomainObject().getLastName())) {
                    List<ValidationError> result = new ArrayList<ValidationError>();
                    result.add(new ValidationError("112", "virheellinen pvm"));
                    return result;
                }
                return null;
            }
        }, new Field<Entiteetti, String>(entiteetti) {
            @Override
            Kenttätyyppi getKenttätyyppi() {
                return Kenttätyyppi.TEXTAREA;
            }

            @Override
            String value() {
                return getDomainObject().getIssue();
            }

            @Override
            String getName() {
                return "issue";
            }

        }) {
            @Override
            String getName() {
                return "Asia";
            }
        };

        return new Document() {
            @Override
            public Long getId() {
                return entiteetti.getId();
            }

            @Override
            public List<Part> getParts() {
                return Arrays.asList(perustiedot, yhteystiedot, issue);
            }
        };
    }
}
