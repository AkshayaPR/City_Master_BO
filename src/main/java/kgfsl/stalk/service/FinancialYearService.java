package kgfsl.stalk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kgfsl.genie.core.utility.CustomException;

import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.FinancialYearDO;
import kgfsl.stalk.repository.FinancialYearRepository;

@Service
public class FinancialYearService extends Base4EyeService<FinancialYearDO, String> {

	@Autowired
	private FinancialYearRepository repository;

	@Override
	public Base4EyeRepository<FinancialYearDO, String> getMainRepository() {
		return repository;
	}

	@Override
	public boolean findIfRecordExists(FinancialYearDO model) throws CustomException {		
		return false;
	}
	public Map<String, String> getNextDate(String calType) throws Exception {
		String FIN = "Financial Year";		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Map<String, String> map = new HashMap<>();
		List<FinancialYearDO> calendarYear = repository.findByFinancialYrNameOrderByToDateDesc(calType);
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();

		if (!calendarYear.isEmpty()) {
			Date nextDate = calendarYear.get(0).getToDate();
			fromDate.setTime(nextDate);			
		}

		toDate.setTime(fromDate.getTime());
		if (FIN.equals(calType)) {
			toDate.add(Calendar.YEAR, 1);

			fromDate.set(fromDate.get(Calendar.YEAR), 3, 1);
			toDate.set(toDate.get(Calendar.YEAR), 2, 1);
		}
		toDate.set(Calendar.DAY_OF_MONTH, toDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		int temp = fromDate.get(Calendar.YEAR);
		int toyear = toDate.get(Calendar.YEAR);
		int to = Integer.parseInt(Integer.toString(toyear).substring(1));
		
		map.put("fromDate", sdf.format(fromDate.getTime()));
		map.put("toDate", sdf.format(toDate.getTime()));		
		return map;

	}


}
