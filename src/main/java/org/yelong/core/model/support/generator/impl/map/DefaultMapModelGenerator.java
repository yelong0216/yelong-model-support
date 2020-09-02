/**
 * 
 */
package org.yelong.core.model.support.generator.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.yelong.commons.lang.StringUtilsE;
import org.yelong.core.model.map.MapModel;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.core.model.support.generator.impl.pojo.DefaultPOJOModelGenerator;
import org.yelong.core.model.support.generator.impl.pojo.TModel;
import org.yelong.core.model.support.generator.impl.pojo.TModelField;
import org.yelong.support.freemarker.EntityMap;
import org.yelong.support.freemarker.FreeMarkerConfigurationFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @since 2.0
 */
public class DefaultMapModelGenerator extends DefaultPOJOModelGenerator {

	private static Configuration freemarkerConfiguration = FreeMarkerConfigurationFactory
			.createConfigurationByClass(DefaultMapModelGenerator.class);

	private static final String FTL_NAME = "mapModel.ftl";

	@Override
	protected Map<String, Object> buildTemplateParams(TModel tModel) {
		GModelAndTable m = tModel.getgModelAndTable();
		String superClassName = tModel.getSuperClassName();
		if (StringUtils.isBlank(superClassName)) {// 默认为MapModel
			tModel.setSuperClassName(MapModel.class.getName());
		}
		String superClassPackageName = tModel.getSuperClassSimpleName();
		if (StringUtils.isBlank(superClassPackageName)) {// 默认为MapModel
			tModel.setSuperClassSimpleName(MapModel.class.getSimpleName());
		}
		EntityMap<TModel> entityTModel = new EntityMap<TModel>(tModel);
		List<TModelField> modelFields = tModel.getModelFields();
		List<EntityMap<TModelField>> entityTModelFields = new ArrayList<EntityMap<TModelField>>(modelFields.size());
		for (TModelField tModelField : modelFields) {
			EntityMap<TModelField> entityTModelField = new EntityMap<TModelField>(tModelField);
			String camelCaseToUnderscore = StringUtilsE.camelCaseToUnderscore(tModelField.getCode());
			entityTModelField.put("staticFinalFieldName", (camelCaseToUnderscore + "_fieldName").toUpperCase());
			entityTModelField.put("columnName", tModelField.getFieldAndColumn().getColumnName());
			entityTModelFields.add(entityTModelField);
		}
		entityTModel.put("modelFields", entityTModelFields);
		Map<String, Object> root = new HashMap<>();
		root.put("model", entityTModel);
		root.put("existDateField", existDateField(m));
		return root;
	}

	@Override
	protected Template getTemplate() throws Exception {
		return freemarkerConfiguration.getTemplate(FTL_NAME, "UTF-8");
	}

}
