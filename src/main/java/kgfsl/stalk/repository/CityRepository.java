package kgfsl.stalk.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.City;

@Repository
public interface CityRepository extends Base4EyeRepository<City, String> {

	City findByCityCode(String citycode);

	List<City> findByCityCodeIn(List<String> citycode);
}