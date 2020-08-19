/**
 * 
 */
package org.yelong.core.model.support.generator;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.manage.ModelAndTable;

/**
 * @since 2.0
 */
public interface GModelAndTable extends ModelAndTable {

	@Override
	default String getModelName() {
		return getModelClassName();
	}

	/**
	 * @return class name
	 */
	String getModelClassName();

	/**
	 * @return class simple name
	 */
	String getModelClassSimpleName();

	/**
	 * @return package name
	 */
	String getModelClassPackageName();

	/**
	 * @return 作者
	 */
	String getAuthor();

	/**
	 * @param author 作者
	 */
	void setAuthor(String author);

	@Override
	default Class<? extends Modelable> getModelClass() {
		throw new UnsupportedOperationException("生成器Model不允许获取class");
	}

}
