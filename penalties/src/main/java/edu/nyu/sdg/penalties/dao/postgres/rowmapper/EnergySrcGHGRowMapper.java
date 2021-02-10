package edu.nyu.sdg.penalties.dao.postgres.rowmapper;

import java.sql.ResultSet;

import com.google.common.collect.ImmutableMap;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Map;

public final class EnergySrcGHGRowMapper implements ResultSetExtractor<Map<String, BigDecimal>> {

  @Override
  public Map<String, BigDecimal> extractData(ResultSet rs)
      throws SQLException, DataAccessException {

    ImmutableMap.Builder mapBuilder = new ImmutableMap.Builder();

    while (rs.next()) {
      mapBuilder.put(rs.getString("energy_source"), rs.getBigDecimal("ghg_coefficient"));
    }

    return mapBuilder.build();
  }
}
