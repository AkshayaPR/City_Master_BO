package kgfsl.stalk.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.State;
import kgfsl.stalk.entity.wrapper.StateWrapper;
import kgfsl.stalk.service.StateService;

@RestController
@RequestMapping("/geography/state")
public class StateController extends AbstractMasterController<State, String>  {

	@Autowired
	private StateService service;

	@Override
	public Base4EyeService<State, String> getMCService() {
		return service;
	}
	
	@RequestMapping(value = "/statelist/getStateList", method = RequestMethod.GET)
	public List<StateWrapper> getStateList() throws Exception {
		return service.getStateWrapper();
	}
}
