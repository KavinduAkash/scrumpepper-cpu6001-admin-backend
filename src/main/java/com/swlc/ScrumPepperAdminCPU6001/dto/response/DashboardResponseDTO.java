package com.swlc.ScrumPepperAdminCPU6001.dto.response;

import lombok.*;

/**
 * @author hp
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DashboardResponseDTO {
    private int corporatesCount;
    private int activeCorporatesCount;
    private int inactiveCorporatesCount;
    private int deletedCorporatesCount;
    private int usersCount;
    private int activeUsersCount;
    private int inactiveUsersCount;
    private int deletedUsersCount;
    private int projectsCount;
    private int activeProjectsCount;
    private int inactiveProjectsCount;
    private int deletedProjectsCount;
}
