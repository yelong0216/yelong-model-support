/**
 * 
 */
package org.yelong.core.model.support.generator;

/**
 * 生成模型时对列进行过滤。 返回 null 将不会对列进行生成。
 * 可以使用{@link GFieldAndColumnWrapper}对列进行包装而返回自定义的列属性
 * 
 * @since 2.0
 */
@FunctionalInterface
public interface GFieldAndColumnInterceptor {

	GFieldAndColumn process(GFieldAndColumn fieldAndColumn);

}
