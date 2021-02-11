package edu.nyu.sdg.penalties;

import edu.nyu.sdg.penalties.dao.contract.LookupDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PenaltiesApplication {

  public static void main(String... args) {

    ConfigurableApplicationContext ctx = SpringApplication.run(PenaltiesApplication.class, args);

    LookupDAO dataFromDB = ctx.getBean(LookupDAO.class);
    System.out.println("dataFromDB => " + dataFromDB.getEnergysrcGHCoeffData());
    System.out.println("dataFromDB => " + dataFromDB.getCarbonLimitData());
    System.out.println("dataFromDB => " + dataFromDB.getLL84SpaceOccupancyGrpData());
  }
}
