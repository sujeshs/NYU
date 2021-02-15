package edu.nyu.sdg.penalties;

import edu.nyu.sdg.penalties.dao.contract.LookupDAO;
import edu.nyu.sdg.penalties.inputstream.file.NYCHAFileLoader;
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

    LookupDAO dataFromDB = ctx.getBean(LookupDAO.class);
    LOG.debug("energy coeff => " + dataFromDB.getEnergysrcGHCoeffData());
    LOG.debug("carbon limit => " + dataFromDB.getCarbonLimitData());
    LOG.debug("space occupancy => " + dataFromDB.getLL84SpaceOccupancyGrpData());

    /*    LL84CSVFileLoader ll84CSVFileLoader = ctx.getBean( LL84CSVFileLoader.class);
    // String ll84FeedData = "/Users/ssuku24/cas/personal/NYU/docs/samples/subset_ll84.csv";
    String ll84FeedData = "/Users/sujeshs/Documents/PACE/merged_ll84_parties.csv";
    ll84CSVFileLoader.loadCSV(ll84FeedData);*/

    NYCHAFileLoader nychaFileLoader = ctx.getBean(NYCHAFileLoader.class);
    String nychaFeedData = "/Users/sujeshs/Documents/PACE/nycha-bbls.csv";
    nychaFileLoader.loadCSV(nychaFeedData);
  }
}
