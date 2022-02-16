package com.swlc.ScrumPepperAdminCPU6001.service;

import com.swlc.ScrumPepperAdminCPU6001.dto.UserDTO;

import java.util.List;

/**
 * @author hp
 */
public interface UserService {
    List<UserDTO> getUsers();
}
