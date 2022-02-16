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
public class CommonResponseDTO {
    private boolean success;
    private String msg;
    private Object body;
}
