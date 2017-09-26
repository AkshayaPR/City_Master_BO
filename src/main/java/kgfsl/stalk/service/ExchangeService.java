package kgfsl.stalk.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.Exchange;
import kgfsl.stalk.entity.wrapper.ExchangeWrapper;
import kgfsl.stalk.repository.ExchangeRepository;
import kgfsl.stalk.service.wrapper.IExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService extends Base4EyeService<Exchange, String> implements IExchangeService {

	@Autowired
	private ExchangeRepository repository;

	@Override
	public Base4EyeRepository<Exchange, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(Exchange model) throws CustomException {
		return model.getId() == 0 && repository.findByCode(model.getCode()) != null;
	}

	public List<Exchange> getActiveExchanges() {
		return repository.findByActive(true);
	}

	public Exchange findByCode(String code) {
		return this.findByCode(code);

	}

	@SuppressWarnings("unused")
	private Set<String> getSelectionColumns() {
		Set<String> columns = new HashSet<>();
		columns.add("name");
		columns.add("code");
		return columns;
	}

	public List<ExchangeWrapper> getExchangeWrapper() throws Exception {
		
		List<ExchangeWrapper> exchangeWrapper = new ArrayList<>();
		getActiveExchanges().stream().forEach(row -> {
			ExchangeWrapper wrapper = new ExchangeWrapper();
			wrapper.setCode(row.getCode());
			wrapper.setName(row.getName());
			exchangeWrapper.add(wrapper);
		});

		return exchangeWrapper;

	}

}
