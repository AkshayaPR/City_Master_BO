package kgfsl.stalk.repository;

import java.util.List;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.BusinessLine;

import org.springframework.stereotype.Repository;

@Repository
public interface BusinessLineRepository extends Base4EyeRepository<BusinessLine, String> {
	
	BusinessLine findByCode(String code);

	List<BusinessLine> findByCodeIn(List<String> code);
	
	public long countByCode(String code);

}
