/**
 * 
 */
package org.yelong.core.model.support.test.dbmanager;

import org.yelong.core.model.Modelable;
import org.yelong.core.model.annotation.Column;
import org.yelong.core.model.annotation.PrimaryKey;
import org.yelong.core.model.annotation.Table;

/**
 * @since
 */
@Table("TB_YL_STUDENT_S")
public class Student implements Modelable {

	private static final long serialVersionUID = -4141764851146943074L;


	@Column(maxLength = 128)
	private String name;

	@Column(maxLength = 10)
	private Integer age;
	

	@PrimaryKey
	@Column(maxLength = 32)
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
