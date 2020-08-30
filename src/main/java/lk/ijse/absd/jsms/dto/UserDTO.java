package lk.ijse.absd.jsms.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String userName;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
