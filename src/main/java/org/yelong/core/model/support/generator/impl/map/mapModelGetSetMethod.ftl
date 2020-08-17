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