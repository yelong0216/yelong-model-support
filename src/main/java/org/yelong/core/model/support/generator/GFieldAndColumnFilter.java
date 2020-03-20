/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.util.function.Function;

/**
 * 生成模型时对列进行过滤。
 * 返回 null 将不会对列进行生成。
 * 可以使用{@link GFieldAndColumnWrapper}对列进行包装而返回自定义的列属性
 * @author PengFei
 * @since 1.0.1
 */
@FunctionalInterface
public interface GFieldAndColumnFilter extends Function<GFieldAndColumn,GFieldAndColumn>{

}
