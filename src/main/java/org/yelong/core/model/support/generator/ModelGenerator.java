/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.io.File;
import java.util.List;

/**
 * 模型生成器
 * 
 * @since 2.0
 */
public interface ModelGenerator extends ModelComponentGenerator {

	/**
	 * 批量生成model，并放置在dir目录下。model名称为 #{modelName}.java
	 * 
	 * @param ms  GModelAndTables
	 * @param dir 生成后的model存放目录
	 * @throws ModelGenerateException
	 * @since 1.0.1
	 */
	void generate(List<GModelAndTable> ms, File dir) throws ModelComponentGenerateException;

}
