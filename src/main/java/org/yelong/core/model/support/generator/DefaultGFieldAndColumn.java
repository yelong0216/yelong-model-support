/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.util.Objects;

import org.yelong.core.model.manage.AbstractFieldAndColumn;

/**
 * @since 2.0
 */
public class DefaultGFieldAndColumn extends AbstractFieldAndColumn implements GFieldAndColumn {

	private final String fieldName;

	private final Class<?> fieldType;

	private final String column;

	public DefaultGFieldAndColumn(String column, String fieldName, Class<?> fieldType) {
		this.column = Objects.requireNonNull(column);
		this.fieldName = Objects.requireNonNull(fieldName);
		this.fieldType = Objects.requireNonNull(fieldType);
	}

	@Override
	public Class<?> getFieldType() {
		return this.fieldType;
	}

	@Override
	public String getFieldName() {
		return this.fieldName;
	}

	@Override
	public String getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "DefaultGFieldAndColumn [column=" + getColumn() + ",fieldName=" + fieldName + ", fieldType=" + fieldType
				+ "]";
	}

}
