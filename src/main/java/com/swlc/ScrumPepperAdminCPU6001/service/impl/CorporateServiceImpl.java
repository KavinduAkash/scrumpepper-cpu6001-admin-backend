package com.swlc.ScrumPepperAdminCPU6001.service.impl;

import com.swlc.ScrumPepperAdminCPU6001.dto.CorporateDTO;
import com.swlc.ScrumPepperAdminCPU6001.entity.CorporateEntity;
import com.swlc.ScrumPepperAdminCPU6001.repository.CorporateRepository;
import com.swlc.ScrumPepperAdminCPU6001.service.CorporateService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hp
 */
@Log4j2
@Service
public class CorporateServiceImpl implements CorporateService {

    private final CorporateRepository corporateRepository;

    @Autowired
    public CorporateServiceImpl(CorporateRepository corporateRepository) {
        this.corporateRepository = corporateRepository;
    }

    @Override
    public List<CorporateDTO> getCorporates() {
        log.info("Execute method getCorporates: ");
        List<CorporateDTO> result = new ArrayList<>();
        try {
            List<CorporateEntity> all = corporateRepository.findAll();
            for (CorporateEntity corporateEntity : all) {
                result.add(this.prepareCorporateDTO(corporateEntity));
            }
            return result;
        } catch (Exception e) {
            log.error("Method getCorporates : " + e.getMessage(), e);
            throw e;
        }
    }

    private CorporateDTO prepareCorporateDTO(CorporateEntity c) {
        try {
            return new CorporateDTO(
                    c.getId(),
                    c.getName(),
                    c.getAddress(),
                    c.getContactNumber1(),
                    c.getContactNumber2(),
                    c.getEmail(),
                    c.getCorporateLogo(),
                    c.getStatusType()
            );
        } catch (Exception e) {
            throw e;
        }
    }
}
