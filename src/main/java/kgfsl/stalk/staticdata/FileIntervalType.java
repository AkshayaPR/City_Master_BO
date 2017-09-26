package kgfsl.stalk.staticdata;

import java.util.Arrays;

public enum FileIntervalType {

	MONTHLY("MONTHLY"), WEEKLY("WEEKLY"), DAILY("DAILY"), NONE("NONE");

	private String value;

	FileIntervalType(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public static boolean Contains(String value) {
		return Arrays.asList(MONTHLY.getValue(), WEEKLY.getValue(),
				DAILY.getValue()).contains(value);
	}

}
