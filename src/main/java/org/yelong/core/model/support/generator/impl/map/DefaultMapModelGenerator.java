/**
 * 
 */
package org.yelong.core.model.support.generator.impl.map;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.yelong.commons.lang.StringUtilsE;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.core.model.support.generator.ModelGenerateException;
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
	public boolean generate(GModelAndTable m, File modelFile) throws ModelGenerateException {
		m = execFilter(m);
		TModel tModel = convert(m);
		if (null == tModel) {
			return false;
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
		try {
			Template template = freemarkerConfiguration.getTemplate(FTL_NAME, "UTF-8");
			Map<String, Object> root = new HashMap<>();
			root.put("model", entityTModel);
			root.put("existDateField", existDateField(m));
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(modelFile), "utf-8"));
			// 生成word文件
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			throw new ModelGenerateException(e);
		}
		return true;
	}

}
