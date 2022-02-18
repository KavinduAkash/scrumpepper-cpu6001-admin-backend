package com.swlc.ScrumPepperAdminCPU6001.service;

import com.swlc.ScrumPepperAdminCPU6001.dto.CorporateDTO;
import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;

import java.util.List;

/**
 * @author hp
 */
public interface CorporateService {
    List<CorporateDTO> getCorporates();
    List<CorporateDTO> changeStatus(long id, StatusType statusType);
}
