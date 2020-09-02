/**
 * 
 */
package org.yelong.core.model.support.generator.impl.pojo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.model.Model;
import org.yelong.core.model.manage.FieldAndColumn;
import org.yelong.core.model.support.generator.AbstractModelGenerator;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.support.freemarker.FreeMarkerConfigurationFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @since 2.0
 */
public class DefaultPOJOModelGenerator extends AbstractModelGenerator {

	private static Configuration freemarkerConfiguration = FreeMarkerConfigurationFactory
			.createConfigurationByClass(DefaultPOJOModelGenerator.class);

	private static final String FTL_NAME = "model.ftl";

	@Override
	protected Map<String, Object> buildTemplateParams(TModel tModel) {
		String superClassName = tModel.getSuperClassName();
		if (StringUtils.isBlank(superClassName)) {// 默认为MapModel
			tModel.setSuperClassName(Model.class.getName());
		}
		String superClassPackageName = tModel.getSuperClassSimpleName();
		if (StringUtils.isBlank(superClassPackageName)) {// 默认为MapModel
			tModel.setSuperClassSimpleName(Model.class.getSimpleName());
		}
		GModelAndTable gModelAndTable = tModel.getgModelAndTable();
		Map<String, Object> root = new HashMap<>();
		root.put("model", tModel);
		root.put("existDateField", existDateField(gModelAndTable));
		root.put("existPrimaryKey", gModelAndTable.existPrimaryKey());
		return root;
	}

	@Override
	protected Template getTemplate() throws Exception {
		return freemarkerConfiguration.getTemplate(FTL_NAME, "UTF-8");
	}

	protected boolean existDateField(GModelAndTable modelAndTable) {
		for (FieldAndColumn fieldAndColumn : modelAndTable.getFieldAndColumns()) {
			Class<?> fieldType = fieldAndColumn.getFieldType();
			if (fieldType.isAssignableFrom(Date.class)) {
				return true;
			}
		}
		return false;
	}

}
