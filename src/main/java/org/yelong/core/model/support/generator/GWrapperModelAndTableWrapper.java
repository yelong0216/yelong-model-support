package org.yelong.core.model.support.generator;

import org.yelong.core.model.manage.ModelAndTable;
import org.yelong.core.model.manage.wrapper.ModelAndTableWrapper;

/**
 * @since 2.0
 */
public class GWrapperModelAndTableWrapper extends ModelAndTableWrapper implements GModelAndTable {

	private final GModelAndTable gModelAndTable;

	public GWrapperModelAndTableWrapper(ModelAndTable modelAndTable) {
		super(modelAndTable);
		gModelAndTable = new DefaultGModelAndTable(modelAndTable.getModelName(),
				modelAndTable.getTableName());
	}

	@Override
	public String getModelClassName() {
		return gModelAndTable.getModelClassName();
	}

	@Override
	public String getModelClassSimpleName() {
		return gModelAndTable.getModelClassSimpleName();
	}

	@Override
	public String getModelClassPackageName() {
		return gModelAndTable.getModelClassPackageName();
	}

	@Override
	public String getAuthor() {
		return gModelAndTable.getAuthor();
	}

	@Override
	public void setAuthor(String author) {
		gModelAndTable.setAuthor(author);
	}

	@Override
	public String getSuperClassName() {
		return gModelAndTable.getSuperClassName();
	}

	@Override
	public void setSuperClassName(String superClassName) {
		gModelAndTable.setSuperClassName(superClassName);
	}

	@Override
	public String getSuperClassSimpleName() {
		return gModelAndTable.getSuperClassName();
	}

	@Override
	public void setSuperClassSimpleName(String superClassSimpleName) {
		gModelAndTable.setSuperClassSimpleName(superClassSimpleName);
	}

}
