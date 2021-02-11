package edu.nyu.sdg.penalties.dao.postgres.rowmapper;

import com.google.common.collect.ImmutableMap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.jdbc.core.ResultSetExtractor;

import static org.apache.commons.lang3.StringUtils.trim;

public final class OccupancySpaceUseRowMapper implements ResultSetExtractor<Map<String, String>> {

  @Override
  public Map<String, String> extractData(ResultSet rs) throws SQLException {

    ImmutableMap.Builder mapBuilder = new ImmutableMap.Builder();

    while (rs.next()) {
      mapBuilder.put(trim(rs.getString("space_use")), trim(rs.getString("occupancy_grp")));
    }

    return mapBuilder.build();
  }
}
