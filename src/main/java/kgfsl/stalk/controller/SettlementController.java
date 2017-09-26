package kgfsl.stalk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kgfsl.genie.makerchecker.AbstractMasterController;
import kgfsl.genie.makerchecker.Base4EyeService;
import kgfsl.stalk.entity.SettlementDO;
import kgfsl.stalk.entity.SettlementTypeDO;
import kgfsl.stalk.service.SettlementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/settlement/settlement")
public class SettlementController extends AbstractMasterController<SettlementDO, String> {
	
	@Autowired
	private SettlementService settlementService;

	@Override
	public Base4EyeService<SettlementDO, String> getMCService() {
		return settlementService;
	}
	
	@RequestMapping(value = "/getExpDate", method = RequestMethod.POST)
	@ResponseBody public String fetchSettlementDataBySegCode(@RequestBody Map<String, String> fileMap) {
		String expDate = "";
		SettlementDO settlementData = new SettlementDO();
		try {
			settlementData = settlementService.fetchSettlementDataBySegCode(fileMap.get("segCode"),fileMap.get("exchangeCode"));
			expDate = settlementData.getEndDt().toString(); 
		} catch(Exception e) {
			
		}		
		return expDate;
	}
	
	@RequestMapping(value = "/getSetlTypeData", method = RequestMethod.POST)
	@ResponseBody public SettlementTypeDO fetchSettlementTypeData(@RequestBody Map<String, String> fileMap) {
		SettlementTypeDO settlementData = new SettlementTypeDO();
		try {
			//settlementData = settlementService.fetchSettlementTypeData(fileMap.get("segCode"),fileMap.get("exchangeCode"),"Y");
		} catch(Exception e) {
			
		}		
		return settlementData;
	}
	
	@RequestMapping(value = "/saveSettlementData", method = RequestMethod.POST)
	@ResponseBody public String saveSettlementData(@RequestBody SettlementDO settlementDO) {
		String result = "Success";
		List<SettlementDO> settlementData = new ArrayList<SettlementDO>();
		SettlementDO rollingSettlement = new SettlementDO();
		try {
			rollingSettlement = settlementDO;
			rollingSettlement.setStmSetlType("2");
			rollingSettlement.setStmAucCmplInd("");
			rollingSettlement.setAucTradeDt(null);
			rollingSettlement.setAuctSecPayin(null);
			rollingSettlement.setAuctSecPayout(null);
			rollingSettlement.setAuctFundsPayin(null);
			rollingSettlement.setAuctFundsPayout(null);
			rollingSettlement.setStmNrmlCmplInd("N");
			settlementDO.setStmSetlType("1");
			settlementDO.setStmAucCmplInd("N");
			settlementDO.setStmNrmlCmplInd("N");
			settlementData.add(rollingSettlement);
			settlementData.add(settlementDO);
			settlementService.save(settlementData,super.getFormId());
		} catch(Exception e) {
			
		}		
		return result;
	}

}
