package kgfsl.stalk.repository;

import org.springframework.stereotype.Repository;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.stalk.entity.HolidayDO;

@Repository
public interface HolidayRepository extends Base4EyeRepository<HolidayDO, String> {

}
