/**
 * 
 */
package org.yelong.core.model.support.test.generator;

import org.yelong.core.model.support.generator.support.ModelGenerateSupport;

/**
 * @since
 */
public class ModelGeneratorTest {

	static {
		ModelGenerateSupport.pojoModelGenerator.addFieldAndColumnInterceptor(x -> {
			return x.getColumn().equals("id") ? null : x;
		});
	}

	public static void main(String[] args) throws Exception {
		ModelGenerateSupport.generatePOJOModel("D:\\PowerDesigner\\数模\\generator.pdm", "D:\\PowerDesigner\\数模\\model");
//		ModelGenerateUtils.generateMapModel("D:\\PowerDesigner\\数模\\generator.pdm", "D:\\PowerDesigner\\数模\\model");
	}

}
