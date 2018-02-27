package fi.ollipuljula;

import fi.ollipuljula.data.jpa.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserEntityRepository userEntityRepository;

    @PostConstruct
    public void seedTestData() {
        List<UserEntity> userEntities = Arrays.asList(
                new UserEntity(1L, "Olli", "Puljula", "olli.puljula@gmail.com", "12345"),
                new UserEntity(2L, "Foo", "Bar", "olli.puljula@gmail.com", "12345")
        );
        userEntityRepository.save(userEntities);
    }
}
