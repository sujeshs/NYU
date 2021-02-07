package edu.nyu.sdg.penalties.config;

import edu.nyu.sdg.penalties.model.LookupData;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LookupConfig {

  @Bean
  @ConfigurationProperties(prefix = "lookup")
  LookupData lookupData() {
    return new LookupData();
  }
}
