package com.swlc.ScrumPepperAdminCPU6001.repository;

import com.swlc.ScrumPepperAdminCPU6001.entity.CorporateEntity;
import com.swlc.ScrumPepperAdminCPU6001.entity.ProjectEntity;
import com.swlc.ScrumPepperAdminCPU6001.enums.ProjectStatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author hp
 */
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
    List<ProjectEntity> findByCorporateEntity(CorporateEntity corporateEntity);
    @Query("SELECT COUNT(p) FROM ProjectEntity p WHERE p.statusType=:pstatus")
    int getProjectCountsByStatus(@Param("pstatus")ProjectStatusType projectStatusType);

    @Query("SELECT COUNT(p.id) FROM ProjectEntity p WHERE p.corporateEntity=:corp")
    int getProjectCount(@Param("corp") CorporateEntity corporateEntity);
}
