package com.yixutech.library.entity;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = 4636841530068404572L;

	private Long id;
	private String code;
	private String name;
	private String description;

	public Role() {
		super();
	}

	public Role(String code, String name, String description) {
		super();
		setCode(code);
		setName(name);
		setDescription(description);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
	}

}
