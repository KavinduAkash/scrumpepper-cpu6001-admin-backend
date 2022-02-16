package com.swlc.ScrumPepperAdminCPU6001.controller;

import com.swlc.ScrumPepperAdminCPU6001.dto.CorporateDTO;
import com.swlc.ScrumPepperAdminCPU6001.dto.response.CommonResponseDTO;
import com.swlc.ScrumPepperAdminCPU6001.dto.response.DashboardResponseDTO;
import com.swlc.ScrumPepperAdminCPU6001.service.DashboardService;
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
@RequestMapping("v1/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getDashboard() {
        DashboardResponseDTO dashboard = dashboardService.getDashboard();
        return new ResponseEntity<>(
                new CommonResponseDTO(true, "Found dashboard data successfully", dashboard),
                HttpStatus.OK
        );
    }
}
