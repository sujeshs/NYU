package edu.nyu.sdg.penalties.dao.postgres.rowmapper;

import com.google.common.collect.ImmutableMap;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public final class OccupancySpaceUseRowMapper implements ResultSetExtractor<Map<String, String>> {

  @Override
  public Map<String, String> extractData(ResultSet rs) throws SQLException, DataAccessException {

    ImmutableMap.Builder mapBuilder = new ImmutableMap.Builder();

    while (rs.next()) {
      mapBuilder.put(rs.getString("space_use"), rs.getString("occupancy_grp"));
    }

    return mapBuilder.build();
  }
}
