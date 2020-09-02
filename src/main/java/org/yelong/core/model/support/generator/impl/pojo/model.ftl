package ${model.modelPackage};

<#if existDateField == true>
import java.util.Date;
</#if>

import org.yelong.core.model.annotation.Column;
<#if existPrimaryKey == true>
import org.yelong.core.model.annotation.PrimaryKey;
</#if>
import org.yelong.core.model.annotation.Table;

import ${model.superClassName};

/**
 * ${model.tableName} ${model.tableDesc}
 *
 * @author ${model.author}
 */
@Table(value="${model.tableName}",alias="${model.modelNamePrefixLowerCase}",desc="${model.tableDesc}")
public class ${model.modelName} extends ${model.superClassSimpleName} {
	<#list model.modelFields as modelField>
	
	<#if modelField.primaryKey == "true">
	@PrimaryKey
	</#if>
	${modelField.columnAnnotation}
	private ${modelField.type} ${modelField.code};
	</#list>

	<#list model.modelFields as modelField>
	/**
	 * @return ${modelField.fieldAndColumn.columnName}
	 */
	public ${modelField.type} get${modelField.codePrefixUpperCase}() {
		return ${modelField.code};
	}

	/**
	 * @param ${modelField.code} ${modelField.fieldAndColumn.columnName}
	 */
	public void set${modelField.codePrefixUpperCase}(${modelField.type} ${modelField.code}) {
		this.${modelField.code} = ${modelField.code};
	}
	
	</#list>
}
