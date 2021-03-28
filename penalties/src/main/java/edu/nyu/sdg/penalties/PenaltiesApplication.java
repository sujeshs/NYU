package edu.nyu.sdg.penalties;

import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import edu.nyu.sdg.penalties.inputstream.file.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PenaltiesApplication {

  private static final Logger LOG = LoggerFactory.getLogger(PenaltiesApplication.class);

  public static void main(String... args) throws Exception {

    ConfigurableApplicationContext ctx = SpringApplication.run(PenaltiesApplication.class, args);

    PACEDAO dataFromDB = ctx.getBean(PACEDAO.class);
    LOG.debug("energy coeff => " + dataFromDB.getEnergysrcGHCoeffData());
    LOG.debug("carbon limit => " + dataFromDB.getCarbonLimitData());
    LOG.debug("space occupancy => " + dataFromDB.getLL84SpaceOccupancyGrpData());
  }
}
