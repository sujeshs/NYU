package edu.nyu.sdg.penalties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PenaltiesApplication {

  public static void main(String... args) throws Exception {

    ConfigurableApplicationContext ctx = SpringApplication.run(PenaltiesApplication.class, args);
  }
}
