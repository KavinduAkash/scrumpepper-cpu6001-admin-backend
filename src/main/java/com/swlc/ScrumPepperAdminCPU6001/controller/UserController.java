package com.swlc.ScrumPepperAdminCPU6001.controller;

import com.swlc.ScrumPepperAdminCPU6001.dto.UserDTO;
import com.swlc.ScrumPepperAdminCPU6001.dto.response.CommonResponseDTO;
import com.swlc.ScrumPepperAdminCPU6001.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hp
 */
@RestController
@CrossOrigin
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() {
        List<UserDTO> result = userService.getUsers();
        return new ResponseEntity<>(
                new CommonResponseDTO(true, "Found user details successfully", result),
                HttpStatus.OK
        );
    }
}
