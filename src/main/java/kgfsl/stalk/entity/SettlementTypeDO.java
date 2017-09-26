package kgfsl.stalk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "EXS_EQ_EXCH_SETL_T")
@AuditColumn
@CustomTableName(name = "EXS_EQ_EXCH_SETL_T")
@JsonInclude(Include.NON_NULL)
public class SettlementTypeDO extends Base4EyeAuditColumnWise {

	private long id;
	
	private String exchangeCode;
	
	private String marketType;
	
	private String settlementName;
	
	private String settlementType;
	
	private String segCode;
	
	private String seriesCode;
	
	private String aucAvailIndr;
	
	private String oblFileAvailIndr;
	
	private String setlChkIndr;
	
	@Id
	@Override
	@Column(name = "ID")
	public long getId() {
	 return id;
	}	

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "Exchange_Code")
	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}

	@Column(name = "Market_Type")
	public String getMarketType() {
		return marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	@Column(name = "Settlement_Name")
	public String getSettlementName() {
		return settlementName;
	}

	public void setSettlementName(String settlementName) {
		this.settlementName = settlementName;
	}

	@Column(name = "Settlement_Type")
	public String getSettlementType() {
		return settlementType;
	}

	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}

	@Column(name = "Segment_Code")
	public String getSegCode() {
		return segCode;
	}

	public void setSegCode(String segCode) {
		this.segCode = segCode;
	}

	@Column(name = "Series_Code")
	public String getSeriesCode() {
		return seriesCode;
	}

	public void setSeriesCode(String seriesCode) {
		this.seriesCode = seriesCode;
	}
	
	@Column(name = "Auction_Avail_Indr")
	public String getAucAvailIndr() {
		return aucAvailIndr;
	}

	public void setAucAvailIndr(String aucAvailIndr) {
		this.aucAvailIndr = aucAvailIndr;
	}

	@Column(name = "Obligation_File_Avail_Indr")
	public String getOblFileAvailIndr() {
		return oblFileAvailIndr;
	}

	public void setOblFileAvailIndr(String oblFileAvailIndr) {
		this.oblFileAvailIndr = oblFileAvailIndr;
	}

	@Column(name = "Settlement_Check_Indr")
	public String getSetlChkIndr() {
		return setlChkIndr;
	}

	public void setSetlChkIndr(String setlChkIndr) {
		this.setlChkIndr = setlChkIndr;
	}

}
