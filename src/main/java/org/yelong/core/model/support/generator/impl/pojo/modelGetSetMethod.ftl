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