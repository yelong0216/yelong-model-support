/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.util.List;
import java.util.Objects;

import org.yelong.core.model.manage.AbstractModelAndTable;

/**
 * @since 2.0
 */
public class DefaultGModelAndTable extends AbstractModelAndTable implements GModelAndTable {

	private String modelClassName;

	private String author;

	private String tableName;

	private String superClassName;

	private String superClassSimpleName;

	/**
	 * @param modelName       model 类全名称 如 org.yelong.core.model.Model
	 * @param tableName
	 * @param fieldAndColumns
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DefaultGModelAndTable(String modelClassName, String tableName, List<GFieldAndColumn> fieldAndColumns) {
		this.modelClassName = Objects.requireNonNull(modelClassName);
		this.tableName = Objects.requireNonNull(tableName);
		initPossessFieldAndColumns((List) fieldAndColumns);
	}

	public DefaultGModelAndTable(String modelClassName, String tableName) {
		this.modelClassName = Objects.requireNonNull(modelClassName);
		this.tableName = Objects.requireNonNull(tableName);
	}

	@Override
	public String getModelClassName() {
		return this.modelClassName;
	}

	@Override
	public String getModelClassSimpleName() {
		return this.modelClassName.substring(this.modelClassName.lastIndexOf(".") + 1);
	}

	@Override
	public String getModelClassPackageName() {
		return this.modelClassName.substring(0, this.modelClassName.lastIndexOf("."));
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String getSuperClassName() {
		return this.superClassName;
	}

	@Override
	public void setSuperClassName(String superClassName) {
		this.superClassName = superClassName;
	}

	@Override
	public String getSuperClassSimpleName() {
		return this.superClassSimpleName;
	}

	@Override
	public void setSuperClassSimpleName(String superClassSimpleName) {
		this.superClassSimpleName = superClassSimpleName;
	}

}
