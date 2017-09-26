package kgfsl.stalk.service;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.City;
import kgfsl.stalk.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService extends Base4EyeService<City, String> {
	
	@Autowired
	private CityRepository repository;

	@Override
	public Base4EyeRepository<City, String> getMainRepository() {
		return repository;
	}
	
	@Override
	public boolean findIfRecordExists(City model) throws CustomException {
		return model.getId() == 0 && repository.findByCityCode(model.getCityCode()) != null;
	}	
}