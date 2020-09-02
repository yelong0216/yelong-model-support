package org.yelong.core.model.support.generator;

/**
 * 模型组件生成异常
 * 
 * @since 2.1
 */
public class ModelComponentGenerateException extends Exception {

	private static final long serialVersionUID = -2769479428870175062L;

	public ModelComponentGenerateException() {
		super();
	}

	public ModelComponentGenerateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelComponentGenerateException(String message) {
		super(message);
	}

	public ModelComponentGenerateException(Throwable cause) {
		super(cause);
	}

}
