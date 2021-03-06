package edu.nyu.sdg.penalties.dao.postgres.impl;

import edu.nyu.sdg.penalties.dao.postgres.sql.LoadSql;
import edu.nyu.sdg.penalties.model.LL84FeedData;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

import static java.util.Objects.requireNonNull;

public final class GeneralQueriesPostgresImpl {

  private final JdbcTemplate template;

  public GeneralQueriesPostgresImpl(JdbcTemplate template) {
    this.template = requireNonNull(template, "template is required and missing.");
  }

  public Date getBBLGenerationDate(LL84FeedData ll84FeedData) {
    requireNonNull(ll84FeedData, "ll84FeedData is required and missing.");

    return template.queryForObject(LoadSql.CHECK_IF_BBL_EXISTS, new Object[]{ll84FeedData.getGenerationDate()}, Date.class);
  }
}
