package com.yourschool.server.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SC_SUB_MENU")
public class ScSubMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "SC_ID")
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "MENU_ORDER")
	private String order;
	
	@Column(name = "ICON")
	private String icon;

	@Column(name = "PATH")
	private String path;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "MENU_ID")
	private ScMenu menu;

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

	public ScMenu getMenu() {
		return menu;
	}

	public void setMenu(ScMenu menu) {
		this.menu = menu;
	}
	
	
}
