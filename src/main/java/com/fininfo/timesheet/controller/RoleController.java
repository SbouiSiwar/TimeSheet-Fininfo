// package com.fininfo.timesheet.Controller;

// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.fininfo.timesheet.Model.Role;
// import com.fininfo.timesheet.Services.RoleService;

// @CrossOrigin(origins = "http://localhost:4200")
// @RestController
// @RequestMapping("/api/v1/")
// public class RoleController {

//     @Autowired
//     private RoleService roleService;

//     // get all roles
//     @GetMapping("/roles")
//     public List<Role> getllRoles() {
//         return roleService.getllRoles();
//     }

//     // create role rest api
//     @PostMapping("/roles")
//     public Role createRole(@RequestBody Role role) {
//         return roleService.createRole(role);
//     }

//     // get role by id rest api
//     @GetMapping("/roles/{id}")
//     public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
//         return roleService.getRoleById(id);
//     }

//     // update role rest api
//     @PutMapping("/roles/{id}")
//     public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
//         return roleService.updateRole(id, roleDetails);
//     }

//     // delete role rest api
//     @DeleteMapping("/roles/{id}")
//     public ResponseEntity<Map<String, Boolean>> deleteRoleById(@PathVariable Long id) {
//         return roleService.deleteRoleById(id);
//     }

//     // delete All roles Rest api
//     @DeleteMapping("/roles")
//     public ResponseEntity<Map<String, Boolean>> deleteAllRoles() {
//         return roleService.deleteAllRoles();
//     }

// }
