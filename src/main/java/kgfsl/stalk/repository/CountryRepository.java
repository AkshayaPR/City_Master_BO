package kgfsl.stalk.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.Country;

@Repository
public interface CountryRepository extends Base4EyeRepository<Country, String> {

	Country findByCode(String code);

	List<Country> findByCodeIn(List<String> code);

}
