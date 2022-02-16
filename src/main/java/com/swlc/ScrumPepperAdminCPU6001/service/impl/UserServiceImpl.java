package com.swlc.ScrumPepperAdminCPU6001.service.impl;

import com.swlc.ScrumPepperAdminCPU6001.dto.UserDTO;
import com.swlc.ScrumPepperAdminCPU6001.entity.UserEntity;
import com.swlc.ScrumPepperAdminCPU6001.repository.UserRepository;
import com.swlc.ScrumPepperAdminCPU6001.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp
 */
@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getUsers() {
        log.info("Execute method getUsers: ");
        List<UserDTO> result = new ArrayList<>();
        try {
            List<UserEntity> all = userRepository.findAll();
            for (UserEntity userEntity : all) {
                result.add(this.prepareUserDTO(userEntity));
            }
            return result;
        } catch (Exception e) {
            log.error("Method getUsers : " + e.getMessage(), e);
            throw e;
        }
    }

    private UserDTO prepareUserDTO(UserEntity userEntity) {
        try {
            return new UserDTO(
                    userEntity.getId(),
                    userEntity.getRefNo(),
                    userEntity.getFirstName(),
                    userEntity.getLastName(),
                    userEntity.getContactNumber(),
                    userEntity.getEmail(),
                    null,
                    userEntity.getCreatedDate(),
                    userEntity.getStatusType()
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
