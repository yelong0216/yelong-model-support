/**
 * 
 */
package org.yelong.core.model.support.dbmanager;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.yelong.core.jdbc.BaseDataBaseOperation;
import org.yelong.core.jdbc.dialect.Dialect;
import org.yelong.core.jdbc.sql.ddl.Column;
import org.yelong.core.jdbc.sql.ddl.DataDefinitionLanguage;
import org.yelong.core.jdbc.sql.ddl.Database;
import org.yelong.core.jdbc.sql.ddl.Table;
import org.yelong.core.jdbc.sql.function.DatabaseFunction;
import org.yelong.core.model.Modelable;
import org.yelong.core.model.manage.FieldAndColumn;
import org.yelong.core.model.manage.ModelAndTable;
import org.yelong.core.model.manage.ModelManager;
import org.yelong.core.model.support.dbmanager.jdbctype.JdbcType;
import org.yelong.core.model.support.dbmanager.jdbctype.JdbcTypes;

/**
 * @since
 */
public class DefaultDatabaseModelTableManager implements DatabaseModelTableManager {

	private final ModelManager modelManager;

	private final Dialect dialect;

	private final BaseDataBaseOperation db;

	private final DatabaseFunction databaseFunction;

	private final DataDefinitionLanguage dataDefinitionLanguage;

	private final JdbcType jdbcType;

	public DefaultDatabaseModelTableManager(ModelManager modelManager, Dialect dialect, BaseDataBaseOperation db) {
		this.modelManager = modelManager;
		this.dialect = dialect;
		this.db = db;
		this.databaseFunction = dialect.createDatabaseFunction(db);
		this.dataDefinitionLanguage = dialect.createDataDefinitionLanguage(db);
		this.jdbcType = JdbcTypes.create(dialect);
	}

	@Override
	public void createTable(Class<? extends Modelable> modelClass) {
		Table table = createTable(modelManager.getModelAndTable(modelClass));
		dataDefinitionLanguage.createTable(table, false);
	}

	@Override
	public void createTableOverride(Class<? extends Modelable> modelClass) {
		Table table = createTable(modelManager.getModelAndTable(modelClass));
		dataDefinitionLanguage.createTable(table, true);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void modifyTable(Class<? extends Modelable> modelClass) {
		String database = databaseFunction.getCurrentDatabase();
		ModelAndTable modelAndTable = modelManager.getModelAndTable(modelClass);
		String tableName = modelAndTable.getTableName();
		Table table = dataDefinitionLanguage.queryTable(new Database(database), modelAndTable.getTableName());

		Objects.requireNonNull(table, "表[" + tableName + "]不存在");
		List<Column> columns = dataDefinitionLanguage.queryColumn(table);
		table.addColumns(columns);
		List<FieldAndColumn> fieldAndColumns = modelAndTable.getFieldAndColumns();
		for (FieldAndColumn fieldAndColumn : fieldAndColumns) {
			if (fieldAndColumn.isExtend()) {
				continue;
			}
			Column column = createColumn(table, fieldAndColumn);
			Column sourceColumn = table.getColumn(fieldAndColumn.getColumn());
			if (null == sourceColumn) {
				dataDefinitionLanguage.addColumn(column);
			} else {
				dataDefinitionLanguage.modifyColumn(sourceColumn, column);
			}
		}

		List<String> modelColumns = fieldAndColumns.stream().map(FieldAndColumn::getColumn)
				.collect(Collectors.toList());

		List<Column> surplusColumns = table.getColumns().stream().filter(x -> !modelColumns.contains(x))
				.collect(Collectors.toList());
		surplusColumns.forEach(dataDefinitionLanguage::dropColumn);
	}

	@Override
	public void dropTable(Class<? extends Modelable> modelClass) {
		ModelAndTable modelAndTable = modelManager.getModelAndTable(modelClass);
		dataDefinitionLanguage.dropTable(new Table(modelAndTable.getTableName()));
	}

	@Override
	public ModelManager getModelManager() {
		return this.modelManager;
	}

	@Override
	public Dialect getDialect() {
		return this.dialect;
	}

	@Override
	public BaseDataBaseOperation getBaseDataBaseOperation() {
		return this.db;
	}

	public Table createTable(ModelAndTable modelAndTable) {
		Table table = new Table(modelAndTable.getTableName());

		List<FieldAndColumn> fieldAndColumns = modelAndTable.getFieldAndColumns();
		for (FieldAndColumn fieldAndColumn : fieldAndColumns) {
			if (fieldAndColumn.isExtend()) {
				continue;
			}
			Column column = createColumn(table, fieldAndColumn);
			table.addColumn(column);
		}
		return table;
	}

	protected Column createColumn(Table table, FieldAndColumn fieldAndColumn) {
		Column column = new Column(table, fieldAndColumn.getColumn());
		column.setAllowNull(fieldAndColumn.isAllowNull());
		column.setComment(fieldAndColumn.getDesc());
		Long maxLength = fieldAndColumn.getMaxLength();
		Objects.requireNonNull(maxLength, "没有指定列[" + column + "]的长度!");
		column.setLength(fieldAndColumn.getMaxLength());
		column.setPrimaryKey(fieldAndColumn.isPrimaryKey());
		String jdbcType = fieldAndColumn.getJdbcType();
		if (StringUtils.isNotBlank(jdbcType)) {
			column.setTypeName(jdbcType);
		} else {
			column.setTypeName(this.jdbcType.getJavaTypeMappingJdbcType(fieldAndColumn.getFieldType()));
		}
		return column;
	}

}
