package org.yelong.core.model.support.generator;

import org.yelong.core.model.manage.ModelAndTable;

/**
 * @since 2.0
 */
public class GWrapperModelAndTableWrapper extends GModelAndTableWrapper implements GModelAndTable {

	private final GModelAndTable gModelAndTable;

	public GWrapperModelAndTableWrapper(ModelAndTable modelAndTable) {
		super(modelAndTable);
		gModelAndTable = new DefaultGModelAndTable(modelAndTable.getModelName(),
				modelAndTable.getModelClass().getSimpleName());
	}

	@Override
	public GModelAndTable getgModelAndTable() {
		return gModelAndTable;
	}

}
