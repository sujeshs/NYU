package edu.nyu.sdg.penalties.dao.contract;

import edu.nyu.sdg.penalties.model.DerivedVariables;
import edu.nyu.sdg.penalties.model.LL84Data;

public interface SDGDataInsertDAO {

  void writePenaltyInfo(LL84Data ll84Data, DerivedVariables derivedVariables);

  void writeLL84Data(LL84Data ll84Data);

}
