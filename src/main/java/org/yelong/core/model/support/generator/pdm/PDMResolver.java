/**
 * 
 */
package org.yelong.core.model.support.generator.pdm;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import org.yelong.core.model.support.generator.GModelAndTable;

/**
 * pdm文件解析器
 * 
 * @since 2.0
 */
public interface PDMResolver {

	/**
	 * 解析pdm
	 * 
	 * @param is 流
	 * @return 生成器model
	 * @throws PDMResolverException pdm文件解析异常
	 */
	List<GModelAndTable> resolve(InputStream is) throws PDMResolverException;

	/**
	 * 解析pdm文件
	 * 
	 * @param pdm pdm文件
	 * @return 生成器model
	 * @throws PDMResolverException pdm文件解析异常
	 */
	List<GModelAndTable> resolve(File pdm) throws PDMResolverException;

}
