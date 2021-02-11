package edu.nyu.sdg.penalties.dao.postgres.rowmapper;

import com.google.common.collect.ImmutableMap;
import edu.nyu.sdg.penalties.AppConstants;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public final class CarbonLimitRowMapper
    implements ResultSetExtractor<Map<String, Map<String, BigDecimal>>> {

  @Override
  public Map<String, Map<String, BigDecimal>> extractData(ResultSet rs)
      throws SQLException, DataAccessException {

    ImmutableMap.Builder mapBuilder = new ImmutableMap.Builder();

    while (rs.next()) {

      mapBuilder.put(
          rs.getString("occupancy_grp"),
          ImmutableMap.of(
              AppConstants.PHASE1,
              rs.getBigDecimal("carbon_limit_2024_2029"),
              AppConstants.PHASE2,
              rs.getBigDecimal("carbon_limit_2030_2034")));
    }

    return mapBuilder.build();
  }
}
