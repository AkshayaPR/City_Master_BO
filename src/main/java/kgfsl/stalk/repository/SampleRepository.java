package kgfsl.stalk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.Sample;

@Repository
public interface SampleRepository extends Base4EyeRepository<Sample, String> {

	Sample findByCode(String code);

	List<Sample> findByCodeIn(List<String> code);

}
