package com.yourschool.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yourschool.server.dto.ActionResponse;
import com.yourschool.server.dto.user.Role;
import com.yourschool.server.dto.user.RoleResponse;
import com.yourschool.server.dto.user.RolesResponse;
import com.yourschool.server.service.ScRoleService;

@RestController
@RequestMapping("/api/roles")
public class ScRoleController {

	@Autowired
	private ScRoleService roleService;

	@GetMapping
	public RolesResponse findAllRoles() {
		return roleService.findAllRoles();
	}

	@PostMapping
	public ActionResponse createRole(@RequestBody Role role) {
		return roleService.createOrUpdateRole(role, null);
	}

	@GetMapping(value = "/{id}")
	public RoleResponse findRole(@PathVariable("id") Long id) {
		return roleService.findRole(id);
	}

	@PutMapping(value = "/{id}")
	public ActionResponse updateRole(@RequestBody Role role, @PathVariable("id") Long id) {
		return roleService.createOrUpdateRole(role, id);
	}

	@DeleteMapping(value = "/{id}")
	public ActionResponse deleteRole(@PathVariable("id") Long id) {
		return roleService.deleteRole(id);
	}
}
