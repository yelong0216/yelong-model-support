/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.util.function.Function;

/**
 * 模型与表过滤器
 * 返回null将不会生成模型
 * 可以使用{@link GModelAndTableWrapper}对模型进行包装从而返回自定义的模型属性
 * @author PengFei
 * @since 1.0.1
 */
@FunctionalInterface
public interface GModelAndTableFilter extends Function<GModelAndTable,GModelAndTable>{
	
}
