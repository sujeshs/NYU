package edu.nyu.sdg.penalties.config;

import static java.util.Objects.requireNonNull;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import edu.nyu.sdg.penalties.dao.postgres.impl.PACEPostgresImpl;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@Profile("postgres")
public class PostgresConfig {

  @Bean
  @ConfigurationProperties(prefix = "db.postgres.hikari")
  HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  HikariDataSource postgresDataSource(HikariConfig hikariConfig) {
    requireNonNull(hikariConfig, "hikariConfig is required and missing.");
    return new HikariDataSource(hikariConfig);
  }

  @Bean
  JdbcTemplate postgresJdbcTemplate(DataSource postgresDataSource) {
    requireNonNull(postgresDataSource, "postgresDataSource is required and missing.");
    return new JdbcTemplate(postgresDataSource);
  }

  @Bean
  PACEDAO paceDAO(JdbcTemplate postgresJdbcTemplate) {
    requireNonNull(postgresJdbcTemplate, "postgresJdbcTemplate is required and missing.");
    return new PACEPostgresImpl(postgresJdbcTemplate);
  }
}
