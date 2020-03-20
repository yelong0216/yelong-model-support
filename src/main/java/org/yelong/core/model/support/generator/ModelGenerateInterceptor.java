/**
 * 
 */
package org.yelong.core.model.support.generator;

/**
 * @author PengFei
 */
public interface ModelGenerateInterceptor {

	/**
	 * 拦截生成Model时。可以对GModelAndTable进行包装来实现自定义Model
	 * @param gModelAndTable
	 * @return gModelAndTable
	 */
	default GModelAndTable process(GModelAndTable gModelAndTable) {
		return gModelAndTable;
	}
	
	/**
	 * 拦截生成列时。对gFieldAndColumn进行包装实现自定义列
	 * @param gFieldAndColumn 列
	 * @return gFieldAndColumn
	 */
	default GFieldAndColumn process(GFieldAndColumn gFieldAndColumn) {
		return gFieldAndColumn;
	}
	
}
