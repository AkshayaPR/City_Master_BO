package kgfsl.stalk.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Segment;
import kgfsl.stalk.entity.Series;
import kgfsl.stalk.repository.SeriesRepository;

@Service
public class SeriesService extends Base4EyeService<Series, String> {
	
	@Autowired
	SeriesRepository seriesRepository;

	@Override
	public boolean findIfRecordExists(Series ety) throws CustomException {
		return ety.getId() == 0 && seriesRepository.findBySeriesCode(ety.getSeriesCode()) != null;
	}
	

	@Override
	public Base4EyeRepository<Series, String> getMainRepository() {
		return seriesRepository;
	}
	
	public Series findBySeriesCode() {
		return this.findBySeriesCode();
	}

}
