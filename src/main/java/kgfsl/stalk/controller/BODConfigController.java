package kgfsl.stalk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.BODConfig;
import kgfsl.stalk.entity.embeddedids.BODConfig_Pk;
import kgfsl.stalk.service.BODConfigService;

@RestController
@RequestMapping("/bodconfig")
public class BODConfigController extends AbstractMasterController<BODConfig, BODConfig_Pk> {

	@Autowired
	private BODConfigService service;

	@Override
	public Base4EyeService<BODConfig, BODConfig_Pk> getMCService() {
		return service;
	}

	@RequestMapping(value = "/getBODView", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<BODConfig> view() throws Exception {
		return service.getBODWithLogDetails();
	}

	@RequestMapping(value = "/getNew", method = RequestMethod.POST)
	@ResponseBody
	public BODConfig getView(@RequestBody BODConfig config) throws Exception {
		return service.getBODConfig(config);
	}
}
