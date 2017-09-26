package kgfsl.stalk.controller;

import java.util.List;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Country;
import kgfsl.stalk.entity.wrapper.CountryWrapper;
import kgfsl.stalk.service.CountryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geography/country")
public class CountryController extends AbstractMasterController<Country, String>  {

	@Autowired
	private CountryService service;

	@Override
	public Base4EyeService<Country, String> getMCService() {
		return service;
	}
	@RequestMapping(value = "/countrylist/getCountryList", method = RequestMethod.GET)
	public List<CountryWrapper> getCountryList() throws Exception {
		return service.getCountryWrapper();
	}
}
