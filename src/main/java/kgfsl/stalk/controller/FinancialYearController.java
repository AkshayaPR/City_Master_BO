package kgfsl.stalk.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.FinancialYearDO;
import kgfsl.stalk.service.FinancialYearService;

@RestController
@RequestMapping("/settlement/financialyear")
public class FinancialYearController extends AbstractMasterController<FinancialYearDO,String>{

	@Autowired
	private FinancialYearService service;
	
	@Override
	public Base4EyeService<FinancialYearDO,String> getMCService() {
		return service;
	}	
	@RequestMapping(value = "/financialyear/getnextdate", method = RequestMethod.POST)
	public Map<String, String> getToDate(@RequestBody String finType) throws Exception {
		return service.getNextDate(finType);
	}
}
