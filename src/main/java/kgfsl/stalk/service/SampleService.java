package kgfsl.stalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Sample;
import kgfsl.stalk.repository.SampleRepository;

@Service
public class SampleService extends Base4EyeService<Sample, String> {

	@Autowired
	private SampleRepository repository;

	@Override
	public Base4EyeRepository<Sample, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(Sample model) throws CustomException {
		return model.getId() == 0 && repository.findByCode(model.getCode()) != null;
	}

}
