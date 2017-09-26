package kgfsl.stalk.controller;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.HolidayDO;
import kgfsl.stalk.service.HolidayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entity/holiday")
public class HolidayController extends AbstractMasterController<HolidayDO, String> {

	@Autowired
	HolidayService holidayService;
	
	@Override
	public Base4EyeService<HolidayDO, String> getMCService() {
		return holidayService;
	}

}
