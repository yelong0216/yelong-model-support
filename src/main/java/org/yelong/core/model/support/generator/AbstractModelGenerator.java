/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PengFei
 */
public abstract class AbstractModelGenerator implements ModelGenerator{

	@Deprecated
	protected final List<ModelGenerateInterceptor> modelGenerateInterceptors = new ArrayList<>();
	
	protected final List<GFieldAndColumnFilter> gFieldAndColumnFilters = new ArrayList<>();
	
	protected final List<GModelAndTableFilter> gModelAndTableFilter = new ArrayList<>();
	
	@Override
	@Deprecated
	public void addInterceptor(ModelGenerateInterceptor modelGenerateInterceptor) {
		modelGenerateInterceptors.add(modelGenerateInterceptor);
	}

	@Override
	public void addFieldAndColumnFilter(GFieldAndColumnFilter gFieldAndColumnFilter) {
		this.gFieldAndColumnFilters.add(gFieldAndColumnFilter);
	}
	
	@Override
	public void addModelAndTableFilter(GModelAndTableFilter GModelAndTableFilter) {
		this.gModelAndTableFilter.add(GModelAndTableFilter);
	}
	
}
