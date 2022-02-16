package com.swlc.ScrumPepperAdminCPU6001.repository;

import com.swlc.ScrumPepperAdminCPU6001.entity.UserEntity;
import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author hp
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByRefNo(String refNo);
    Optional<UserEntity> findByEmailAndStatusType(String email, StatusType statusType);
}
