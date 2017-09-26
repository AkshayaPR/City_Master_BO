package kgfsl.stalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.HolidayDO;
import kgfsl.stalk.repository.HolidayRepository;

@Service
public class HolidayService extends Base4EyeService<HolidayDO, String> {

	@Autowired
	private HolidayRepository holidayRepository;
	
	@Override
	public boolean findIfRecordExists(HolidayDO holiday) throws CustomException {
		return false;
	}

	@Override
	public Base4EyeRepository<HolidayDO, String> getMainRepository() {
		return holidayRepository;
	}

}
