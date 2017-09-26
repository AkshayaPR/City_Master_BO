package kgfsl.stalk.entity;

import java.text.SimpleDateFormat;
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

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.criteria.Searchable;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.genie.validation.AlphaNumericWithSpecialHyphen;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "FYM_MS_FINCL_YEAR_MAST_T")
@AuditColumn
@CustomTableName(name = "FYM_MS_FINCL_YEAR_MAST_T")
@JsonInclude(Include.NON_NULL)
public class FinancialYearDO extends Base4EyeAuditColumnWise {	
	
	private long id;
	
	@CustomFieldName(name = "FinancialYrName")
	private String financialYrName;		

	@CustomFieldName(name = "From Date")
	private Date fromDate;

	@CustomFieldName(name = "To Date")
	private Date toDate;
	
	private String finAmcInd;
	
	@Id
	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}
	
	public void setId(long id){
		this.id=id;
	}
		
	@Column(name = "FYM_FINCL_YEAR_NAME", nullable = false, updatable = false)
	@AlphaNumericWithSpecialHyphen(message = "CalendarYear Code can contain only alphanumeric with Special Hyphen characters", isBlankOrNullValid = false)
	public String getFinancialYrName() {
		return financialYrName;
	}

	public void setFinancialYrName(String financialYrName) {
		this.financialYrName = financialYrName;
	}

	@Column(name = "FYM_START_DATE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.DATE)
	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@Column(name = "FYM_END_DATE", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "IST")
	@Temporal(TemporalType.DATE)
	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	
	@Column(name = "FYM_AMC_INDR")
	public String getFinAmcInd() {
		return finAmcInd;
	}

	public void setFinAmcInd(String finAmcInd) {
		this.finAmcInd = finAmcInd;
	}
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Map<String, String> uniqueValues = new HashMap<>();			
		uniqueValues.put("From Date", dateFormat.format(getFromDate()));
		uniqueValues.put("To Date", dateFormat.format(getFromDate()));
		return uniqueValues;
	}
}