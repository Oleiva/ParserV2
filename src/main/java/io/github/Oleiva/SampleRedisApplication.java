package io.github.Oleiva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import io.github.oleiva.core.Parser;
import io.github.Oleiva.core.ParserCore;

@SpringBootApplication
public class SampleRedisApplication implements CommandLineRunner {


    @Autowired
    private ParserCore parserCore;

    public static void main(String[] args) throws Exception {
        // Close the context so it doesn't stay awake listening for core
        SpringApplication.run(SampleRedisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        long main_min = 1;
        long main_max = 100000;
        parserCore.Parse(main_min,main_max);

    }
}
