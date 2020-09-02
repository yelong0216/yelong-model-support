/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.yelong.commons.io.FileUtilsE;
import org.yelong.core.model.support.generator.impl.AbstractModelComponentGenerator;

/**
 * @since 2.0
 */
public abstract class AbstractModelGenerator extends AbstractModelComponentGenerator implements ModelGenerator {

	@Override
	public void generate(List<GModelAndTable> ms, File dir) throws ModelComponentGenerateException {
		for (GModelAndTable gModelAndTable : ms) {
			try {
				generate(gModelAndTable, FileUtilsE.createNewFileOverride(dir.getAbsolutePath(),
						gModelAndTable.getModelClassSimpleName() + ".java"));
			} catch (IOException e) {
				throw new ModelComponentGenerateException(e);
			}
		}
	}

}
