package kgfsl.stalk.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CMN_STATE_MAST_T")
@AuditColumn
@CustomTableName(name = "CMN_STATE_MAST_T")
@JsonInclude(Include.NON_NULL)
public class State extends Base4EyeAuditColumnWise {

	@Searchable
	private String code;

	@Searchable
	private String statename;

	private Country countrycode;

	@CustomFieldName(name = "othersystemcode")
	private String othersystemcode;

	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "StateCode", unique = true, updatable = false)
	@PrimaryKey(fieldName = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "StateName", nullable = false, length = 250)
	@NotNull(message = "State Name is mandatory")
	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	@ManyToOne
	@JoinColumn(name = "countryCode")
	public Country getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(Country countrycode) {
		this.countrycode = countrycode;
	}

	@Column(name = "OtherSystemCode", nullable = false, length = 250)
	@NotNull(message = "Other System Code is mandatory")
	public String getOthersystemcode() {
		return othersystemcode;
	}

	public void setOthersystemcode(String othersystemcode) {
		this.othersystemcode = othersystemcode;
	}

	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}

	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("code", getCode());
		return uniqueValues;

	}

}
