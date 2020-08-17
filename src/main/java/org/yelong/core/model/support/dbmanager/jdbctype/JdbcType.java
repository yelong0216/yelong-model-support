/**
 * 
 */
package org.yelong.core.model.support.dbmanager.jdbctype;

/**
 * @author YL
 *
 */
public interface JdbcType {

	String getJavaTypeMappingJdbcType(Class<?> javaTypeClass);

}
