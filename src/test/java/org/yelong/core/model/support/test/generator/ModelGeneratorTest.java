/**
 * 
 */
package org.yelong.core.model.support.test.generator;

import java.io.FileNotFoundException;

import org.yelong.core.model.support.generator.ModelGenerateException;
import org.yelong.core.model.support.generator.pdm.PDMResolverException;
import org.yelong.core.model.support.generator.support.ModelGenerateSupport;

/**
 * @since
 */
public class ModelGeneratorTest {
	
	public static void main(String[] args) throws FileNotFoundException, PDMResolverException, ModelGenerateException {
		ModelGenerateSupport.generatePOJOModel("D:\\PowerDesigner\\数模\\generator.pdm", "D:\\PowerDesigner\\数模\\model");
//		ModelGenerateUtils.generateMapModel("D:\\PowerDesigner\\数模\\generator.pdm", "D:\\PowerDesigner\\数模\\model");
	}
	
	
}
