package com.yourschool.server.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.ApiMessage;
import com.yourschool.server.dto.ApiUtil;
import com.yourschool.server.dto.error.NotFoundException;
import com.yourschool.server.dto.user.Role;
import com.yourschool.server.dto.user.User;
import com.yourschool.server.dto.user.UserResponse;
import com.yourschool.server.dto.user.UsersResponse;
import com.yourschool.server.entity.user.SCUserRole;
import com.yourschool.server.entity.user.ScRole;
import com.yourschool.server.entity.user.ScUser;
import com.yourschool.server.service.common.CommonService;
import com.yourschool.server.util.ScUtil;
import com.yourschool.server.vo.FieldType;
import com.yourschool.server.vo.Filter;
import com.yourschool.server.vo.Operator;

@Service
public class ScUserService {

	@Autowired
	private CommonService commonService;

	public UsersResponse findAllUsers() {

		UsersResponse res = new UsersResponse();

		List<ScUser> users = commonService.findAll(ScUser.class);

		if (!ScUtil.isAllPresent(users))
			throw new NotFoundException("No users can be found !");

		List<User> dtoUsers = new ArrayList<>();
		users.forEach(user -> {

			User dtoUser = setUserToDto(user);
			dtoUsers.add(dtoUser);

		});

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoUsers);
		return res;
	}

	public UserResponse findUser(Long id) {

		UserResponse res = new UserResponse();

		ScUser user = commonService.findById(id, ScUser.class);

		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException("No users can be found !");

		User dtoUser = setUserToDto(user);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoUser);

		return res;
	}
	
	public ScUser findUserByName(String username) {

		List<Filter> filters =  new ArrayList<>();
		filters.add(new Filter("email", Operator.EQUAL, FieldType.STRING, username));
		ScUser user = this.commonService.findOne(filters, ScUser.class);
		return user;
	}
	
	public UserResponse findUserResponse(String username) {

		UserResponse res = new UserResponse();

		List<Filter> filters =  new ArrayList<>();
		filters.add(new Filter("email", Operator.EQUAL, FieldType.STRING, username));
		ScUser user = this.commonService.findOne(filters, ScUser.class);
		
		if(user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException("No users can be found !");

		User dtoUser = setUserToDto(user);

		res.setApiMessage(ApiUtil.okMessage("Success"));
		res.setData(dtoUser);

		return res;
	}
	
	

	public User setUserToDto(ScUser user) {
		User dtoUser = new User();

		dtoUser.setEmail(user.getEmail());
		dtoUser.setFirstName(user.getFirstName());
		dtoUser.setId(user.getId());
		dtoUser.setLastName(user.getLastName());
		dtoUser.setLinkedId(user.getLinkedId());
		dtoUser.setMobile(user.getMobile());
		dtoUser.setUserName(user.getUserName());
		// dtoUser.setPassword(user.getPassword());

		List<SCUserRole> userRoles = user.getUserRoles();
		if (ScUtil.isAllPresent(userRoles)) {

			List<Role> dtoRoles = new ArrayList<>();
			userRoles.forEach(userRole -> {

				Role dtoRole = new Role();
				ScRole role = userRole.getRole();

				if (role != null) {
					dtoRole.setId(role.getId());
					dtoRole.setName(role.getName());
				}
				dtoRoles.add(dtoRole);
			});
			dtoUser.setRoles(dtoRoles);

		}
		return dtoUser;
	}

	public ActionResponse createOrUpdateUser(User apiUser, Long id) {

		ActionResponse res = new ActionResponse();

		ScUser user = new ScUser();

		if (ScUtil.isAllPresent(id))
			user = commonService.findById(id, ScUser.class);

		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException("No users can be found !");

		Long linkedId = apiUser.getLinkedId();
		List<ScUser> users = commonService.find(Arrays.asList(new Filter("linkedId",Operator.EQUAL,FieldType.NUMBER, linkedId)), ScUser.class);

		if (ScUtil.isAllPresent(users) && !ScUtil.isAllPresent(id)) {
			ApiMessage apiMessage = new ApiMessage(true, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					"Existing user has been created", HttpStatus.INTERNAL_SERVER_ERROR.name());
			res.setActionMessage("Existing user has been created");
			res.setApiMessage(apiMessage);
			return res;
		}

		user.setLinkedId(apiUser.getLinkedId());
		user.setEmail(apiUser.getEmail());
		user.setFirstName(apiUser.getFirstName());
		user.setLastName(apiUser.getLastName());
		user.setMobile(apiUser.getMobile());
		user.setUserName(apiUser.getUserName());
		user.setPassword("admin");

		if (ScUtil.isAllPresent(apiUser.getRoles())) {

			List<SCUserRole> userRoles = new ArrayList<>();
			for (Role apiRoles : apiUser.getRoles()) {

				ScRole role = commonService.findById(apiRoles.getId(), ScRole.class);
				SCUserRole userRole = new SCUserRole();
				userRole.setRole(role);
				userRole.setUser(user);
				userRoles.add(userRole);

			}
			if (ScUtil.isAllPresent(user.getUserRoles()))
				user.getUserRoles().clear();
			user.getUserRoles().addAll(userRoles);
		}
		commonService.save(user);

		String message = "";
		if (ScUtil.isAllPresent(id)) {
			message = "Successfully updated the user's data";
			res.setApiMessage(ApiUtil.createdMessage(message));
		} else {
			message = "Successfully created a user";
			res.setApiMessage(ApiUtil.okMessage(message));
			res.setActionMessage(message);
		}

		return res;
	}

	public ActionResponse deleteUser(Long id) {

		ActionResponse res = new ActionResponse();

		ScUser user = commonService.findById(id, ScUser.class);

		if (!ScUtil.isAllPresent(user))
			throw new NotFoundException("No users can be found !");

		commonService.delete(user);

		res.setApiMessage(ApiUtil.okMessage("Successfully deleted"));
		return res;
	}

}
