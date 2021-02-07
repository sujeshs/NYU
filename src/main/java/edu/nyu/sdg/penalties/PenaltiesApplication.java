package edu.nyu.sdg.penalties;

import edu.nyu.sdg.penalties.config.LookupData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PenaltiesApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(PenaltiesApplication.class, args);
		LookupData lookupData = ctx.getBean(LookupData.class);

		System.out.println("lookupData = " + lookupData);


	}

}
