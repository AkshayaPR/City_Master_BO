package kgfsl.stalk.entity;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.genie.validation.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "STM_MS_SETL_MAST_T")
@AuditColumn
@CustomTableName(name = "STM_MS_SETL_MAST_T")
@JsonInclude(Include.NON_NULL)
public class SettlementDO extends Base4EyeAuditColumnWise 
{

	/*@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}*/
	
	@CustomFieldName(name= "stmId")
	private long id;
	
	@CustomFieldName(name = "stmAuctionDate")
	private Date aucTradeDt;
	
	@CustomFieldName(name = "stmAucDlyOutDate")
	private Date auctSecPayout;
	
	@CustomFieldName(name = "stmAucDlyInDate")
	private Date auctSecPayin;
	
	@CustomFieldName(name = "stmAucPayInDate")
	private Date auctFundsPayin;
	
	@CustomFieldName(name = "stmAucPayOutDate")
	private Date auctFundsPayout;
	
	@CustomFieldName(name = "stmAucCmplInd")
	private String stmAucCmplInd;
	
	@CustomFieldName(name = "stmDlyInDate")
	private Date secPayin;
	
	@CustomFieldName(name = "stmDlyOutDate")
	private Date secPayout;
	
	@CustomFieldName(name = "stmExchCode")
	private String exchangeCode;
	
	@CustomFieldName(name = "stmFromDate")
	private Date startDt;
	
	@CustomFieldName(name = "stmNrmlCmplInd")
	private String stmNrmlCmplInd;
	
	@CustomFieldName(name = "stmOblCmplInd")
	private String stmOblCmplInd;
	
	@CustomFieldName(name = "stmOblDate")
	private Date oblgDt;
	
	@CustomFieldName(name = "stmPayInDate")
	private Date fundsPayin;
	
	@CustomFieldName(name = "stmPayOutDate")
	private Date fundsPayout;
	
	@CustomFieldName(name = "stmSetlNo")
	private String setlNo;
	
	@CustomFieldName(name = "stmSetlType")
	private String stmSetlType;
	
	@CustomFieldName(name = "stmSetlYear")
	private Long setlYr;
	
	@CustomFieldName(name = "stmToDate")
	private Date endDt;
	
	@CustomFieldName(name = "stmTradeProCmpl")
	private String stmTradeProCmpl;
	
	@CustomFieldName(name = "stmSellCmplStat")
	private String stmSellCmplStat;
	
	@CustomFieldName(name = "stmAucSellCmplStat")
	private String stmAucSellCmplStat;
	
	@CustomFieldName(name = "stmAucMrgSetlNo")
	private Long stmAucMrgSetlNo;
	
	@CustomFieldName(name = "stmAucMrgSetlYear")
	private Long stmAucMrgSetlYear;
	
	@CustomFieldName(name = "stmSgmtCode")
	private String segCode;
	
