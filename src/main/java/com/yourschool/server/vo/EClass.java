package com.yourschool.server.vo;

public enum EClass {

	NUSSERY("Nussery"), CLASS_I("Class I"), CLASS_II("Class II"), CLASS_III("Class III"), CLASS_IV("Class IV"),
	CLASS_V("Class V"), CLASS_VI("Class VI"), CLASS_VII("Class VII"), CLASS_VIII("Class VIII"), CLASS_IX("Class IX"),
	CLASS_X("Class X");

	private String value;

	public String getValue() {
		return this.value;
	}

	EClass(String value) {
		this.value = value;
	}
}
