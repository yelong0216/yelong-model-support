package org.yelong.core.model.support.generator;

import org.yelong.core.model.manage.ModelAndTable;
import org.yelong.core.model.manage.wrapper.ModelAndTableWrapper;

/**
 * @since 2.0
 */
public class GWrapperModelAndTableWrapper extends ModelAndTableWrapper implements GModelAndTable {

	private String author;

	public GWrapperModelAndTableWrapper(ModelAndTable modelAndTable) {
		super(modelAndTable);
	}

	@Override
	public String getModelClassName() {
		return getModelAndTable().getModelName();
	}

	@Override
	public String getModelClassSimpleName() {
		return getModelAndTable().getModelClass().getSimpleName();
	}

	@Override
	public String getModelClassPackageName() {
		return getModelAndTable().getModelClass().getPackage().getName();
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public void setAuthor(String author) {
		this.author = author;
	}

}
