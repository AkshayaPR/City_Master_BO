package kgfsl.stalk.repository;

import java.util.List;
import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.FinancialYearDO;

@Repository
public interface FinancialYearRepository extends Base4EyeRepository<FinancialYearDO, String> {
	FinancialYearDO findByFinancialYrName(String code);
	List<FinancialYearDO> findByFinancialYrNameOrderByToDateDesc(String calType);	
}