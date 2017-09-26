package kgfsl.stalk.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.genie.fileupload.spec.FileConfig;
import kgfsl.stalk.staticdata.FileIntervalType;
import kgfsl.stalk.staticdata.FileProcessType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("DOL_FILE_CONFIG")
public class StalkFileConfig extends FileConfig {

	private BusinessLine busline;
	
	@Column(name = "BusinessLine_No")
	public String getBuslineCode() {
		return buslineCode;
	}

	public void setBuslineCode(String buslineCode) {
		this.buslineCode = buslineCode;
	}

	@CustomFieldName(name="BusinessLine No")
	private String buslineCode;
	
	@CustomFieldName(name="File Process Type")
	private FileProcessType fileProcessType;
	
	@CustomFieldName(name="File Upload Interval")
	private FileIntervalType fileInterval;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "BusinessLine_No", referencedColumnName = "BusinessLine_No", insertable = false, updatable = false)
	public BusinessLine getBusline() {
		return busline;
	}

	public void setBusline(BusinessLine busline) {
		this.busline = busline;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FILE_PROCESS_TYPE")
	public FileProcessType getFileProcessType() {
		return fileProcessType;
	}

	public void setFileProcessType(FileProcessType fileProcessType) {
		this.fileProcessType = fileProcessType;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "FILE_INTERVAL")
	public FileIntervalType getFileInterval() {
		return fileInterval;
	}

	public void setFileInterval(FileIntervalType fileInterval) {
		this.fileInterval = fileInterval;
	}
	
}
