package kgfsl.stalk.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.BODConfig;
import kgfsl.stalk.entity.BODUploadOrder;
import kgfsl.stalk.entity.StalkFileConfig;
import kgfsl.stalk.entity.embeddedids.BODConfig_Pk;
import kgfsl.stalk.repository.BODConfigRepository;
import kgfsl.stalk.staticdata.FileProcessType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BODConfigService extends Base4EyeService<BODConfig, BODConfig_Pk> {

	@Autowired
	private BODConfigRepository repository;

	@Autowired
	private StalkFileConfigService fileConfigService;

	@Override
	public Base4EyeRepository<BODConfig, BODConfig_Pk> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(BODConfig model) throws CustomException {

		if (model.getId() == 0) {
			if (repository.findByPrimaryKey(model.getPrimaryKey()) != null)
				return true;
		}
		return false;

	}

	public List<BODConfig> getBODWithLogDetails() throws Exception {

		return getBODConfigData();
	}

	public BODConfig getBODConfig(BODConfig config) {
		BODConfig_Pk primaryKey = config.getPrimaryKey();

		BODConfig bod = repository.findByPrimaryKey(primaryKey);

		List<StalkFileConfig> data = fileConfigService.findBy(primaryKey.getBuslineNo(),
				primaryKey.getFileProcessType(),primaryKey.getFileInterval());

		if (bod == null) {
			bod = config;
			List<BODUploadOrder> files = new ArrayList<>();
			bod.setUploadFiles(files);
		}

		Set<String> existFiles = bod.getUploadFiles().stream().map(m -> m.getCode()).collect(Collectors.toSet());

		Set<String> defaultFiles = data.stream().map(m -> m.getCode()).collect(Collectors.toSet());

		List<BODUploadOrder> modifiedList = bod.getUploadFiles().stream()
				.filter(f -> defaultFiles.contains(f.getCode())).collect(Collectors.toList());
		List<StalkFileConfig> newFiles = data.stream().filter(f -> !existFiles.contains(f.getCode()))
				.collect(Collectors.toList());

		List<BODUploadOrder> files = new ArrayList<>();
		Collections.sort(modifiedList, Comparator.comparing(BODUploadOrder::getUploadOrder));
		int order = modifiedList.isEmpty() ? 0 : modifiedList.get(modifiedList.size() - 1).getUploadOrder() + 1;
		for (StalkFileConfig row : newFiles) {
			if (!existFiles.contains(row.getCode())) {
				BODUploadOrder bodUploadOrder = new BODUploadOrder();
				bodUploadOrder.setCode(row.getCode());
				bodUploadOrder.setFileConfig(row);
				bodUploadOrder.setBuslineNo(row.getBuslineCode());
				bodUploadOrder.setProcessType(row.getFileProcessType());				
				bodUploadOrder.setUploadOrder(order);
				modifiedList.add(bodUploadOrder);
				order += 1;
			}
		}

		bod.getUploadFiles().clear();
		bod.setUploadFiles(modifiedList);

		bod.getUploadFiles().addAll(files);

		return bod;
	}

	private List<BODConfig> getBODConfigData() throws Exception {
		return repository.findByPrimaryKey_FileProcessType(FileProcessType.BOD);
	}

}