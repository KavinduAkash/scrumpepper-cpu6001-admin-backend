package com.swlc.ScrumPepperAdminCPU6001.service.impl;

import com.swlc.ScrumPepperAdminCPU6001.dto.response.DashboardResponseDTO;
import com.swlc.ScrumPepperAdminCPU6001.entity.CorporateEntity;
import com.swlc.ScrumPepperAdminCPU6001.entity.ProjectEntity;
import com.swlc.ScrumPepperAdminCPU6001.entity.UserEntity;
import com.swlc.ScrumPepperAdminCPU6001.enums.ProjectStatusType;
import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;
import com.swlc.ScrumPepperAdminCPU6001.repository.CorporateRepository;
import com.swlc.ScrumPepperAdminCPU6001.repository.ProjectRepository;
import com.swlc.ScrumPepperAdminCPU6001.repository.UserRepository;
import com.swlc.ScrumPepperAdminCPU6001.service.DashboardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hp
 */
@Log4j2
@Service
public class DashboardServiceImpl implements DashboardService {

    private final CorporateRepository corporateRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public DashboardServiceImpl(CorporateRepository corporateRepository, UserRepository userRepository,
                                ProjectRepository projectRepository) {
        this.corporateRepository = corporateRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public DashboardResponseDTO getDashboard() {
        log.info("Execute method getDashboard: ");
        try {
            List<CorporateEntity> allCorporates = corporateRepository.findAll();
            int corporatesCount = allCorporates.size();
            int activeCorporatesCount = corporateRepository.getCorporateCountsByStatus(StatusType.ACTIVE);
            int inactiveCorporatesCount = corporateRepository.getCorporateCountsByStatus(StatusType.INACTIVE);
            int deletedCorporatesCount = corporateRepository.getCorporateCountsByStatus(StatusType.DELETE);

            List<UserEntity> allUsers = userRepository.findAll();
            int userCount = allUsers.size();
            int activeUsersCount = userRepository.getUserCountsByStatus(StatusType.ACTIVE);
            int inactiveUsersCount = userRepository.getUserCountsByStatus(StatusType.INACTIVE);
            int deletedUsersCount = userRepository.getUserCountsByStatus(StatusType.DELETE);

            List<ProjectEntity> allProjects = projectRepository.findAll();
            int projectCount = allProjects.size();
            int activeProjectsCount = projectRepository.getProjectCountsByStatus(ProjectStatusType.ACTIVE);
            int inactiveProjectsCount = projectRepository.getProjectCountsByStatus(ProjectStatusType.INACTIVE);
            int deletedProjectsCount = projectRepository.getProjectCountsByStatus(ProjectStatusType.DELETE);

            return new DashboardResponseDTO(
                    corporatesCount,
                    activeCorporatesCount,
                    inactiveCorporatesCount,
                    deletedCorporatesCount,
                    userCount,
                    activeUsersCount,
                    inactiveUsersCount,
                    deletedUsersCount,
                    projectCount,
                    activeProjectsCount,
                    inactiveProjectsCount,
                    deletedProjectsCount
            );
        } catch (Exception e) {
            log.error("Method getDashboard : " + e.getMessage(), e);
            throw e;
        }
    }
}
