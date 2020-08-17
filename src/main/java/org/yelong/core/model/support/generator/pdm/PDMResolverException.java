/**
 * 
 */
package org.yelong.core.model.support.generator.pdm;

/**
 * pdm文件解析异常
 * 
 * @since 2.0
 */
public class PDMResolverException extends Exception {

	private static final long serialVersionUID = -5052453534630916611L;

	public PDMResolverException() {

	}

	public PDMResolverException(String message) {
		super(message);
	}

	public PDMResolverException(Throwable t) {
		super(t);
	}

}
