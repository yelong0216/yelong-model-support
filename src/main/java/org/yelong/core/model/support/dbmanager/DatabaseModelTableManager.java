/**
 * 
 */
package org.yelong.core.model.support.dbmanager;

import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.jdbc.dialect.Dialect;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.manage.ModelManager;

/**
 * @since
 */
public interface DatabaseModelTableManager {

	void createTable(Class<? extends Modelable> modelClass);

	void createTableOverride(Class<? extends Modelable> modelClass);

	void modifyTable(Class<? extends Modelable> modelClass);

	void dropTable(Class<? extends Modelable> modelClass);

	ModelManager getModelManager();

	Dialect getDialect();

	BaseDataBaseOperation getBaseDataBaseOperation();

}
