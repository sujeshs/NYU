package edu.nyu.sdg.penalties.dao.contract;

import edu.nyu.sdg.penalties.model.DerivedVariables;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import edu.nyu.sdg.penalties.model.NYCHAFeedData;

public interface SDGDataInsertDAO {

  void writePenaltyInfo(LL84FeedData ll84FeedData, DerivedVariables derivedVariables);

  void writeLL84Data(LL84FeedData ll84FeedData);

  void writeAcrisData(LL84FeedData ll84FeedData);

  void writeNYCHAData(NYCHAFeedData nychaFeedData);
}
