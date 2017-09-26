package kgfsl.stalk.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.State;
import kgfsl.stalk.entity.wrapper.StateWrapper;
import kgfsl.stalk.repository.StateRepository;

@Service
public class StateService  extends Base4EyeService<State, String>{

	@Autowired
	private StateRepository repository;
	
	@Override
	public Base4EyeRepository<State, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(State model) throws CustomException {
		return model.getId() == 0 && repository.findByCode(model.getCode()) != null;
	}

	public List<State> getActiveState() {
		return repository.findByActive(true);
	}

	public List<StateWrapper> getStateWrapper() throws Exception {
		List<StateWrapper> stateWrapper = new ArrayList<>();
		getActiveState().stream().forEach(row -> {
			StateWrapper wrapper = new StateWrapper();
			wrapper.setCode(row.getCode());
			wrapper.setName(row.getStatename());
			stateWrapper.add(wrapper);
		});
		return stateWrapper;
	}
	
}
