package ru.elena.testwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    /**
     * postgres=# CREATE DATADASE testdb;
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class);
    }

}
