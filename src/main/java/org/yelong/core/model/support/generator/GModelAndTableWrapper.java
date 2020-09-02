/**
 * 
 */
package org.yelong.core.model.support.generator;

import org.yelong.core.model.manage.ModelAndTable;
import org.yelong.core.model.manage.wrapper.ModelAndTableWrapper;

/**
 * @since 2.0
 */
public class GModelAndTableWrapper extends ModelAndTableWrapper implements GModelAndTable {

	private final GModelAndTable gModelAndTable;

	public GModelAndTableWrapper(GModelAndTable gModelAndTable) {
		super(gModelAndTable);
		this.gModelAndTable = gModelAndTable;
	}

	protected GModelAndTableWrapper(ModelAndTable modelAndTable) {
		super(modelAndTable);
		this.gModelAndTable = null;
	}

	@Override
	public String getTableName() {
		return getgModelAndTable().getTableName();
	}

	@Override
	public String getTableAlias() {
		return getgModelAndTable().getTableAlias();
	}

	@Override
	public String getTableDesc() {
		return getgModelAndTable().getTableDesc();
	}

	@Override
	public String getModelClassName() {
		return getgModelAndTable().getModelClassName();
	}

	@Override
	public String getModelClassSimpleName() {
		return getgModelAndTable().getModelClassSimpleName();
	}

	@Override
	public String getModelClassPackageName() {
		return getgModelAndTable().getModelClassPackageName();
	}

	@Override
	public String getAuthor() {
		return getgModelAndTable().getAuthor();
	}

	@Override
	public void setAuthor(String author) {
		getgModelAndTable().setAuthor(author);
	}

	@Override
	public String getSuperClassName() {
		return getgModelAndTable().getSuperClassName();
	}

	@Override
	public void setSuperClassName(String superClassName) {
		getgModelAndTable().setSuperClassName(superClassName);
	}

	@Override
	public String getSuperClassSimpleName() {
		return getgModelAndTable().getSuperClassSimpleName();
	}

	@Override
	public void setSuperClassSimpleName(String superClassSimpleName) {
		getgModelAndTable().setSuperClassSimpleName(superClassSimpleName);
	}

	public GModelAndTable getgModelAndTable() {
		return gModelAndTable;
	}

}
