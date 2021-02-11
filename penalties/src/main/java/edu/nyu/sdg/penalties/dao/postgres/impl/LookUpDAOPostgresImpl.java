package edu.nyu.sdg.penalties.dao.postgres.impl;

import static java.util.Objects.requireNonNull;

import edu.nyu.sdg.penalties.dao.contract.LookupDAO;
import edu.nyu.sdg.penalties.dao.postgres.rowmapper.CarbonLimitRowMapper;
import edu.nyu.sdg.penalties.dao.postgres.rowmapper.EnergySrcGHGRowMapper;
import edu.nyu.sdg.penalties.dao.postgres.rowmapper.OccupancySpaceUseRowMapper;
import edu.nyu.sdg.penalties.dao.postgres.sql.LookupSql;
import java.math.BigDecimal;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

public final class LookUpDAOPostgresImpl implements LookupDAO {

  private final EnergySrcGHGRowMapper energySrcGHGRowMapper;
  private final CarbonLimitRowMapper carbonLimitRowMapper;
  private final OccupancySpaceUseRowMapper occupancySpaceUseRowMapper;
  private final JdbcTemplate template;

  public LookUpDAOPostgresImpl(JdbcTemplate template) {
    carbonLimitRowMapper = new CarbonLimitRowMapper();
    energySrcGHGRowMapper = new EnergySrcGHGRowMapper();
    occupancySpaceUseRowMapper = new OccupancySpaceUseRowMapper();
    this.template = requireNonNull(template, "template is required and missing.");
  }

  @Override
  public Map<String, BigDecimal> getEnergysrcGHCoeffData() {
    return template.query(LookupSql.GET_ENERGYSRCGHCOEFF_DATA, energySrcGHGRowMapper);
  }

  @Override
  public Map<String, Map<String, BigDecimal>> getCarbonLimitData() {
    return template.query(LookupSql.GET_CARBONLIMIT_DATA, carbonLimitRowMapper);
  }

  @Override
  public Map<String, String> getLL84SpaceOccupancyGrpData() {
    return template.query(LookupSql.GET_OCCUPANCY_SPACEUSE_DATA, occupancySpaceUseRowMapper);
  }
}
