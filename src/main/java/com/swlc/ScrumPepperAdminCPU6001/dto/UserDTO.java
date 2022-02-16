package com.swlc.ScrumPepperAdminCPU6001.dto;

import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author hp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String refNo;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String password;
    private Date createdDate;
    private StatusType statusType;

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", refNo='" + refNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                ", statusType=" + statusType +
                '}';
    }
}
