package kgfsl.stalk.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name = "ESE_EN_STC_EXCH_T")
@CustomTableName(name = "Exchange")
@AuditColumn
@JsonInclude(Include.NON_NULL)
public class Exchange extends Base4EyeAuditColumnWise {

	@Searchable
	@CustomFieldName(name = "Code")
	private String code;

	@Searchable
	@CustomFieldName(name = "Name")
	private String name;

	//private List<ExchangeContact> exchangeContacts;

	public Exchange() {

	}

	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}

	@Id
	@Column(name="Exchange_Code", nullable = false, updatable = false)
	@PrimaryKey(message = "Exchange Code can contain only alphanumeric characters")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name="Exchange_Description", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("Code", getCode());
		return uniqueValues;
	}
		

}
