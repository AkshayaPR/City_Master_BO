package kgfsl.stalk.repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.SettlementDO;

import org.springframework.stereotype.Repository;

@Repository
public interface SettlementRepository extends Base4EyeRepository<SettlementDO, String> {

	SettlementDO findBySegCodeAndExchangeCodeOrderByEndDtDesc(String segCode,String exchange);	
}
