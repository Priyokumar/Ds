package com.yourschool.server.entity.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "SC_MENU")
public class ScMenu implements Serializable {

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
	
	@Column(name = "HAS_SUBMENU")
	private Boolean hasSubmenu;
	
	@OneToMany(targetEntity = ScSubMenu.class, cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "MENU_ID", referencedColumnName = "SC_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ScSubMenu> subMenus = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID")
	private ScRole role;

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

	public List<ScSubMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<ScSubMenu> subMenus) {
		this.subMenus = subMenus;
	}

	public ScRole getRole() {
		return role;
	}

	public void setRole(ScRole role) {
		this.role = role;
	}
}
