/**
 * 
 */
package org.yelong.core.model.support.generator.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.util.CollectionUtils;
import org.yelong.commons.io.FileUtilsE;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.core.model.support.generator.ModelGenerateException;
import org.yelong.core.model.support.generator.ModelGenerator;
import org.yelong.core.model.support.generator.impl.map.DefaultMapModelGenerator;
import org.yelong.core.model.support.generator.impl.pojo.DefaultPOJOModelGenerator;
import org.yelong.core.model.support.generator.pdm.PDMResolver;
import org.yelong.core.model.support.generator.pdm.PDMResolverException;
import org.yelong.core.model.support.generator.pdm.defaults.DefaultPDMResolver;

/**
 * @since 2.0
 */
public final class ModelGenerateSupport {

	public static PDMResolver pdmResolver = new DefaultPDMResolver();

	public static ModelGenerator pojoModelGenerator = new DefaultPOJOModelGenerator();

	public static ModelGenerator mapModelGenerator = new DefaultMapModelGenerator();

	private ModelGenerateSupport() {
	}

	public static void generatePOJOModel(String pdmPath, String savePath)
			throws FileNotFoundException, PDMResolverException, ModelGenerateException {
		generateModel(pdmPath, savePath, pojoModelGenerator);
	}

	public static void generateMapModel(String pdmPath, String savePath)
			throws FileNotFoundException, PDMResolverException, ModelGenerateException {
		generateModel(pdmPath, savePath, mapModelGenerator);
	}

	private static void generateModel(String pdmPath, String savePath, ModelGenerator modelGenerator)
			throws FileNotFoundException, PDMResolverException, ModelGenerateException {
		FileUtilsE.requireNonExist(pdmPath);
		File pdmFile = FileUtilsE.getFile(pdmPath);
		System.out.println("正在解析" + pdmFile.getName() + "...");
		List<GModelAndTable> gModelAndTables = pdmResolver.resolve(pdmFile);
		if (CollectionUtils.isEmpty(gModelAndTables)) {
			System.out.println("未发现模型结构...");
			return;
		}
		for (GModelAndTable gModelAndTable : gModelAndTables) {
			String modelClassSimpleName = gModelAndTable.getModelClassSimpleName();
			String modelFileName = modelClassSimpleName + ".java";
			System.out.println("正在生成" + modelFileName);
			modelGenerator.generate(gModelAndTable, FileUtilsE.getFile(savePath, modelFileName));
		}
		System.out.println("生成完成！");
	}

}
