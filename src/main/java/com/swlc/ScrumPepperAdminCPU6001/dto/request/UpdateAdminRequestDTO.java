package com.swlc.ScrumPepperAdminCPU6001.dto.request;
import com.swlc.ScrumPepperAdminCPU6001.enums.AdminType;
import com.swlc.ScrumPepperAdminCPU6001.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hp
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAdminRequestDTO {
    private long id;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String contactNumber;
    private AdminType adminType;
    private StatusType statusType;

    @Override
    public String toString() {
        return "UpdateAdminRequestDTO{" +
                "id=" + id +
                ", employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", adminType=" + adminType +
                ", statusType=" + statusType +
                '}';
    }
}
