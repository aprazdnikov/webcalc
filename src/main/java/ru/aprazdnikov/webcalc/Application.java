package ru.aprazdnikov.webcalc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan("ru.aprazdnikov.webcalc")
@ComponentScan("ru.aprazdnikov.api")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
