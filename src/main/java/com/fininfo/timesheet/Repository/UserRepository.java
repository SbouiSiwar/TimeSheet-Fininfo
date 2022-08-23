package com.fininfo.timesheet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fininfo.timesheet.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
