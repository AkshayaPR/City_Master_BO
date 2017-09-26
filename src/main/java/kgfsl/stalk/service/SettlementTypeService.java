package kgfsl.stalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.SettlementTypeDO;
import kgfsl.stalk.repository.SettlementTypeRepository;

@Service
public class SettlementTypeService extends Base4EyeService<SettlementTypeDO, String> {

	@Autowired
	private SettlementTypeRepository repository;

	@Override
	public Base4EyeRepository<SettlementTypeDO, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(SettlementTypeDO model) throws CustomException {
		return false;
	}

}
