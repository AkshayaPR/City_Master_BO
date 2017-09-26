package kgfsl.stalk.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import kgfsl.genie.criteria.CustomTableName;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.stalk.entity.embeddedids.BODConfig_Pk;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "BOD_CONFIG")
@CustomTableName(name = "BOD Config")
@AuditColumn
@JsonInclude(Include.NON_NULL)
public class BODConfig extends Base4EyeAuditColumnWise {

	private BODConfig_Pk primaryKey;

	private BusinessLine busline;

	private List<BODUploadOrder> uploadFiles;	

	@Generated(GenerationTime.INSERT)
	@Column(unique = true, updatable = false)
	public long getId() {
		return id;
	}

	@EmbeddedId
	public BODConfig_Pk getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(BODConfig_Pk primaryKey) {
		this.primaryKey = primaryKey;
	}

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "BusinessLine_No", referencedColumnName = "BusinessLine_No", insertable = false, updatable = false)
	public BusinessLine getBusline() {
		return busline;
	}

	public void setBusline(BusinessLine busline) {
		this.busline = busline;
	}
	
	@OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true)
	@JoinColumns({ @JoinColumn(name = "BusinessLine_No", referencedColumnName = "BusinessLine_No"),
			@JoinColumn(name = "FILE_PROCESS_TYPE", referencedColumnName = "FILE_PROCESS_TYPE"),
			@JoinColumn(name = "FILE_INTERVAL", referencedColumnName = "FILE_INTERVAL")})
	public List<BODUploadOrder> getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(List<BODUploadOrder> uploadFiles) {
		this.uploadFiles = uploadFiles;
	}
	
	@Override
	@Transient
	public Map<String, String> getUniqueValues() {
		Map<String, String> uniqueValues = new HashMap<>();
		uniqueValues.put("BusinessLine_No", getPrimaryKey().getBuslineNo());
		return uniqueValues;
	}

}
