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

import kgfsl.genie.core.utility.CustomException;
import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.criteria.Searchable;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.genie.validation.PrimaryKey;

@Entity
@Table(name = "SAMPLE_MASTER")
@AuditColumn
@CustomTableName(name = "SAMPLE_MASTER")
@JsonInclude(Include.NON_NULL)
public class Sample extends Base4EyeAuditColumnWise {

	@Searchable
	@CustomFieldName(name = "Code")
	private String code;

	@CustomFieldName(name = "Value")
	private String configValue;

	@CustomFieldName(name = "Description")
	private String description;

	public Sample() {

	}

	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}

	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "CODE", nullable = false, updatable = false)
	@PrimaryKey(fieldName = "code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "CONFIG_VALUE", nullable = false, length = 250)
	@NotNull(message = "Configuration Value is required!")
	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) throws CustomException {
		this.configValue = configValue;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 250)
	@NotNull(message = "Description is mandatory")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws CustomException {
		this.description = description;
	}

	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("code", getCode());
		return uniqueValues;

	}

}
