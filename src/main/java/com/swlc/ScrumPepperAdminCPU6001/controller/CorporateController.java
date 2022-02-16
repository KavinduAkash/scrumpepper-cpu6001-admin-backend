package com.swlc.ScrumPepperAdminCPU6001.controller;

import com.swlc.ScrumPepperAdminCPU6001.dto.CorporateDTO;
import com.swlc.ScrumPepperAdminCPU6001.dto.response.CommonResponseDTO;
import com.swlc.ScrumPepperAdminCPU6001.service.CorporateService;
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
@RequestMapping("v1/corporate")
public class CorporateController {

    private final CorporateService corporateService;

    public CorporateController(CorporateService corporateService) {
        this.corporateService = corporateService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getCorporates() {
        List<CorporateDTO> result = corporateService.getCorporates();
        return new ResponseEntity<>(
                new CommonResponseDTO(true, "Found corporates successfully", result),
                HttpStatus.OK
        );
    }
}
