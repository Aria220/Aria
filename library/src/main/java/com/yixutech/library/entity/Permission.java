package com.yixutech.library.entity;

import java.io.Serializable;

public class Permission implements Serializable {

	private static final long serialVersionUID = -4880891644456196324L;
	
	private Long id;
	private String code;
	private String name;
	private String description;

	public Permission() {
		super();
	}

	public Permission(String code, String name, String description) {
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
		return "Permission [id=" + id + ", code=" + code + ", name=" + name + ", description=" + description + "]";
	}

}
