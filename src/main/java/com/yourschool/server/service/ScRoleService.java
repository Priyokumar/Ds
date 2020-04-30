package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.user.Menu;
import com.yourschool.server.dto.user.Role;
import com.yourschool.server.dto.user.RoleResponse;
import com.yourschool.server.dto.user.RolesResponse;
import com.yourschool.server.dto.user.SubMenu;
import com.yourschool.server.entity.user.ScMenu;
import com.yourschool.server.entity.user.ScRole;
import com.yourschool.server.entity.user.ScSubMenu;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;

@Service
public class ScRoleService {

	@Autowired
	private CommonService commonService;

	public RolesResponse findAllRoles() {

		RolesResponse res = new RolesResponse();

		List<ScRole> roles = commonService.findAll(ScRole.class);

		if (!ScUtil.isAllPresent(roles))
			throw new NotFoundException("No role can be found !");

		List<Role> dtoRoles = new ArrayList<>();
		roles.forEach(role -> {

			Role dtoRole = setRoleToDto(role);
			dtoRoles.add(dtoRole);

		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoRoles);
		return res;
	}

	private Role setRoleToDto(ScRole role) {

		Role dtoRole = new Role();
		dtoRole.setDesc(role.getDesc());
		dtoRole.setId(role.getId());
		dtoRole.setName(role.getName());

		List<ScMenu> menus = role.getMenus();
		if (ScUtil.isAllPresent(menus)) {

			List<Menu> dtoMenus = new ArrayList<>();
			menus.forEach(menu -> {

				Menu dtoMenu = new Menu();
				dtoMenu.setHasSubmenu(menu.getHasSubmenu());
				dtoMenu.setIcon(menu.getIcon());
				dtoMenu.setId(menu.getId());
				dtoMenu.setOrder(menu.getOrder());
				dtoMenu.setPath(menu.getPath());
				dtoMenu.setTitle(menu.getTitle());

				List<ScSubMenu> subMenus = menu.getSubMenus();
				if (ScUtil.isAllPresent(menus)) {

					List<SubMenu> dtoSubMenus = new ArrayList<>();
					subMenus.forEach(subMenu -> {
						SubMenu dtoSubMenu = new SubMenu();
						dtoSubMenu.setIcon(subMenu.getIcon());
						dtoSubMenu.setId(subMenu.getId());
						dtoSubMenu.setOrder(subMenu.getOrder());
						dtoSubMenu.setPath(subMenu.getPath());
						dtoSubMenu.setTitle(subMenu.getTitle());
						dtoSubMenus.add(dtoSubMenu);
					});

					dtoMenu.setSubmenu(dtoSubMenus);
				}
				dtoMenus.add(dtoMenu);
			});
			dtoRole.setMenus(dtoMenus);
		}
		return dtoRole;
	}

	public ActionResponse createOrUpdateRole(Role dtoRole, Long id) {

		ActionResponse res = new ActionResponse();

		ScRole role = new ScRole();

		if (ScUtil.isAllPresent(id))
			role = commonService.findById(id, ScRole.class);

		if (!ScUtil.isAllPresent(role))
			throw new NotFoundException("No role can be found !");

		setDtoToRole(dtoRole, role);
		commonService.save(role);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated the role's data";
			res.setApiMessage(ApiUtil.createdMessage(message));
		} else {
			message = "Successfully created a role";
			res.setApiMessage(ApiUtil.okMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	private void setDtoToRole(Role dtoRole, ScRole role) {
		role.setDesc(dtoRole.getDesc());
		role.setId(dtoRole.getId());
		role.setName(dtoRole.getName());
		role.setRecordAudit(null);

		if (ScUtil.isAllPresent(role.getMenus()))
			role.getMenus().clear();
		List<Menu> dtoMenus = dtoRole.getMenus();
		if (!ScUtil.isAllPresent(dtoMenus))
			return;

		List<ScMenu> menus = new ArrayList<>();

		for (Menu dtoMenu : dtoMenus) {

			ScMenu menu = new ScMenu();
			menu.setHasSubmenu(dtoMenu.getHasSubmenu());
			menu.setIcon(dtoMenu.getIcon());
			menu.setId(dtoMenu.getId());
			menu.setOrder(dtoMenu.getOrder());
			menu.setPath(dtoMenu.getPath());
			menu.setRole(role);
			menu.setTitle(dtoMenu.getTitle());

			List<SubMenu> dtoSubMenus = dtoMenu.getSubmenu();
			List<ScSubMenu> subMenus = new ArrayList<>();

			dtoSubMenus.forEach(dtoSubMenu -> {

				ScSubMenu subMenu = new ScSubMenu();
				subMenu.setIcon(dtoSubMenu.getIcon());
				subMenu.setId(dtoSubMenu.getId());
				subMenu.setMenu(menu);
				subMenu.setOrder(dtoSubMenu.getOrder());
				subMenu.setPath(dtoSubMenu.getPath());
				subMenu.setTitle(dtoSubMenu.getTitle());

				subMenus.add(subMenu);

			});

			menu.setSubMenus(subMenus);
			menus.add(menu);
		}

		role.getMenus().addAll(menus);
	}

	public RoleResponse findRole(Long id) {

		RoleResponse res = new RoleResponse();

		ScRole role = commonService.findById(id, ScRole.class);

		if (!ScUtil.isAllPresent(role))
			throw new NotFoundException("No role can be found !");

		Role dtoRole = setRoleToDto(role);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoRole);

		return res;
	}

	public ActionResponse deleteRole(Long id) {

		ActionResponse res = new ActionResponse();

		ScRole role = commonService.findById(id, ScRole.class);

		if (!ScUtil.isAllPresent(role))
			throw new NotFoundException("No role can be found !");

		commonService.delete(role);

		res.setApiMessage(ApiUtil.okMessage("Successfully deleted"));
		return res;
	}
}
