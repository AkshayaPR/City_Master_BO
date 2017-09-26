package kgfsl.stalk.service;

import java.util.List;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.StalkFileConfig;
import kgfsl.stalk.repository.StalkFileConfigRepository;
import kgfsl.stalk.staticdata.FileIntervalType;
import kgfsl.stalk.staticdata.FileProcessType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StalkFileConfigService extends Base4EyeService<StalkFileConfig, Long> {

	@Autowired
	private StalkFileConfigRepository repository;

	@Override
	public Base4EyeRepository<StalkFileConfig, Long> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(StalkFileConfig model) throws CustomException {
		if (model.getId() == 0) {
			if (repository.findByCode(model.getCode()) != null)
				return true;
		}
		return false;
	}

	public StalkFileConfig getByCode(String code) {
		return repository.findByCode(code);
	}

	public List<StalkFileConfig> findBy(String busline, FileProcessType processType,
			FileIntervalType fileInterval) {
		return repository.findByBuslineCodeAndFileProcessTypeAndFileInterval(
				busline, processType, fileInterval);
	}

	public List<StalkFileConfig> findByCodeIn(Iterable<String> codes) {
		return repository.findByCodeIn(codes);
	}

}
