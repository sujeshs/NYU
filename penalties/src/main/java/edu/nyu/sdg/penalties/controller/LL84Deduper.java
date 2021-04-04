package edu.nyu.sdg.penalties.controller;

import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import edu.nyu.sdg.penalties.inputstream.file.LL84CSVFileLoader;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import java.time.Clock;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LL84Deduper {

  private static final Logger LOG = LoggerFactory.getLogger(LL84CSVFileLoader.class);

  private final Clock clock;
  private final PACEDAO paceDAO;

  public LL84Deduper(Clock clock, PACEDAO paceDAO) {
    this.clock = Objects.requireNonNull(clock, "clock is required and missing.");
    this.paceDAO = Objects.requireNonNull(paceDAO, " is required and missing.");
  }

  public void dedupeLL84s() {

    List<LL84FeedData> recordsToBePurged = new ArrayList<>();

    List<LL84FeedData> ll84Records = paceDAO.readLL84Data();

    Map<String, List<LL84FeedData>> ll84RecordsGroupedByPropertyId = new HashMap<>();
    ll84Records.forEach(
        ll84Record -> {
          String propertyId = ll84Record.getPropertyId();
          List<LL84FeedData> ll84sForPropertyId = ll84RecordsGroupedByPropertyId.get(propertyId);

          if (null == ll84sForPropertyId) {
            ll84sForPropertyId = new ArrayList<>();
            ll84sForPropertyId.add(ll84Record);
          } else {
            ll84sForPropertyId.add(ll84Record);
          }
          ll84sForPropertyId.sort(Comparator.comparing(LL84FeedData::getGenerationDate).reversed());
          ll84RecordsGroupedByPropertyId.put(propertyId, ll84sForPropertyId);
        });

    ll84RecordsGroupedByPropertyId.forEach(
        (key, value) -> {
          if (value != null && value.size() > 1) {
            for (int iter = 1; iter < value.size(); iter++) {
              recordsToBePurged.add(value.get(iter));
            }
          }
        });

    recordsToBePurged.forEach(record -> paceDAO.deleteLL84Data(record));

    LOG.info(
        "{}/{} purged because they were duplicates", recordsToBePurged.size(), ll84Records.size());
  }
}
