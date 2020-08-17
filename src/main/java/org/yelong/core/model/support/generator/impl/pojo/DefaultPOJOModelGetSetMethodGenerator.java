package org.yelong.core.model.support.generator.impl.pojo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.manage.ModelAndTable;
import org.yelong.core.model.pojo.POJOModelResolver;
import org.yelong.core.model.pojo.annotation.AnnotationFieldResolver;
import org.yelong.core.model.pojo.annotation.AnnotationPOJOModelResolver;
import org.yelong.core.model.resolve.ModelResolver;
import org.yelong.core.model.support.generator.GWrapperModelAndTableWrapper;
import org.yelong.core.model.support.generator.ModelGetSetMethodGenerateException;
import org.yelong.core.model.support.generator.ModelGetSetMethodGenerator;
import org.yelong.support.freemarker.FreeMarkerConfigurationFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @since 2.0
 */
public class DefaultPOJOModelGetSetMethodGenerator implements ModelGetSetMethodGenerator {

	private static Configuration freemarkerConfiguration = FreeMarkerConfigurationFactory
			.createConfigurationByClass(DefaultPOJOModelGetSetMethodGenerator.class);

	private static final String FTL_NAME = "modelGetSetMethod.ftl";

	private ModelResolver modelResolver;

	public DefaultPOJOModelGetSetMethodGenerator() {
		POJOModelResolver modelResolver = new AnnotationPOJOModelResolver();
		modelResolver.registerFieldResovler(new AnnotationFieldResolver());
		this.modelResolver = modelResolver;
	}

	public DefaultPOJOModelGetSetMethodGenerator(ModelResolver modelResolver) {
		this.modelResolver = modelResolver;
	}

	@Override
	public void generate(Class<? extends Modelable> modelClass, File file) throws ModelGetSetMethodGenerateException {
		ModelAndTable modelAndTable = modelResolver.resolve(modelClass);
		GWrapperModelAndTableWrapper gWrapperModelAndTableWrapper = new GWrapperModelAndTableWrapper(modelAndTable);
		TModel tModel = TModels.resolve(gWrapperModelAndTableWrapper);
		try {
			Template template = freemarkerConfiguration.getTemplate(FTL_NAME, "UTF-8");
			Map<String, Object> root = new HashMap<>();
			root.put("model", tModel);
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			// 生成word文件
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			throw new ModelGetSetMethodGenerateException(e);
		}
	}

}
