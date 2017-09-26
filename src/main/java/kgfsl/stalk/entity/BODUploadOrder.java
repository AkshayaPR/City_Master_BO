package kgfsl.stalk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.makerchecker.Base4EyeAuditColumnWise;
import kgfsl.genie.makerchecker.specification.AuditColumn;
import kgfsl.stalk.staticdata.FileIntervalType;
import kgfsl.stalk.staticdata.FileProcessType;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@AuditColumn
@Table(name = "BOD_UPOLAD_ORDER")
@JsonInclude(Include.NON_NULL)
public class BODUploadOrder extends Base4EyeAuditColumnWise {

	private StalkFileConfig fileConfig;

	private BODConfig bodConfig;

	private int uploadOrder;

	private String code;

	private String buslineNo;
	
	@CustomFieldName(name="File Process Type")
	private FileProcessType fileProcessType;
	
	@CustomFieldName(name="File Interval")
	private FileIntervalType fileInterval;

	@JsonIgnore
	@ManyToOne()
	@JoinColumns({ @JoinColumn(name = "BusinessLine_No", referencedColumnName = "BusinessLine_No", insertable = false, updatable = false),
			@JoinColumn(name = "FILE_PROCESS_TYPE", referencedColumnName = "FILE_PROCESS_TYPE", insertable = false, updatable = false),
			@JoinColumn(name = "FILE_INTERVAL", referencedColumnName = "FILE_INTERVAL", insertable = false, updatable = false) })
	public BODConfig getBodConfig() {
		return bodConfig;
	}

	public void setBodConfig(BODConfig bodConfig) {
		this.bodConfig = bodConfig;
	}

	public int getUploadOrder() {
		return uploadOrder;
	}

	public void setUploadOrder(int uploadOrder) {
		this.uploadOrder = uploadOrder;
	}

	@Id
	@Column(name = "FILE_CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne
	@JoinColumn(name = "FILE_CODE", referencedColumnName = "CODE", insertable = false, updatable = false)
	@BatchSize(size = 100)
	public StalkFileConfig getFileConfig() {
		return fileConfig;
	}

	public void setFileConfig(StalkFileConfig fileConfig) {
		this.fileConfig = fileConfig;
	}

	@Override
	@Generated(GenerationTime.INSERT)
	@Column(updatable = false, unique = true)
	public long getId() {
		return id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "FILE_PROCESS_TYPE")
	public FileProcessType getProcessType() {
		return fileProcessType;
	}

	public void setProcessType(FileProcessType processType) {
		this.fileProcessType = processType;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FILE_INTERVAL")
	public FileIntervalType getFileInterval() {
		return fileInterval;
	}

	public void setFileInterval(FileIntervalType fileInterval) {
		this.fileInterval = fileInterval;
	}

	public String getBuslineNo() {
		return buslineNo;
	}

	public void setBuslineNo(String buslineNo) {
		this.buslineNo = buslineNo;
	}

	public FileProcessType getFileProcessType() {
		return fileProcessType;
	}

	public void setFileProcessType(FileProcessType fileProcessType) {
		this.fileProcessType = fileProcessType;
	}

}
