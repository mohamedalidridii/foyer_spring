package org.example.tpfoyer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class TpfoyerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpfoyerApplication.class, args);
    }

}
