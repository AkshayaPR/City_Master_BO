package kgfsl.stalk.controller;

import java.util.List;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.BusinessLine;
import kgfsl.stalk.entity.wrapper.BusinessLineWrapper;
import kgfsl.stalk.entity.wrapper.ExchangeWrapper;
import kgfsl.stalk.service.BusinessLineService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity/businessLine")
public class BusinessLineController extends AbstractMasterController<BusinessLine, String>  {

	@Autowired
	private BusinessLineService service;

	@Override
	public Base4EyeService<BusinessLine, String> getMCService() {
		return service;
	}
	
	@RequestMapping(value = "/businesslinelist/getbusinesslinelist", method = RequestMethod.GET)
	public List<BusinessLineWrapper> getbusinesslineList() throws Exception {
		return service.getBusinessLineWrapper();
	}

}
