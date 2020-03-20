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

	protected final List<ModelGenerateInterceptor> modelGenerateInterceptors = new ArrayList<>();
	
	@Override
	public void addInterceptor(ModelGenerateInterceptor modelGenerateInterceptor) {
		modelGenerateInterceptors.add(modelGenerateInterceptor);
	}

}
