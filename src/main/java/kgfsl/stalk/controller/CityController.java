package kgfsl.stalk.controller;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.City;
//import kgfsl.stalk.entity.Country;
import kgfsl.stalk.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geography/city")
public class CityController extends AbstractMasterController<City, String> {

	@Autowired
	private CityService service;

	@Override
	public Base4EyeService<City, String> getMCService() {
		return service;
	}
}