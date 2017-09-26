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
@Table(name = "CMN_CNTRY_MAST_T")
@AuditColumn
@CustomTableName(name = "CMN_CNTRY_MAST_T")
@JsonInclude(Include.NON_NULL)
public class Country extends Base4EyeAuditColumnWise {
	
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}
	
	@Searchable
	@CustomFieldName(name = "Code")
	private String code;

	@CustomFieldName(name = "CountryName")
	private String countryName;

	@CustomFieldName(name = "OtherSysCode")
	private String othersystemcode;
	
	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "CountryCode", nullable = false, updatable = false)
	@PrimaryKey(fieldName = "code")
	public String getCode() {
		return code;
	}  
	
	public void setCode(String code) {
		this.code = code;
	}
	
	@Column(name = "CountryName", nullable = false, length = 250)
	@NotNull(message = "Country Name is mandatory")
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Column(name = "OtherSysCode", nullable = false, length = 250)
	@NotNull(message = "Other System Code is mandatory")
	public String getOthersystemcode() {
		return othersystemcode;
	}

	public void setOthersystemcode(String othersystemcode) {
		this.othersystemcode = othersystemcode;
	}
		
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("code", getCode());
		return uniqueValues;
	}	
}
