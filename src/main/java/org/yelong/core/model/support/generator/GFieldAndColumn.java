/**
 * 
 */
package org.yelong.core.model.support.generator;

import java.lang.reflect.Field;

import org.yelong.core.model.resolve.FieldAndColumn;

/**
 * @author PengFei
 */
public interface GFieldAndColumn extends FieldAndColumn{

	@Override
	default Field getField() {
		throw new UnsupportedOperationException("生成器Model不允许获取字段");
	}
	
}
