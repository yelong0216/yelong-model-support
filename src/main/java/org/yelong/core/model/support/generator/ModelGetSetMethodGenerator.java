/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.io.File;

import org.yelong.core.model.Modelable;

/**
 * 模型 get/set方法生成器。方法携带文档注释
 * 
 * @since 2.0
 */
public interface ModelGetSetMethodGenerator {

	void generate(Class<? extends Modelable> modelClass, File file) throws ModelGetSetMethodGenerateException;

}
