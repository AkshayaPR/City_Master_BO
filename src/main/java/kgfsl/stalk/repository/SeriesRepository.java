package kgfsl.stalk.repository;


import org.springframework.stereotype.Repository;

import java.util.*;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.Series;

@Repository
public interface SeriesRepository extends Base4EyeRepository<Series, String> {
	
	Series findBySeriesCode(String seriesCode);
	
	List<Series> findBySeriesCodeIn(List<Series> seriescode);
	
	// List<Series> findByExchangeCodeAndSeriesCode(String exchangeCode, String seriesCode);
		
}
