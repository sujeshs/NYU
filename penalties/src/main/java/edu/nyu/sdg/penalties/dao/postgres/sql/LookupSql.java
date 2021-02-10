package edu.nyu.sdg.penalties.dao.postgres.sql;

public final class LookupSql {

  public static final String GET_ENERGYSRCGHCOEFF_DATA =
    "SELECT id, energy_source, ghg_coefficient, ghg_coefficient_unit FROM public.lookup_energy_src_ghg_coeff";

  public static final String GET_CARBONLIMIT_DATA =
    "SELECT id, occupancy_grp, space_use, carbon_limit_2024_2029, carbon_limit_2030_2034 FROM public.lookup_carbon_limit";

  public static final String GET_OCCUPANCY_SPACEUSE_DATA =
    "SELECT occupancy_grp, space_use FROM public.lookup_carbon_limit";

}
