package com.swlc.ScrumPepperAdminCPU6001.repository;

import com.swlc.ScrumPepperAdminCPU6001.entity.CorporateEmployeeEntity;
import com.swlc.ScrumPepperAdminCPU6001.entity.CorporateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author hp
 */
public interface CorporateEmployeeRepository extends JpaRepository<CorporateEmployeeEntity, Long> {

    @Query("SELECT COUNT(e.id) FROM CorporateEmployeeEntity e WHERE e.corporateEntity=:corp")
    int getEmployeeCount(@Param("corp") CorporateEntity corporateEntity);
}
