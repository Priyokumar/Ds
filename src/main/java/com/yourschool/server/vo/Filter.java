package com.yourschool.server.vo;

public class Filter {

	private String fieldPath;

	private Operator operator;

	private FieldType fieldType;

	private Object value;

	public Filter(String fieldPath, Operator operator, FieldType fieldType, Object value) {
		this.fieldPath = fieldPath;
		this.operator = operator;
		this.fieldType = fieldType;
		this.value = value;
	}

	public Filter() {
	}

	public String getFieldPath() {
		return fieldPath;
	}

	public void setFieldPath(String fieldPath) {
		this.fieldPath = fieldPath;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public FieldType getFieldType() {
		return fieldType;
	}

	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
