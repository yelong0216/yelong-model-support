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

	/**
	 * @return 父类简单名称
	 * @since 2.1
	 */
	String getSuperClassName();

	/**
	 * 设置父类简单名称
	 * 
	 * @param superClassName 父类名称
	 * @since 2.1
	 */
	void setSuperClassName(String superClassName);

	/**
	 * 设置父类名称
	 * 
	 * @return 父类包名称
	 * @since 2.1
	 */
	String getSuperClassSimpleName();

	/**
	 * 设置父类名称
	 * 
	 * @param superClassSimpleName
	 * @since 2.1
	 */
	void setSuperClassSimpleName(String superClassSimpleName);

	@Override
	default Class<? extends Modelable> getModelClass() {
		throw new UnsupportedOperationException("生成器Model不允许获取class");
	}

}
