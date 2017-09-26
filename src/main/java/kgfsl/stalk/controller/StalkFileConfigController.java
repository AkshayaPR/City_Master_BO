package kgfsl.stalk.controller;

import kgfsl.genie.fileupload.spec.FileConfig;
import kgfsl.genie.makerchecker.Base4EyeController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.StalkFileConfig;
import kgfsl.stalk.service.StalkFileConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/master/fileconfig")
public class StalkFileConfigController extends Base4EyeController<StalkFileConfig, Long> {

	@Autowired
	private StalkFileConfigService service;

	@Override
	public Base4EyeService<StalkFileConfig, Long> getMCService() {
		return service;
	}

	@RequestMapping(value = "/findbycode", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public FileConfig findByCode(@RequestBody String code){
		return service.getByCode(code);
	}

}
