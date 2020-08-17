/**
 * 
 */
package org.yelong.core.model.support.generator.impl.pojo;

import org.yelong.core.model.manage.FieldAndColumn;

/**
 * @since 2.0
 */
public class TModelField {

	private String primaryKey;
	
	private String name;
	
	private String mandatory;
	
	private String type;
	
	private String length;
	
	private String code;
	
	private String codePrefixUpperCase;

	private String columnAnnotation;
	
	private FieldAndColumn fieldAndColumn;
	
	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodePrefixUpperCase() {
		return codePrefixUpperCase;
	}

	public void setCodePrefixUpperCase(String codePrefixUpperCase) {
		this.codePrefixUpperCase = codePrefixUpperCase;
	}

	public String getColumnAnnotation() {
		return columnAnnotation;
	}

	public void setColumnAnnotation(String columnAnnotation) {
		this.columnAnnotation = columnAnnotation;
	}

	public FieldAndColumn getFieldAndColumn() {
		return fieldAndColumn;
	}

	public void setFieldAndColumn(FieldAndColumn fieldAndColumn) {
		this.fieldAndColumn = fieldAndColumn;
	}
	
}
