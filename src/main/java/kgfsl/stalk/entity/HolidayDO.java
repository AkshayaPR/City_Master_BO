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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.genie.validation.PrimaryKey;

@Entity
@Table(name = "HOM_MS_HOL_MAST_T")
@AuditColumn
@CustomTableName(name = "HOM_MS_HOL_MAST_T")
@JsonInclude(Include.NON_NULL)
public class HolidayDO extends Base4EyeAuditColumnWise {

	@CustomFieldName(name = "ID")
	private long id;	
	
	private Long businessLineNo;	
	
	@CustomFieldName(name= "holidayDate")
	private Date holidayDate;
		
	@CustomFieldName(name= "holidayDesc")
	private String holidayDesc;	
	
	@CustomFieldName(name= "isTradingHoliday")
	private String isTradingHoliday;
		
	@CustomFieldName(name= "isBankHoliday")
	private String isBankHoliday;
	
	@CustomFieldName(name= "isSetlHoliday")
	private String isSetlHoliday;
	
	@CustomFieldName(name= "isIntlHoliday")
	private String isIntlHoliday;
	
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)	
	public long getId() {
	  return id;
	}	

	@Column(name = "HOM_BUS_LN_NO")
	public Long getBusinessLineNo() {
		return businessLineNo;
	}

	public void setBusinessLineNo(Long businessLineNo) {
		this.businessLineNo = businessLineNo;
	}

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HOM_HOL_DATE")
	public Date getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "HOM_HOL_DESC", nullable = false, updatable = false)	
	@PrimaryKey(fieldName = "holidayDesc")
	public String getHolidayDesc() {
		return holidayDesc;
	}

	public void setHolidayDesc(String holidayDesc) {
		this.holidayDesc = holidayDesc;
	}

	@Column(name = "HOM_IS_TRADING")
	public String getIsTradingHoliday() {
		return isTradingHoliday;
	}

	public void setIsTradingHoliday(String isTradingHoliday) {
		this.isTradingHoliday = isTradingHoliday;
	}

	@Column(name = "HOM_IS_BANK")
	public String getIsBankHoliday() {
		return isBankHoliday;
	}

	public void setIsBankHoliday(String isBankHoliday) {
		this.isBankHoliday = isBankHoliday;
	}

	@Column(name = "HOM_IS_SETL")
	public String getIsSetlHoliday() {
		return isSetlHoliday;
	}

	public void setIsSetlHoliday(String isSetlHoliday) {
		this.isSetlHoliday = isSetlHoliday;
	}

	@Column(name = "HOM_IS_INTRL")
	public String getIsIntlHoliday() {
		return isIntlHoliday;
	}

	public void setIsIntlHoliday(String isIntlHoliday) {
		this.isIntlHoliday = isIntlHoliday;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("holidayDesc", getHolidayDesc());
		return uniqueValues;
	}

}
