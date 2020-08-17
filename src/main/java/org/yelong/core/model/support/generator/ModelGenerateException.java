/**
 * 
 */
package org.yelong.core.model.support.generator;

/**
 * model生成异常
 * 
 * @since 2.0
 */
public class ModelGenerateException extends Exception {

	private static final long serialVersionUID = 7869214973920455368L;

	public ModelGenerateException() {
		super();
	}

	public ModelGenerateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModelGenerateException(String message) {
		super(message);
	}

	public ModelGenerateException(Throwable cause) {
		super(cause);
	}

}
