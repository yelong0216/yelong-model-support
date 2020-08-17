/**
 * 
 */
package org.yelong.core.model.support.generator.impl.pojo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.yelong.core.model.manage.FieldAndColumn;
import org.yelong.core.model.support.generator.AbstractModelGenerator;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.core.model.support.generator.ModelGenerateException;
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
	public boolean generate(GModelAndTable gModelAndTable, File modelFile) throws ModelGenerateException {
		gModelAndTable = execFilter(gModelAndTable);
		TModel tModel = convert(gModelAndTable);
		if (null == tModel) {
			return false;
		}
		try {
			Template template = freemarkerConfiguration.getTemplate(FTL_NAME, "UTF-8");
			Map<String, Object> root = new HashMap<>();
			root.put("model", tModel);
			root.put("existDateField", existDateField(gModelAndTable));
			root.put("existPrimaryKey", gModelAndTable.existPrimaryKey());
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

	protected boolean existDateField(GModelAndTable modelAndTable) {
		for (FieldAndColumn fieldAndColumn : modelAndTable.getFieldAndColumns()) {
			Class<?> fieldType = fieldAndColumn.getFieldType();
			if (fieldType.isAssignableFrom(Date.class)) {
				return true;
			}
		}
		return false;
	}

	public TModel convert(GModelAndTable modelAndTable) {
		return TModels.resolve(modelAndTable);
	}

}
