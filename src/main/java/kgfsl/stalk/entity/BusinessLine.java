package kgfsl.stalk.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.criteria.Searchable;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.genie.validation.PrimaryKey;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "SBL_EN_STC_BUS_LN_T")
@AuditColumn
@CustomTableName(name = "SBL_EN_STC_BUS_LN_T")
@JsonInclude(Include.NON_NULL)
public class BusinessLine extends Base4EyeAuditColumnWise{
	

	@Searchable
	@CustomFieldName(name = "BusinessLine_No")
	private String code;
	
	@CustomFieldName(name = "BusinessLine_ShortName")
	private String buslLineShortName;

	@CustomFieldName(name = "BusinessLine_Description")
	private String buslLineDescr;
	
	@CustomFieldName(name = "Depository_Code")
	private String depyCode;

	@CustomFieldName(name = "Exchange_Code")
	private String exchCode;

	@CustomFieldName(name = "Segment_Code")
	private String sgmtCode;

	@CustomFieldName(name = "CROrderCode")
	private String crOrcCode;

	@CustomFieldName(name = "DROrderCode")
	private String drOrdCode;

	@CustomFieldName(name = "BLGGrpCode")
	private String blgGrpCode;

	@CustomFieldName(name = "FOGroup")
	private String foGroup;

	public BusinessLine() {

	}
	
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}
	
	
	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "BusinessLine_No", nullable = false, updatable = false)
	@PrimaryKey(fieldName = "code")
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "Short_Name", nullable = false, length = 4)
	@NotNull(message = "Short_Name is mandatory")
	public String getBuslLineShortName() {
		return buslLineShortName;
	}

	public void setBuslLineShortName(String buslLineShortName) {
		this.buslLineShortName = buslLineShortName;
	}
	@Column(name = "BusinessLine_Description", nullable = false, length = 4)
	@NotNull(message = "Description is mandatory")
	public String getBuslLineDescr() {
		return buslLineDescr;
	}

	public void setBuslLineDescr(String buslLineDescr) {
		this.buslLineDescr = buslLineDescr;
	}
	
	@Column(name = "Depository_Code", nullable = false, length = 250)
	@NotNull(message = "Other System Code is mandatory")
	public String getDepyCode() {
		return depyCode;
	}

	public void setDepyCode(String depyCode) {
		this.depyCode = depyCode;
	}
		
	
	@Column(name = "Exchange_Code", nullable = false, length = 3)
	public String getExchCode() {
		return exchCode;
	}

	
	public void setExchCode(String exchCode) {
		this.exchCode = exchCode;
	}

	@Column(name = "Segment_Code")
	public String getSgmtCode() {
		return sgmtCode;
	}

	public void setSgmtCode(String sgmtCode) {
		this.sgmtCode = sgmtCode;
	}

	@Column(name = "CROrderCode")
	public String getCrOrcCode() {
		return crOrcCode;
	}

	public void setCrOrcCode(String crOrcCode) {
		this.crOrcCode = crOrcCode;
	}
	
	@Column(name = "DROrderCode")
	public String getDrOrdCode() {
		return drOrdCode;
	}

	
	public void setDrOrdCode(String drOrdCode) {
		this.drOrdCode = drOrdCode;
	}

	@Column(name = "BLGGrpCode")
	public String getBlgGrpCode() {
		return blgGrpCode;
	}

	public void setBlgGrpCode(String blgGrpCode) {
		this.blgGrpCode = blgGrpCode;
	}

	@Column(name = "FOGroup")
	public String getFoGroup() {
		return foGroup;
	}

	public void setFoGroup(String foGroup) {
		this.foGroup = foGroup;
	}	
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("code", getCode());
		return uniqueValues;
	}

}
