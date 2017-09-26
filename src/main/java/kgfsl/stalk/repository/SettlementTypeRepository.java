package kgfsl.stalk.repository;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.SettlementTypeDO;

@Repository
public interface SettlementTypeRepository extends Base4EyeRepository<SettlementTypeDO, String> {

	//SettlementTypeDO findbySegCodeAndExchangeCodeAndSetlChkIndr(String segCode,String exchangeCode,String setlChkIndr);
}
