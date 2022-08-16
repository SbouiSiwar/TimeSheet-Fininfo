// package com.fininfo.timesheet.Services;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Optional;
// import java.util.function.Function;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Example;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.data.domain.Sort;
// import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Service;

// import com.fininfo.timesheet.Model.Role;
// import com.fininfo.timesheet.Repository.RoleRepository;
// import com.fininfo.timesheet.exception.ResourceNotFoundException;

// @Service
// public class RoleService implements RoleRepository {

//     @Autowired
//     private RoleRepository roleRepository;

//     // get all roles
//     public List<Role> getllRoles() {
//         return roleRepository.findAll();
//     }

//     // create role rest api
//     public Role createRole(Role role) {
//         return roleRepository.save(role);
//     }

//     // get role by id rest api
//     public ResponseEntity<Role> getRoleById(Long id) {
//         Role role = roleRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));
//         return ResponseEntity.ok(role);
//     }

//     // update role rest api
//     public ResponseEntity<Role> updateRole(Long id, Role roleDetails) {
//         Role role = roleRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));
//         role.setRole(roleDetails.getRole());
//         Role updatedRole = roleRepository.save(role);
//         return ResponseEntity.ok(updatedRole);
//     }

//     // delete role rest api
//     public ResponseEntity<Map<String, Boolean>> deleteRoleById(Long id) {
//         Role role = roleRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("Role not exist with id :" + id));

//         roleRepository.delete(role);
//         Map<String, Boolean> response = new HashMap<>();
//         response.put("deleted", Boolean.TRUE);
//         return ResponseEntity.ok(response);
//     }

//     // delete All roles Rest api
//     public ResponseEntity<Map<String, Boolean>> deleteAllRoles() {
//         roleRepository.deleteAll();
//         Map<String, Boolean> response = new HashMap<>();
//         response.put("deleted", Boolean.TRUE);
//         return ResponseEntity.ok(response);
//     }

//     //
//     ////////////////////////////////////////

//     @Override
//     public void deleteAllByIdInBatch(Iterable<Long> ids) {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public void deleteAllInBatch() {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public void deleteAllInBatch(Iterable<Role> entities) {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public List<Role> findAll() {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public List<Role> findAll(Sort sort) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> List<S> findAll(Example<S> example) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public List<Role> findAllById(Iterable<Long> ids) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void flush() {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public Role getById(Long id) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Role getOne(Long id) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Role getReferenceById(Long id) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> List<S> saveAll(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> List<S> saveAllAndFlush(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> S saveAndFlush(S entity) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public Page<Role> findAll(Pageable pageable) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public long count() {
//         // TODO Auto-generated method stub
//         return 0;
//     }

//     @Override
//     public void delete(Role entity) {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public void deleteAll() {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public void deleteAll(Iterable<? extends Role> entities) {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public void deleteAllById(Iterable<? extends Long> ids) {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public void deleteById(Long id) {
//         // TODO Auto-generated method stub

//     }

//     @Override
//     public boolean existsById(Long id) {
//         // TODO Auto-generated method stub
//         return false;
//     }

//     @Override
//     public Optional<Role> findById(Long id) {
//         // TODO Auto-generated method stub
//         return Optional.empty();
//     }

//     @Override
//     public <S extends Role> S save(S entity) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> long count(Example<S> example) {
//         // TODO Auto-generated method stub
//         return 0;
//     }

//     @Override
//     public <S extends Role> boolean exists(Example<S> example) {
//         // TODO Auto-generated method stub
//         return false;
//     }

//     @Override
//     public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public <S extends Role> Optional<S> findOne(Example<S> example) {
//         // TODO Auto-generated method stub
//         return Optional.empty();
//     }
// }
