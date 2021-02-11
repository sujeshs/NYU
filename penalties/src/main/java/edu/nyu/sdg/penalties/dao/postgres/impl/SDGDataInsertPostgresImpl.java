package edu.nyu.sdg.penalties.dao.postgres.impl;

import edu.nyu.sdg.penalties.dao.contract.SDGDataInsertDAO;
import edu.nyu.sdg.penalties.dao.postgres.sql.DerivedVariablesSql;
import edu.nyu.sdg.penalties.model.DerivedVariables;
import edu.nyu.sdg.penalties.model.LL84Data;
import org.springframework.jdbc.core.JdbcTemplate;

public final class SDGDataInsertPostgresImpl implements SDGDataInsertDAO {

  private final JdbcTemplate template;

  public SDGDataInsertPostgresImpl(JdbcTemplate template) {
    this.template = template;
  }

  @Override
  public void writePenaltyInfo(LL84Data ll84Data, DerivedVariables derivedVariables) {
    template.update(DerivedVariablesSql.PUT_DERIVED_VARS_DATA,
      ll84Data.getBBL10Digits(),
      ll84Data.getNYCBIN(),
      derivedVariables.getCarbonLimits().getCarbonLimitPhase1(),
      derivedVariables.getCarbonLimits().getCarbonLimitPhase2(),
      derivedVariables.getTotalActualEmissions(),
      derivedVariables.getExcessEmissionPhase1(),
      derivedVariables.getExcessEmissionPhase2(),
      derivedVariables.getPenalties().getPhase1PenaltiesUSD(),
      derivedVariables.getPenalties().getPhase2PenaltiesUSD()
      );

  }
}
