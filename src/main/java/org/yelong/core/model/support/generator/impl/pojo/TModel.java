/**
 * 
 */
package org.yelong.core.model.support.generator.impl.pojo;

import java.util.List;

import org.yelong.core.model.support.generator.GModelAndTable;

/**
 * @since 2.0
 */
public class TModel {

	private String modelPackage;

	private String tableName;

	private String tableDesc;

	private String modelName;

	private String modelNamePrefixLowerCase;

	private String superClassName;

	private String superClassSimpleName;

	private List<TModelField> modelFields;

	private GModelAndTable gModelAndTable;

	private String author = System.getProperty("user.name");

	public String getModelPackage() {
		return modelPackage;
	}

	public void setModelPackage(String modelPackage) {
		this.modelPackage = modelPackage;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<TModelField> getModelFields() {
		return modelFields;
	}

	public void setModelFields(List<TModelField> modelFields) {
		this.modelFields = modelFields;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getModelNamePrefixLowerCase() {
		return modelNamePrefixLowerCase;
	}

	public void setModelNamePrefixLowerCase(String modelNamePrefixLowerCase) {
		this.modelNamePrefixLowerCase = modelNamePrefixLowerCase;
	}

	public String getTableDesc() {
		return tableDesc;
	}

	public void setTableDesc(String tableDesc) {
		this.tableDesc = tableDesc;
	}

	public GModelAndTable getgModelAndTable() {
		return gModelAndTable;
	}

	public void setgModelAndTable(GModelAndTable gModelAndTable) {
		this.gModelAndTable = gModelAndTable;
	}

	public String getSuperClassName() {
		return superClassName;
	}

	public void setSuperClassName(String superClassName) {
		this.superClassName = superClassName;
	}

	public String getSuperClassSimpleName() {
		return superClassSimpleName;
	}

	public void setSuperClassSimpleName(String superClassSimpleName) {
		this.superClassSimpleName = superClassSimpleName;
	}

}
