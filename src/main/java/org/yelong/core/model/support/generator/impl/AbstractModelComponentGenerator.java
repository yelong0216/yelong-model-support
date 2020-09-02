package org.yelong.core.model.support.generator.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.yelong.core.model.manage.FieldAndColumn;
import org.yelong.core.model.manage.FieldAndColumnType;
import org.yelong.core.model.support.generator.GFieldAndColumn;
import org.yelong.core.model.support.generator.GFieldAndColumnInterceptor;
import org.yelong.core.model.support.generator.GModelAndTable;
import org.yelong.core.model.support.generator.GModelAndTableInterceptor;
import org.yelong.core.model.support.generator.GModelAndTableWrapper;
import org.yelong.core.model.support.generator.ModelComponentGenerateException;
import org.yelong.core.model.support.generator.ModelComponentGenerator;
import org.yelong.core.model.support.generator.impl.pojo.TModel;
import org.yelong.core.model.support.generator.impl.pojo.TModels;
import org.yelong.support.freemarker.EntityMap;

import freemarker.template.Template;

/**
 * 抽象实现的模型组件生成器
 * 
 * @since 2.1
 */
public abstract class AbstractModelComponentGenerator implements ModelComponentGenerator {

	protected final List<GFieldAndColumnInterceptor> fFieldAndColumnInterceptors = new ArrayList<>();

	protected final List<GModelAndTableInterceptor> gModelAndTableInterceptors = new ArrayList<>();

	@Override
	public void addFieldAndColumnInterceptor(GFieldAndColumnInterceptor fieldAndColumnInterceptor) {
		this.fFieldAndColumnInterceptors.add(fieldAndColumnInterceptor);
	}

	@Override
	public void addModelAndTableInterceptor(GModelAndTableInterceptor modelAndTableInterceptor) {
		this.gModelAndTableInterceptors.add(modelAndTableInterceptor);
	}

	@Override
	public void generate(GModelAndTable modelAndTable, File modelFile) throws ModelComponentGenerateException {
		modelAndTable = execInterceptor(modelAndTable);
		TModel tModel = convert(modelAndTable);
		try {
			Template template = getTemplate();
			Map<String, Object> root = buildTemplateParams(tModel);
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(modelFile), "utf-8"));
			template.process(root, writer);
			writer.flush();
			writer.close();
		} catch (ModelComponentGenerateException e) {
			throw e;
		} catch (Exception e) {
			throw new ModelComponentGenerateException(e);
		}
	}

	/**
	 * 构建模板参数
	 * 
	 * @param tModel 模板模型
	 * @return 模板参数
	 */
	protected Map<String, Object> buildTemplateParams(TModel tModel) {
		EntityMap<TModel> tModelEntityMap = new EntityMap<TModel>(tModel);
		return tModelEntityMap;
	}

	/**
	 * @return 组件模板
	 */
	protected abstract Template getTemplate() throws Exception;

	/**
	 * 对模型和表、字段通过过滤器进行过滤处理
	 * 
	 * @param gModelAndTable 生成器模型表
	 * @return 过滤处理后的生成器模型表
	 */
	protected GModelAndTable execInterceptor(GModelAndTable gModelAndTable) {
		for (GModelAndTableInterceptor gModelAndTableInterceptor : gModelAndTableInterceptors) {
			gModelAndTable = gModelAndTableInterceptor.process(gModelAndTable);
		}
		if (CollectionUtils.isNotEmpty(fFieldAndColumnInterceptors)) {
			List<FieldAndColumn> fieldAndColumns = gModelAndTable.getFieldAndColumns();
			final List<FieldAndColumn> newGFieldAndColumns = new ArrayList<>(fieldAndColumns.size());
			for (FieldAndColumn fieldAndColumn : fieldAndColumns) {
				for (GFieldAndColumnInterceptor gFieldAndColumnInterceptor : fFieldAndColumnInterceptors) {
					fieldAndColumn = gFieldAndColumnInterceptor.process((GFieldAndColumn) fieldAndColumn);
				}
				if (null != fieldAndColumn) {
					newGFieldAndColumns.add(fieldAndColumn);
				}
			}
			gModelAndTable = new GModelAndTableWrapper(gModelAndTable) {

				@Override
				public List<FieldAndColumn> getFieldAndColumns(FieldAndColumnType... fieldAndColumnTypes) {
					if (ArrayUtils.isEmpty(fieldAndColumnTypes)) {
						return newGFieldAndColumns;
					}
					return newGFieldAndColumns.parallelStream()
							.filter(x -> ArrayUtils.contains(fieldAndColumnTypes, x.getFieldAndColumnType()))
							.collect(Collectors.toList());
				}

				@Override
				public List<FieldAndColumn> getPrimaryKeys() {
					return getFieldAndColumns(FieldAndColumnType.PRIMARYKEY);
				}

				@Override
				public boolean existPrimaryKey() {
					return IteratorUtils.matchesAny(getFieldAndColumns().iterator(), x -> {
						return x.isPrimaryKey();
					});
				}
			};
		}
		return gModelAndTable;
	}

	public TModel convert(GModelAndTable modelAndTable) {
		return TModels.resolve(modelAndTable);
	}

}
