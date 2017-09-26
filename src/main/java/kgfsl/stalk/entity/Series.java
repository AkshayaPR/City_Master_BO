package kgfsl.stalk.entity;



import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.criteria.Searchable;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.genie.validation.PrimaryKey;

@Entity
@Table(name = "SSR_MS_SETL_SRS_LINK_T")
@AuditColumn
@CustomTableName(name = "SSR_MS_SETL_SRS_LINK_T")
@JsonInclude(Include.NON_NULL)
public class Series extends Base4EyeAuditColumnWise    {
	
	
	@Searchable
	@NotNull(message = "Series Code can contain only alphanumeric characters!")
	@CustomFieldName(name = "Series_Code")
	private String seriesCode;	
	
	//@NotNull(message = "Exchange Code can contain only alphanumeric characters!")
	@CustomFieldName(name = "Exchange_Code")
	private String exchangeCode;	
	
	@NotNull(message = "Settlement Type is required!")	
	@CustomFieldName(name = "Settlement_Type")
	private String setlType;	
	
	@CustomFieldName(name = "Auction Brokerage")
	private boolean autionBrokerageType;
		
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}	
	
	public Series() {

	}	
	
	@Column(name = "Auction_Brokerage_Type", nullable = false)
	public boolean isAutionBrokerageType() {
		return autionBrokerageType;
	}

	public void setAutionBrokerageType(boolean autionBrokerageType) {
		this.autionBrokerageType = autionBrokerageType;
	}
	
	@Id	
	@Generated(GenerationTime.INSERT)	
	@Column(name = "Series_Code", nullable = false, updatable = false)
	@PrimaryKey(fieldName = "seriesCode")
	@NotNull(message = "Series Code couldn't be null!")
	public String getSeriesCode() {
		return seriesCode;
	}
	
	public void setSeriesCode(String seriesCode) {
		this.seriesCode = seriesCode;
	}
	
	@Column(name = "Exchange_Code", nullable = false, updatable = false)
	public String getExchangeCode() {
		return exchangeCode;
	}

	public void setExchangeCode(String exchangeCode) {
		this.exchangeCode = exchangeCode;
	}
	
	@Column(name = "Settlement_Type", nullable = false)
	public String getSetlType() {
		return setlType;
	}



	public void setSetlType(String setlType) {
		this.setlType = setlType;
		}
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("seriesCode", getSeriesCode());
		return uniqueValues;

	}
	}