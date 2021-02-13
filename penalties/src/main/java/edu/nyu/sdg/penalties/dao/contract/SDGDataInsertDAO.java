package edu.nyu.sdg.penalties.dao.contract;

import edu.nyu.sdg.penalties.model.DerivedVariables;
import edu.nyu.sdg.penalties.model.LL84FeedData;

public interface SDGDataInsertDAO {

  void writePenaltyInfo(LL84FeedData ll84FeedData, DerivedVariables derivedVariables);

  void writeLL84Data(LL84FeedData ll84FeedData);

  void writeAcrisData(LL84FeedData ll84FeedData);

}