	@CustomFieldName(name = "stmBseDispYear")
	private String stmBseDispYear;	
	
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_AUC_DATE")
	public Date getAucTradeDt() {
		return aucTradeDt;
	}
	public void setAucTradeDt(Date aucTradeDt) {
		this.aucTradeDt = aucTradeDt;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_AUC_DLY_OUT_DATE")
	public Date getAuctSecPayout() {
		return auctSecPayout;
	}
	public void setAuctSecPayout(Date auctSecPayout) {
		this.auctSecPayout = auctSecPayout;
	}	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_AUC_DLY_IN_DATE")
	public Date getAuctSecPayin() {
		return auctSecPayin;
	}
	public void setAuctSecPayin(Date auctSecPayin) {
		this.auctSecPayin = auctSecPayin;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_AUC_PAY_IN_DATE")
	public Date getAuctFundsPayin() {
		return auctFundsPayin;
	}
	public void setAuctFundsPayin(Date auctFundsPayin) {
		this.auctFundsPayin = auctFundsPayin;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_AUC_PAY_OUT_DATE")
	public Date getAuctFundsPayout() {
		return auctFundsPayout;
	}
	public void setAuctFundsPayout(Date auctFundsPayout) {
		this.auctFundsPayout = auctFundsPayout;
	}
	
	@Column(name = "STM_AUC_SETL_CMPLD_INDR")
	public String getStmAucCmplInd() {
		return stmAucCmplInd;
	}
	public void setStmAucCmplInd(String stmAucCmplInd) {
		this.stmAucCmplInd = stmAucCmplInd;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_DLY_IN_DATE")
	public Date getSecPayin() {
		return secPayin;
	}
	public void setSecPayin(Date secPayin) {
		this.secPayin = secPayin;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_DLY_OUT_DATE")
	public Date getSecPayout() {
		return secPayout;
	}
	public void setSecPayout(Date secPayout) {
		this.secPayout = secPayout;
	}
	
	@Column(name = "STM_EXCH_CODE")
	public String getExchangeCode() {
		return exchangeCode;
	}
	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_FROM_DATE")
	public Date getStartDt() {
		return startDt;
	}
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	
	@Column(name = "STM_NRML_SETL_CMPLD_INDR")
	public String getStmNrmlCmplInd() {
		return stmNrmlCmplInd;
	}
	public void setStmNrmlCmplInd(String stmNrmlCmplInd) {
		this.stmNrmlCmplInd = stmNrmlCmplInd;
	}
	
	@Column(name = "STM_OBLGN_CMPLD_INDR")
	public String getStmOblCmplInd() {
		return stmOblCmplInd;
	}
	public void setStmOblCmplInd(String stmOblCmplInd) {
		this.stmOblCmplInd = stmOblCmplInd;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_OBLGN_DATE")
	public Date getOblgDt() {
		return oblgDt;
	}
	public void setOblgDt(Date oblgDt) {
		this.oblgDt = oblgDt;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_PAY_IN_DATE")
	public Date getFundsPayin() {
		return fundsPayin;
	}
	public void setFundsPayin(Date fundsPayin) {
		this.fundsPayin = fundsPayin;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_PAY_OUT_DATE")
	public Date getFundsPayout() {
		return fundsPayout;
	}
	public void setFundsPayout(Date fundsPayout) {
		this.fundsPayout = fundsPayout;
	}	
	
	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "STM_SETL_NO", nullable = false, updatable = false)
	@PrimaryKey(fieldName = "setlNo")
	public String getSetlNo() {
		return setlNo;
	}
	public void setSetlNo(String setlNo) {
		this.setlNo = setlNo;
	}
	
	@Column(name = "STM_SETL_TYPE")
	public String getStmSetlType() {
		return stmSetlType;
	}
	public void setStmSetlType(String stmSetlType) {
		this.stmSetlType = stmSetlType;
	}
	
	@Column(name = "STM_SETL_YEAR")
	public Long getSetlYr() {
		return setlYr;
	}
	public void setSetlYr(Long setlYr) {
		this.setlYr = setlYr;
	}
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "STM_TO_DATE")
	public Date getEndDt() {
		return endDt;
	}
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	
	@Column(name = "STM_TRD_PRO_CMPLD")
	public String getStmTradeProCmpl() {
		return stmTradeProCmpl;
	}
	public void setStmTradeProCmpl(String stmTradeProCmpl) {
		this.stmTradeProCmpl = stmTradeProCmpl;
	}
	
	@Column(name = "STM_SELL_SHTG_CMPLD_STAT")
	public String getStmSellCmplStat() {
		return stmSellCmplStat;
	}
	public void setStmSellCmplStat(String stmSellCmplStat) {
		this.stmSellCmplStat = stmSellCmplStat;
	}
	
	@Column(name = "STM_AUC_SELL_SHTG_CMPLD_STAT")
	public String getStmAucSellCmplStat() {
		return stmAucSellCmplStat;
	}
	public void setStmAucSellCmplStat(String stmAucSellCmplStat) {
		this.stmAucSellCmplStat = stmAucSellCmplStat;
	}
	
	@Column(name = "STM_AUC_MRG_WITH_SETL_NO")
	public Long getStmAucMrgSetlNo() {
		return stmAucMrgSetlNo;
	}
	public void setStmAucMrgSetlNo(Long stmAucMrgSetlNo) {
		this.stmAucMrgSetlNo = stmAucMrgSetlNo;
	}
	
	@Column(name = "STM_AUC_MRG_WITH_SETL_YEAR")
	public Long getStmAucMrgSetlYear() {
		return stmAucMrgSetlYear;
	}
	public void setStmAucMrgSetlYear(Long stmAucMrgSetlYear) {
		this.stmAucMrgSetlYear = stmAucMrgSetlYear;
	}
	
	@Column(name = "STM_SGMT_CODE")
	public String getSegCode() {
		return segCode;
	}
	public void setSegCode(String segCode) {
		this.segCode = segCode;
	}
	
	@Column(name = "STM_BSE_DISP_YEAR")
	public String getStmBseDispYear() {
		return stmBseDispYear;
	}
	public void setStmBseDispYear(String stmBseDispYear) {
		this.stmBseDispYear = stmBseDispYear;
	}
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("setlNo", getSetlNo());
		return uniqueValues;
	}
	

}
