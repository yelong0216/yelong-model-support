/**
 * 
 */
package org.yelong.core.model.support.test.dbmanager;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.jdbc.DataBaseOperationType;
import org.yelong.core.jdbc.DataSourceProperties;
import org.yelong.core.jdbc.DefaultBaseDataBaseOperation;
import org.yelong.core.jdbc.dialect.Dialects;
import org.yelong.core.model.ModelConfiguration;
import org.yelong.core.model.ModelConfigurationBuilder;
import org.yelong.core.model.support.dbmanager.DatabaseModelTableManager;
import org.yelong.core.model.support.dbmanager.DefaultDatabaseModelTableManager;

/**
 * @since
 */
public class DatabaseModelTableManagerTest {

	public static final DatabaseModelTableManager databaseModelTableManager;

	static {
		BaseDataBaseOperation db = null;
		DataSourceProperties dataSourceProperties = new DataSourceProperties();
		dataSourceProperties.setUsername("test");
		dataSourceProperties.setPassword("test");
		dataSourceProperties.setUrl("jdbc:mysql://localhost:3306/test");
		dataSourceProperties.setDriverClassName("com.mysql.jdbc.Driver");
		try {
			db = new DefaultBaseDataBaseOperation(dataSourceProperties) {
				@Override
				public Object execute(String sql, Object[] params, DataBaseOperationType operationType) {
					System.out.println("sql:" + sql);
					System.out.println("params:" + Arrays.asList(params));
					return super.execute(sql, params, operationType);
				}
			};
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		ModelConfigurationBuilder modelConfigurationBuilder = ModelConfigurationBuilder
				.create(Dialects.MYSQL.getDialect());
		ModelConfiguration modelConfiguration = modelConfigurationBuilder.build();
		databaseModelTableManager = new DefaultDatabaseModelTableManager(modelConfiguration.getModelManager(),
				modelConfiguration.getDialect(), db);
	}

	@Test
	public void createTable() {
		databaseModelTableManager.createTable(Student.class);
	}
	
	@Test
	public void modifyTable() {
		databaseModelTableManager.modifyTable(Student.class);;
	}
	
	
	
	
	
	
	
}
