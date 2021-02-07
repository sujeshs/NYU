package edu.nyu.sdg.penalties;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class AppConstants {

  public static final BigDecimal PENALTY_PER_TON = BigDecimal.valueOf(268);
  public static final NumberFormat CURRENCY_FORMAT = NumberFormat.getCurrencyInstance(Locale.US);
  public static final String PHASE1 = "2024-2029";
  public static final String PHASE2 = "2030-2034";
}
