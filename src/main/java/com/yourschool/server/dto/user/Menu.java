package com.yourschool.server.dto.user;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private int id;

	private String title;

	private String order;
	
	private String icon;

	private String path;
	
	private Boolean hasSubmenu;
	
	private List<SubMenu> submenu = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Boolean getHasSubmenu() {
		return hasSubmenu;
	}

	public void setHasSubmenu(Boolean hasSubmenu) {
		this.hasSubmenu = hasSubmenu;
	}

	public List<SubMenu> getSubmenu() {
		return submenu;
	}

	public void setSubmenu(List<SubMenu> submenu) {
		this.submenu = submenu;
	}
}
