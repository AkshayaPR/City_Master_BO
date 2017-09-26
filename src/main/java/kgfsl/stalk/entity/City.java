package kgfsl.stalk.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CMN_CITY_MAST_T")
@AuditColumn
@CustomTableName(name = "CMN_CITY_MAST_T")
@JsonInclude(Include.NON_NULL)
public class City  extends Base4EyeAuditColumnWise {
	
	@CustomFieldName(name = "Id")
	private long id;			
	
	@CustomFieldName(name = "Citycode")
	@Searchable
	private String cityCode;
	
	@CustomFieldName(name = "Cityname")
	@Searchable
	private String cityName;

	@CustomFieldName(name = "OtherSystemCode")
	private String otherSystemCode;
	
	public City() {
	}
	
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private Country country;	
	
	@ManyToOne
	@JoinColumn(name = "CountryCode", referencedColumnName = "CountryCode")
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	private State state;
	
	@ManyToOne
	@JoinColumn(name = "StateCode", referencedColumnName = "StateCode")
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Id
	@Generated(GenerationTime.INSERT)
	@Column(name = "CityCode",nullable=false,updatable=false)
	@PrimaryKey(fieldName = "cityCode")	
	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode)  {
		this.cityCode = cityCode;
	}

	@Column(name = "CityName")
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@Column(name = "OtherSystemCode", nullable = false)
    public String getOtherSystemCode() {
		return otherSystemCode;
	}
	public void setOtherSystemCode(String otherSystemCode) {
		this.otherSystemCode = otherSystemCode;
	}
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("code", getCityCode());
		return uniqueValues;
        }
}