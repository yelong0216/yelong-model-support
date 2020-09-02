package ${model.modelPackage};

<#if existDateField == true>
import java.util.Date;
</#if>

import org.yelong.core.model.annotation.Table;

import ${mode.superClassName};

/**
 * ${model.tableName} ${model.tableDesc}
 *
 * @author ${model.author}
 */
@Table(value="${model.tableName}",alias="${model.modelNamePrefixLowerCase}",desc="${model.tableDesc}")
public class ${model.modelName} extends ${model.superClassSimpleName} {

	<#list model.modelFields as modelField>
	/**${modelField.columnName}*/
	public static final String ${modelField.staticFinalFieldName} = "${modelField.code}";
	
	</#list>
	<#list model.modelFields as modelField>
	/**
	 * @return ${modelField.fieldAndColumn.columnName}
	 */
	public ${modelField.type} get${modelField.codePrefixUpperCase}() {
		return get${modelField.type}(${modelField.staticFinalFieldName});
	}
	/**
	 * @param ${modelField.code} ${modelField.fieldAndColumn.columnName}
	 */
	public void set${modelField.codePrefixUpperCase}(${modelField.type} ${modelField.code}) {
		set(${modelField.staticFinalFieldName},${modelField.code});
	}
	
	</#list>
}
