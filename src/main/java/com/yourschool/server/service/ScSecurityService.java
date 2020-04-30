package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yourschool.server.config.JwtTokenUtil;
import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiMessage;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.InternalServerException;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.security.ChangePassword;
import com.yourschool.server.dto.security.Login;
import com.yourschool.server.dto.security.LoginResponse;
import com.yourschool.server.dto.user.Menu;
import com.yourschool.server.dto.user.Role;
import com.yourschool.server.dto.user.RolesResponse;
import com.yourschool.server.dto.user.SubMenu;
import com.yourschool.server.entity.user.SCUserRole;
import com.yourschool.server.entity.user.ScMenu;
import com.yourschool.server.entity.user.ScRole;
import com.yourschool.server.entity.user.ScSubMenu;
import com.yourschool.server.entity.user.ScUser;
import com.yourschool.server.entity.user.ScUserAudit;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.ActionType;
import com.yourschool.server.vo.ApiMessageType;
import com.yourschool.server.vo.FieldType;
import com.yourschool.server.vo.Filter;
import com.yourschool.server.vo.Operator;

@Service
public class ScSecurityService {

	@Autowired
	private CommonService commonService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private ScUserService userService;

	@Autowired
	private UserDetailsService userDetailService;

	public LoginResponse login(Login login) throws Exception {

		LoginResponse res = new LoginResponse();
		
		authenticate(login.getEmail(), login.getPassword());

		final UserDetails userDetails = userDetailService
				.loadUserByUsername(login.getEmail());
		
		String userDataStr = "";
		
		try {
			ObjectMapper om = new ObjectMapper();
			userDataStr = om.writeValueAsString(userService.findUserResponse(userDetails.getUsername()));
		} catch (Exception e) {
			
		}

		final String token = jwtTokenUtil.generateToken(userDataStr);
		res.setToken(token);
	
		return res;
	}
	
	private void authenticate(String username, String password) throws Exception {
		Objects.requireNonNull(username);
		Objects.requireNonNull(password);

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	public ActionResponse logout(Long id) {

		ActionResponse res = new ActionResponse();

		ScUser user = commonService.findById(id, ScUser.class);
		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException(ApiMessageType.USER_NOT_FOUND);

		addUserAudit(ActionType.USER_LOGOUT, "User logout", user);
		res.setApiMessage(ApiUtil.okMessage("Successfully logout"));
		res.setActionMessage("Successfully logout");

		return res;
	}

	public ActionResponse changePassword(ChangePassword changePassword) {

		ActionResponse res = new ActionResponse();

		String newPassword = changePassword.getNewPassword();
		String confirmPassword = changePassword.getConfirmPassword();
		String username = changePassword.getUserName();

		if (!ScUtil.isAllPresent(newPassword, confirmPassword, username))
			throw new InternalServerException(ApiMessageType.INSUFFICIENT_DATA);

		if (!newPassword.equals(confirmPassword))
			throw new InternalServerException(ApiMessageType.PASSWORD_MISMATCH);

		ScUser user = findUserByUserName(username);
		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException(ApiMessageType.USER_NOT_FOUND);

		user.setPassword(newPassword);
		commonService.save(user);

		addUserAudit(ActionType.CHANGE_PASSWORD, "Change password", user);
		res.setApiMessage(ApiUtil.okMessage("Password has been changed successfully"));
		res.setActionMessage("Password has been changed successfully");
		return res;
	}

	public ScUser findUserByUserName(String email) {

		List<Filter> filters = Arrays.asList(new Filter("email", Operator.EQUAL, FieldType.STRING, email));
		ScUser user = commonService.findOne(filters, ScUser.class);
		return user;

	}

	public void addUserAudit(String actionType, String action, ScUser user) {

		ScUserAudit userAudit = new ScUserAudit();

		userAudit.setAction(action);
		userAudit.setActionType(actionType);
		userAudit.setActionDate(new Date());
		userAudit.setUser(user);

		commonService.save(userAudit);

	}

	public RolesResponse roles(Long userId) {

		RolesResponse res = new RolesResponse();

		ScUser user = commonService.findById(userId, ScUser.class);

		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException("No users can be found !");

		List<SCUserRole> userRoles = user.getUserRoles();

		if (!ScUtil.isAllPresent(userRoles)) {
			res.setApiMessage(
					new ApiMessage(true, HttpStatus.NOT_FOUND.value(), "No role found", HttpStatus.NOT_FOUND.name()));
			res.setData(new ArrayList<>());
		}

		List<Role> dtoRoles = new ArrayList<>();
		userRoles.forEach(userRole -> {

			Role dtoRole = new Role();
			ScRole role = userRole.getRole();

			if (ScUtil.isAllPresent(role)) {
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
						dtoMenus.add(dtoMenu);

						List<ScSubMenu> subMenus = menu.getSubMenus();
						if (ScUtil.isAllPresent(subMenus)) {

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
					});
					dtoRole.setMenus(dtoMenus);
				}
			}
			dtoRoles.add(dtoRole);
		});
		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoRoles);
		return res;
	}

}
