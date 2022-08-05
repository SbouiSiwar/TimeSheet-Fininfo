package com.fininfo.timesheet.repository;

import java.util.Optional;

import com.fininfo.timesheet.models.Role;
import com.fininfo.timesheet.models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
