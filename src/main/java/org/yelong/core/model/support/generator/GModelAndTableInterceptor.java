/**
 * 
 */
package org.yelong.core.model.support.generator;

/**
 * 模型与表过滤器 返回null将不会生成模型 可以使用{@link GModelAndTableWrapper}对模型进行包装从而返回自定义的模型属性
 * 
 * @since 2.0
 */
@FunctionalInterface
public interface GModelAndTableInterceptor {

	GModelAndTable process(GModelAndTable modelAndTable);

}
