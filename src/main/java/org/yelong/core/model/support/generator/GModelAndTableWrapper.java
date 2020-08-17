/**
 * 
 */
package org.yelong.core.model.support.generator;

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

	@Override
	public String getTableName() {
		return gModelAndTable.getTableName();
	}

	@Override
	public String getTableAlias() {
		return gModelAndTable.getTableAlias();
	}

	@Override
	public String getTableDesc() {
		return gModelAndTable.getTableDesc();
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

}
