package kgfsl.stalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Exchange;
import kgfsl.stalk.entity.wrapper.ExchangeWrapper;
import kgfsl.stalk.service.ExchangeService;

@RestController
@RequestMapping("/master/exchange")
public class ExchangeController extends AbstractMasterController<Exchange, String> {

	@Autowired
	private ExchangeService service;

	@RequestMapping(value = "/getMainActive", method = RequestMethod.GET)
	public List<Exchange> getMainActive() throws Exception {
		return service.getActiveExchanges();
	}

	@Override
	public Base4EyeService<Exchange, String> getMCService() {
		return service;
	}

	@RequestMapping(value = "/exchangelist/getexchangecodeandnamelist", method = RequestMethod.GET)
	public List<ExchangeWrapper> getExchangeCodeAndNameList() throws Exception {
		return service.getExchangeWrapper();
	}

}
