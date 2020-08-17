/**
 * 
 */
package org.yelong.core.model.support.dbmanager.jdbctype;

import org.yelong.core.jdbc.dialect.Dialect;
import org.yelong.core.jdbc.dialect.DialectType;

/**
 * @author YL
 *
 */
public final class JdbcTypes {

	private JdbcTypes() {
	}

	public static JdbcType create(Dialect dialect) {
		if (dialect.getDialectType() == DialectType.MYSQL) {
			return new MysqlJdbcType();
		} else if (dialect.getDialectType() == DialectType.ORACLE) {
			return new OracleJdbcType();
		}
		throw new UnsupportedOperationException("不支持的方言：" + dialect);
	}

}
