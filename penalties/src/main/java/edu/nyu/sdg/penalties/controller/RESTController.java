package edu.nyu.sdg.penalties.controller;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import edu.nyu.sdg.penalties.inputstream.file.LL84CSVFileLoader;
import edu.nyu.sdg.penalties.inputstream.file.NYCHAFileLoader;
import edu.nyu.sdg.penalties.inputstream.file.RentStabilizedFileLoader;
import edu.nyu.sdg.penalties.inputstream.file.SOANAFileLoader;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
public class RESTController {

  private final FlowOrchestrator flowOrchestrator;
  private final PACEDAO PACEDAO;
  private final LL84CSVFileLoader ll84CSVFileLoader;
  private final NYCHAFileLoader nychaFileLoader;
  private final SOANAFileLoader soanaFileLoader;
  private final RentStabilizedFileLoader rentStabilizedFileLoader;

  public RESTController(
      FlowOrchestrator flowOrchestrator,
      LL84CSVFileLoader ll84CSVFileLoader,
      NYCHAFileLoader nychaFileLoader,
      PACEDAO PACEDAO,
      SOANAFileLoader soanaFileLoader,
      RentStabilizedFileLoader rentStabilizedFileLoader) {
    this.flowOrchestrator =
        requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");
    this.ll84CSVFileLoader =
        requireNonNull(ll84CSVFileLoader, "ll84CSVFileLoader is required and missing.");
    this.nychaFileLoader =
        requireNonNull(nychaFileLoader, "nychaFileLoader is required and missing.");
    this.PACEDAO = requireNonNull(PACEDAO, " is required and missing.");
    this.soanaFileLoader =
        requireNonNull(soanaFileLoader, "soanaFileLoader is required and missing.");
    ;
    this.rentStabilizedFileLoader =
        requireNonNull(
            rentStabilizedFileLoader, "rentStabilizedFileLoader is required and missing.");
    ;
  }

  @PostMapping(path = "/load-penalty")
  public String loadPenalty() {
    List<LL84FeedData> ll84Records = PACEDAO.readLL84Data();
    ll84Records.forEach(ll84Data -> flowOrchestrator.calculatePenalties(ll84Data));

    return "penalty compute complete";
  }

  @PostMapping(path = "/load-ll84-acris", consumes = "text/plain")
  public String loadLL84AndAcris(@RequestBody String ll84AcrisFile) throws Exception {
    requireNonNull(ll84AcrisFile, "ll84AcrisFile is required and missing.");
    ll84CSVFileLoader.loadCSV(ll84AcrisFile);

    return "LL84 & Acris load complete";
  }

  @PostMapping(path = "/load-nycha", consumes = "text/plain")
  public String loadNYCHA(@RequestBody String nychaFile) throws Exception {
    requireNonNull(nychaFile, "nychaFile is required and missing.");
    nychaFileLoader.loadCSV(nychaFile);

    return "NYCHA load complete";
  }

  @PostMapping(path = "/load-soana", consumes = "text/plain")
  public String loadSOANA(@RequestBody String soanaFile) throws Exception {
    requireNonNull(soanaFile, "soanaFile is required and missing.");
    soanaFileLoader.loadCSV(soanaFile);

    return "SOANA load complete";
  }

  @PostMapping(path = "/load-rent-stablized-data", consumes = "text/plain")
  public String loadRentStabilizedData(@RequestBody String rentStabilizedDataFile)
      throws Exception {
    requireNonNull(rentStabilizedDataFile, "rentStabilizedDataFile is required and missing.");
    rentStabilizedFileLoader.loadCSV(rentStabilizedDataFile);

    return "Rent Stabilized Data load complete";
  }
}
