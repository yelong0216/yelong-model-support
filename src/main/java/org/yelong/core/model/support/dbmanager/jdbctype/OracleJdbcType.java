/**
 * 
 */
package org.yelong.core.model.support.dbmanager.jdbctype;

import java.util.Date;

/**
 * @author YL
 *
 */
public class OracleJdbcType implements JdbcType {

	@Override
	public String getJavaTypeMappingJdbcType(Class<?> javaTypeClass) {
		if (javaTypeClass == String.class) {
			return "varchar2";
		} else if (Number.class.isAssignableFrom(javaTypeClass)) {
			return "integer";
		} else if (javaTypeClass == Date.class) {
			return "timestamp";
		}
		throw new UnsupportedOperationException("没有找到" + javaTypeClass + "所映射的数据库数据类型！");
	}

}
