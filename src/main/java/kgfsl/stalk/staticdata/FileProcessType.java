package kgfsl.stalk.staticdata;

import java.util.Arrays;

public enum FileProcessType {

	BOD("BOD"), PATHCONFIG("PATHCONFIG"), RECON("RECON"), NONE("NONE");


	private String value;

	FileProcessType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
	
	public static boolean Contains(String value) {
		return Arrays.asList(BOD.getValue(), PATHCONFIG.getValue(),
				RECON.getValue(), NONE.getValue()).contains(value);
	}

}
