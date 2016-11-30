package fi.ollipuljula;

import fi.ollipuljula.bean.Kenttäsäännöt;
import fi.ollipuljula.bean.LasketutArvot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Kenttäsäännöt kenttäsäännöt() {
        return new Kenttäsäännöt();
    }

    @Bean
    public LasketutArvot lasketutArvot() {
        return new LasketutArvot();
    }
}
