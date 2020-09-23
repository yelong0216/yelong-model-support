/**
 * 
 */
package org.yelong.core.model.support.generator.impl.pojo;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.model.manage.FieldAndColumn;
import org.yelong.core.model.support.generator.GModelAndTable;

/**
 * @since 2.0
 */
public final class TModels {

	private TModels() {
	}

	public static TModel resolve(GModelAndTable modelAndTable) {
		TModel tModel = new TModel();
		String modelName = modelAndTable.getModelClassSimpleName();
		tModel.setModelName(modelName);
		tModel.setModelPackage(modelAndTable.getModelClassPackageName());
		tModel.setTableName(modelAndTable.getTableName());
		tModel.setModelNamePrefixLowerCase(modelName.substring(0, 1).toLowerCase() + modelName.substring(1));
		tModel.setTableDesc(modelAndTable.getTableDesc());
		tModel.setgModelAndTable(modelAndTable);
		tModel.setSuperClassName(modelAndTable.getSuperClassName());
		tModel.setSuperClassSimpleName(modelAndTable.getSuperClassSimpleName());

		List<FieldAndColumn> fieldAndColumns = modelAndTable.getFieldAndColumns();
		List<TModelField> modelFields = new ArrayList<TModelField>(fieldAndColumns.size());
		for (FieldAndColumn fieldAndColumn : fieldAndColumns) {
			TModelField tModelField = new TModelField();
			if (null == fieldAndColumn) {
				continue;
			}
			tModelField.setFieldAndColumn(fieldAndColumn);
			String fieldName = fieldAndColumn.getFieldName();
			tModelField.setCode(fieldName);
			tModelField.setCodePrefixUpperCase(fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			tModelField.setLength(fieldAndColumn.getMaxLength() + "");
			tModelField.setMandatory(Boolean.toString(fieldAndColumn.isAllowNull()));
			tModelField.setName(fieldAndColumn.getDesc());
			tModelField.setPrimaryKey(Boolean.toString(fieldAndColumn.isPrimaryKey()));
			tModelField.setType(fieldAndColumn.getFieldType().getSimpleName());
			tModelField.setColumnName(fieldAndColumn.getColumnName());
			StringBuilder columnAnnotation = new StringBuilder("@Column(");
			columnAnnotation.append("column = \"" + fieldName + "\"");
			Long maxLength = fieldAndColumn.getMaxLength();
			if (null != maxLength && fieldAndColumn.getMaxLength() < Long.MAX_VALUE) {
				columnAnnotation.append(",maxLength = " + fieldAndColumn.getMaxLength());
			}
			if (!fieldAndColumn.isAllowNull()) {
				columnAnnotation.append(",allowNull = " + fieldAndColumn.isAllowNull());
			}
			// columnAnnotation.append(",jdbcType = \""+fieldAndColumn.getJdbcType()+"\"");
			String columnName = fieldAndColumn.getColumnName();
			if (StringUtils.isNotBlank(columnName)) {
				columnAnnotation.append(",columnName = \"" + fieldAndColumn.getColumnName() + "\"");
			}
			String desc = fieldAndColumn.getDesc();
			if (StringUtils.isNotBlank(desc)) {
				columnAnnotation.append(",desc = \"" + fieldAndColumn.getDesc() + "\"");
			}
			columnAnnotation.append(")");
			tModelField.setColumnAnnotation(columnAnnotation.toString());

			modelFields.add(tModelField);
		}
		tModel.setModelFields(modelFields);
		return tModel;

	}

}
