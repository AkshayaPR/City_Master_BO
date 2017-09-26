package kgfsl.stalk.entity.embeddedids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import kgfsl.genie.criteria.CustomFieldName;
import kgfsl.stalk.staticdata.FileIntervalType;
import kgfsl.stalk.staticdata.FileProcessType;
import kgfsl.stalk.validators.BusinessLine;

@Embeddable
public class BODConfig_Pk implements Serializable {

	private static final long serialVersionUID = 7285740935774370757L;

	private String buslineNo;
	
	@CustomFieldName(name="File Process Type")
	private FileProcessType fileProcessType;
	
	@CustomFieldName(name="File Interval")
	private FileIntervalType fileInterval;

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

	@Column(name = "BusinessLine_No")
	@BusinessLine
	public String getBuslineNo() {
		return buslineNo;
	}

	public void setBuslineNo(String buslineNo) {
		this.buslineNo = buslineNo;
	}
}
