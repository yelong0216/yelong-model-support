/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.io.File;

import org.yelong.core.model.support.generator.exception.ModelGenerateException;

/**
 * @author PengFei
 */
public interface ModelGenerator {
	
	/**
	 * 生成model文件
	 * @param m 
	 * @param modelFile
	 */
	void generate(GModelAndTable m , File modelFile) throws ModelGenerateException;
	
	/**
	 * 添加拦截器
	 * @param modelGenerateInterceptor
	 */
	void addInterceptor(ModelGenerateInterceptor modelGenerateInterceptor);
	
}
