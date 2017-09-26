package kgfsl.stalk.repository;

import java.util.List;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.StalkFileConfig;
import kgfsl.stalk.staticdata.FileIntervalType;
import kgfsl.stalk.staticdata.FileProcessType;

public interface StalkFileConfigRepository extends Base4EyeRepository<StalkFileConfig, Long> {

	public StalkFileConfig findByCode(String code);

	List<StalkFileConfig> findByBuslineCodeAndFileProcessTypeAndFileInterval(String busline, FileProcessType processType, FileIntervalType fileInterval);

	public List<StalkFileConfig> findByCodeIn(Iterable<String> codes);

}
