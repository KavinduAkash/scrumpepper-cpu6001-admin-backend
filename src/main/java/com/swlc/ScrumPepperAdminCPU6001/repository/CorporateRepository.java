package com.swlc.ScrumPepperAdminCPU6001.repository;

import com.swlc.ScrumPepperAdminCPU6001.entity.CorporateEntity;
import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author hp
 */
public interface CorporateRepository extends JpaRepository<CorporateEntity, Long> {
    @Query("SELECT COUNT(c) FROM CorporateEntity c WHERE c.statusType=:corpstatus")
    int getCorporateCountsByStatus(@Param("corpstatus") StatusType statusType);
}
