/**
 * 
 */
package org.yelong.core.model.support.generator.support;

import java.io.IOException;

import org.yelong.commons.io.FileUtilsE;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.support.generator.ModelGetSetMethodGenerateException;
import org.yelong.core.model.support.generator.ModelGetSetMethodGenerator;
import org.yelong.core.model.support.generator.impl.map.DefaultMapModelGetSetMethodGenerator;
import org.yelong.core.model.support.generator.impl.pojo.DefaultPOJOModelGetSetMethodGenerator;

/**
 * @since 2.0
 */
public class ModelGetSetMethodGenerateSupport {

	public static ModelGetSetMethodGenerator pojoModelGetSetMethodGenerator = new DefaultPOJOModelGetSetMethodGenerator();

	public static ModelGetSetMethodGenerator mapModelGetSetMethodGenerator = new DefaultMapModelGetSetMethodGenerator();

	public static void generatePOJOModelGetSetMethod(Class<? extends Modelable> modelClass, String filePath)
			throws ModelGetSetMethodGenerateException, IOException {
		System.out.println("正在生成" + modelClass.getSimpleName() + ".java的get/set方法...");
		pojoModelGetSetMethodGenerator.generate(modelClass, FileUtilsE.createNewFileOverride(filePath));
		System.out.println("生成完成！");
	}

	public static void generateMapModelGetSetMethod(Class<? extends Modelable> modelClass, String filePath)
			throws ModelGetSetMethodGenerateException, IOException {
		System.out.println("正在生成" + modelClass.getSimpleName() + ".java的get/set方法...");
		mapModelGetSetMethodGenerator.generate(modelClass, FileUtilsE.createNewFileOverride(filePath));
		System.out.println("生成完成！");
	}

}
