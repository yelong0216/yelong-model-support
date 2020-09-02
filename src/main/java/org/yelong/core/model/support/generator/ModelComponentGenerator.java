/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.io.File;

/**
 * 模型组件生成器
 * 
 * @since 2.1
 */
public interface ModelComponentGenerator {

	/**
	 * 生成组件文件
	 * 
	 * @param modelAndTable 模型表
	 * @param modelFile     模型存放的文件
	 * @throws ModelComponentGenerateException 生成异常
	 */
	void generate(GModelAndTable modelAndTable, File modelFile) throws ModelComponentGenerateException;

	/**
	 * 添加模型表过滤器
	 * 
	 * @param modelAndTableInterceptor 模型表过滤器
	 */
	void addModelAndTableInterceptor(GModelAndTableInterceptor modelAndTableInterceptor);

	/**
	 * 添加字段列过滤器
	 * 
	 * @param fieldAndColumnInterceptor 字段列过滤器
	 */
	void addFieldAndColumnInterceptor(GFieldAndColumnInterceptor fieldAndColumnInterceptor);
}
