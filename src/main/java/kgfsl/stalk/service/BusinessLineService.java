package kgfsl.stalk.service;

import java.util.ArrayList;
import java.util.List;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.BusinessLine;
import kgfsl.stalk.entity.Exchange;
import kgfsl.stalk.entity.wrapper.BusinessLineWrapper;
import kgfsl.stalk.entity.wrapper.ExchangeWrapper;
import kgfsl.stalk.repository.BusinessLineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessLineService extends Base4EyeService<BusinessLine, String>{

	@Autowired
	private BusinessLineRepository repository;

	@Override
	public Base4EyeRepository<BusinessLine, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(BusinessLine model) throws CustomException {
		return model.getId() == 0 && repository.findByCode(model.getCode()) != null;
	}
	
	public List<BusinessLineWrapper> getBusinessLineWrapper() throws Exception {		
		List<BusinessLineWrapper> businessLineWrapper = new ArrayList<>();
		getActiveBusLine().stream().forEach(row -> {
			BusinessLineWrapper wrapper = new BusinessLineWrapper();
			wrapper.setCode(row.getCode());
			wrapper.setBuslLineShortName(row.getBuslLineShortName());
			businessLineWrapper.add(wrapper);
		});

		return businessLineWrapper;

	}

public List<BusinessLine> getActiveBusLine() {
	return repository.findByActive(true);
}
}
