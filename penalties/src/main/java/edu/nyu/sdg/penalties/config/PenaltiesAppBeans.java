package edu.nyu.sdg.penalties.config;

import static java.util.Objects.*;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import edu.nyu.sdg.penalties.controller.CarbonLimitCalculator;
import edu.nyu.sdg.penalties.controller.EnergyConsumptionCalculator;
import edu.nyu.sdg.penalties.controller.FlowOrchestrator;
import edu.nyu.sdg.penalties.dao.contract.PACEDAO;
import edu.nyu.sdg.penalties.inputstream.file.*;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import edu.nyu.sdg.penalties.threadpool.BlockingThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Block;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class PenaltiesAppBeans {

  @Bean
  ExecutorService executorService(Environment env) {
    requireNonNull(env, "env is required and missing.");

    int threadPoolSize = env.getRequiredProperty("app.cpu.thread.pool.size", int.class);
    int threadPoolBlockingQSize = env.getRequiredProperty("app.cpu.thread.pool.blocking-queue-size", int.class);
    String threadPoolNameFormat = env.getRequiredProperty("app.cpu.thread.pool.executor-name-format");

    ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(
      new BlockingThreadPoolExecutor(threadPoolSize, threadPoolSize, 0L, TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<>(threadPoolBlockingQSize)));

    return listeningExecutorService;

  }

  @Bean
  FlowOrchestrator flowOrchestrator(
    CarbonLimitCalculator carbonLimitCalculator,
    EnergyConsumptionCalculator energyConsumptionCalculator,
    PACEDAO PACEDAO) {
    requireNonNull(carbonLimitCalculator, "carbonLimitCalculator is required and missing.");
    requireNonNull(
      energyConsumptionCalculator, "energyConsumptionCalculator is required and missing.");
    requireNonNull(PACEDAO, "sdgDataInsertDAO is required and missing.");

    return new FlowOrchestrator(carbonLimitCalculator, energyConsumptionCalculator, PACEDAO);
  }

  @Bean
  CarbonLimitCalculator carbonLimitCalculator(
    @Qualifier("carbon-limit") Map<String, Map<String, BigDecimal>> carbonLimitData,
    @Qualifier("occupancy-spaceuse") Map<String, String> occupancySpaceUseData) {
    requireNonNull(carbonLimitData, "carbonLimitData is required and missing.");
    requireNonNull(occupancySpaceUseData, "occupancySpaceUseData is required and missing.");

    return new CarbonLimitCalculator(carbonLimitData, occupancySpaceUseData);
  }

  @Bean
  EnergyConsumptionCalculator energyConsumptionCalculator(
    @Qualifier("energy-ghg-coeff") Map<String, BigDecimal> energysrcGHCoeffData) {
    requireNonNull(energysrcGHCoeffData, "energysrcGHCoeffData is required and missing.");

    return new EnergyConsumptionCalculator(energysrcGHCoeffData);
  }

  @Bean
  LL84CSVFileLoader ll84FileLoader(ExecutorService executorService, FlowOrchestrator flowOrchestrator) {
    requireNonNull(executorService, "executorService is required and missing.");
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new LL84CSVFileLoader(executorService, flowOrchestrator);
  }

  @Bean
  NYCHAFileLoader nychaFileLoader(ExecutorService executorService, FlowOrchestrator flowOrchestrator) {
    requireNonNull(executorService, "executorService is required and missing.");
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new NYCHAFileLoader(executorService, flowOrchestrator);
  }

  @Bean
  RentStabilizedFileLoader rentStabilizedFileLoader(ExecutorService executorService, FlowOrchestrator flowOrchestrator) {
    requireNonNull(executorService, "executorService is required and missing.");
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new RentStabilizedFileLoader(executorService, flowOrchestrator);
  }

  @Bean
  SOANAFileLoader soanaFileLoader(ExecutorService executorService, FlowOrchestrator flowOrchestrator) {
    requireNonNull(executorService, "executorService is required and missing.");
    requireNonNull(flowOrchestrator, "flowOrchestrator is required and missing.");

    return new SOANAFileLoader(executorService, flowOrchestrator);
  }
}
