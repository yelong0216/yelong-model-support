/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.io.File;
import java.util.List;

import org.yelong.core.model.support.generator.exception.ModelGenerateException;

/**
 * 模型生成器
 * 
 * @author PengFei
 */
public interface ModelGenerator {
	
	/**
	 * 生成model文件
	 * @param m GModelAndTable
	 * @param modelFile 生成后的文件
	 * @return <tt>true</tt> 生成成功
	 */
	boolean generate(GModelAndTable m , File modelFile) throws ModelGenerateException;
	
	/**
	 * 批量生成model，并放置在dir目录下。model名称为 #{modelName}.java
	 * @param ms GModelAndTables
	 * @param dir 生成后的model存放目录
	 * @throws ModelGenerateException
	 * @since 1.0.1
	 */
	void generate(List<GModelAndTable> ms , File dir) throws ModelGenerateException;
	
	/**
	 * 添加拦截器
	 * @param modelGenerateInterceptor
	 * @deprecated 1.0.1
	 * @see #addFieldAndColumnFilter(GFieldAndColumnFilter)
	 * @see #addModelAndTableFilter(GModelAndTableFilter)
	 */
	void addInterceptor(ModelGenerateInterceptor modelGenerateInterceptor);
	
	/**
	 * 添加模型表过滤器
	 * @param gModelAndTableFilter 模型表过滤器
	 * @since 1.0.1
	 */
	void addModelAndTableFilter(GModelAndTableFilter gModelAndTableFilter);
	
	/**
	 * 添加字段列过滤器
	 * @param gFieldAndColumnFilter 字段列过滤器
	 * @since 1.0.1
	 */
	void addFieldAndColumnFilter(GFieldAndColumnFilter gFieldAndColumnFilter);
	
}
