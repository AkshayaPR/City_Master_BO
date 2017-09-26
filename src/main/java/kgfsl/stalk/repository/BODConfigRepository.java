package kgfsl.stalk.repository;

import java.util.List;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.BODConfig;
import kgfsl.stalk.entity.embeddedids.BODConfig_Pk;
import kgfsl.stalk.staticdata.FileProcessType;

import org.springframework.stereotype.Repository;

@Repository
public interface BODConfigRepository extends Base4EyeRepository<BODConfig, BODConfig_Pk> {

	BODConfig findByPrimaryKey(BODConfig_Pk primaryKey);

	BODConfig findByPrimaryKey_BuslineNoAndPrimaryKey_FileProcessType(String busline,String processType);

	List<BODConfig> findByPrimaryKey_FileProcessType(FileProcessType processType);

}
