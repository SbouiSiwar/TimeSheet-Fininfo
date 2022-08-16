package com.fininfo.timesheet.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fininfo.timesheet.Model.User;
import com.fininfo.timesheet.Repository.UserRepository;
import com.fininfo.timesheet.exception.ResourceNotFoundException;

@Service
public class UserService implements UserRepository {

    @Autowired
    private UserRepository userRepository;

    // get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // create user rest api
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // get user by id rest api
    public ResponseEntity<User> getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
        return ResponseEntity.ok(user);
    }

    // // update user rest api
    public ResponseEntity<User> updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

        user.setNom(userDetails.getNom());
        user.setPrenom(userDetails.getPrenom());
        user.setEmail(userDetails.getEmail());
        user.setMot_de_passe(userDetails.getMot_de_passe());
        user.setNum_tel(userDetails.getNum_tel());
        user.setSolde(userDetails.getSolde());

        User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // delete user rest api
    public ResponseEntity<Map<String, Boolean>> deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" +
                        id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    // delete All users Rest api
    public ResponseEntity<Map<String, Boolean>> deleteAllUsers() {
        userRepository.deleteAll();
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    ////////////////////////////////////////////

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllInBatch() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllInBatch(Iterable<User> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> List<S> findAll(Example<S> example, Sort sort) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<User> findAllById(Iterable<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

    @Override
    public User getById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getOne(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User getReferenceById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> List<S> saveAll(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> List<S> saveAllAndFlush(Iterable<S> entities) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> S saveAndFlush(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(User entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends User> entities) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> ids) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean existsById(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public Optional<User> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public <S extends User> S save(S entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> long count(Example<S> example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public <S extends User> boolean exists(Example<S> example) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public <S extends User> Page<S> findAll(Example<S> example, Pageable pageable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <S extends User> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

}
