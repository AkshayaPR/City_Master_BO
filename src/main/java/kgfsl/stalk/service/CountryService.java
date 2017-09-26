package kgfsl.stalk.service;

import java.util.ArrayList;
import java.util.List;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Country;
import kgfsl.stalk.entity.wrapper.CountryWrapper;
import kgfsl.stalk.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService extends Base4EyeService<Country, String>{

	@Autowired
	private CountryRepository repository;

	@Override
	public Base4EyeRepository<Country, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(Country model) throws CustomException {
		return model.getId() == 0 && repository.findByCode(model.getCode()) != null;
	}
	public List<Country> getActiveCountries() {
		return repository.findByActive(true);
	}

	public List<CountryWrapper> getCountryWrapper() throws Exception {

		List<CountryWrapper> countryWrapper = new ArrayList<>();
		getActiveCountries().stream().forEach(row -> {
			CountryWrapper wrapper = new CountryWrapper();
			wrapper.setCode(row.getCode());
			wrapper.setName(row.getCountryName());
			countryWrapper.add(wrapper);
		});

		return countryWrapper;
}
}