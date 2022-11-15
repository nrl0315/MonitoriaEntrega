package edu.uco.montoria.monitoriaapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"edu.uco.monitoria"})
public class MonitoriaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoriaApiApplication.class, args);
    }

}
