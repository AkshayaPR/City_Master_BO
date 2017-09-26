package kgfsl.stalk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Sample;
import kgfsl.stalk.service.SampleService;

@RestController
@RequestMapping("/exchngmaster/sample")
public class SampleController extends AbstractMasterController<Sample, String> {

	@Autowired
	private SampleService service;

	@Override
	public Base4EyeService<Sample, String> getMCService() {
		return service;
	}

}
