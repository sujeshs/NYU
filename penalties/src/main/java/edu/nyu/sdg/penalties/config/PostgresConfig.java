package edu.nyu.sdg.penalties.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class PostgresConfig {

  @Bean
  @ConfigurationProperties(prefix = "db.postgres.hikari")
  HikariConfig hikariConfig() {
    return new HikariConfig();
  }

  @Bean
  HikariDataSource postgresDataSource(HikariConfig hikariConfig) {
    return new HikariDataSource(hikariConfig);
  }

  @Bean
  JdbcTemplate postgresJdbcTemplate(DataSource postgresDataSource) {
    return new JdbcTemplate(postgresDataSource);
  }
}
