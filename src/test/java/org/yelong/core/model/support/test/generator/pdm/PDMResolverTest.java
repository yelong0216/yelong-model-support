/**
 * 
 */
package org.yelong.core.model.support.test.generator.pdm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.yelong.commons.io.FileUtilsE;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.core.model.support.generator.pdm.PDMResolver;
import org.yelong.core.model.support.generator.pdm.PDMResolverException;
import org.yelong.core.model.support.generator.pdm.defaults.DefaultPDMResolver;

public class PDMResolverTest {

	private PDMResolver pdmResolver = new DefaultPDMResolver();

	@Test
	public void generate() throws PDMResolverException {
		List<GModelAndTable> modelAndTables = pdmResolver
				.resolve(FileUtilsE.getFile("D:\\PowerDesigner\\数模\\model-generate-test\\generator-test.pdm"));
		System.out.println(modelAndTables);
	}

}
