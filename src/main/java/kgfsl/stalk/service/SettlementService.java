package kgfsl.stalk.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.makerchecker.Base4EyeRepository;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.SettlementDO;
import kgfsl.stalk.entity.SettlementTypeDO;
import kgfsl.stalk.repository.SettlementRepository;
import kgfsl.stalk.repository.SettlementTypeRepository;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service
public class SettlementService extends Base4EyeService<SettlementDO, String> {

	@Autowired
	private SettlementRepository settlementRepository;
	
	@Autowired
	private SettlementTypeRepository settlementTypeRepository;
	
	@Inject
	public SettlementService(SettlementTypeRepository settlementTypeRepository) {
		this.settlementTypeRepository = settlementTypeRepository;
	}

	@Override
	public boolean findIfRecordExists(SettlementDO settlementDO)
			throws CustomException {
		return false;
	}

	@Override
	public Base4EyeRepository<SettlementDO, String> getMainRepository() {
		return settlementRepository;
	}	

	public SettlementDO fetchSettlementDataBySegCode(String segCode,
			String exchangeCode) {
		return settlementRepository
				.findBySegCodeAndExchangeCodeOrderByEndDtDesc(segCode,
						exchangeCode);
	}
	
	public SettlementTypeDO fetchSettlementTypeData(String segCode,String exchangeCode,String setlChkIndr) {
		//return settlementTypeRepository.findbySegCodeAndExchangeCodeAndSetlChkIndr(segCode, exchangeCode, setlChkIndr);
		return null;
	}

	// public void preApprove(List<SettlementDO> settlementDO) {
	// try {
	// for(SettlementDO settlement : settlementDO) {
	// settlementRepository.save(settlement);
	// }
	// }catch(Exception e) {
	//
	// }
	// }
		
	@Override
	public Long save(SettlementDO model, Long formId)
			throws JsonProcessingException, CustomException, JSONException {
		return super.save(model, formId);
	} 
	
	@Override
	public Long saveAsApproved(SettlementDO model, Long formId)
			throws JsonProcessingException, IllegalArgumentException,
			IllegalAccessException, ClassNotFoundException,
			InstantiationException, NoSuchFieldException, SecurityException,
			InvocationTargetException, IOException, JSONException,
			ParseException, CustomException {
		// TODO Auto-generated method stub
		return super.saveAsApproved(model, formId);
	}
	
	
	public void save(List<SettlementDO> settlementDO,Long formId) throws JsonProcessingException, JSONException, CustomException {
		for (SettlementDO settlement : settlementDO) {
			this.save(settlement,formId);
		}
	}

}
