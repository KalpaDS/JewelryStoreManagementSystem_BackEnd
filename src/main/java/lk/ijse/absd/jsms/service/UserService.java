package lk.ijse.absd.jsms.service;

import lk.ijse.absd.jsms.dto.UserDTO;

public interface UserService {
    boolean canAuthenticate(UserDTO userDTO);
}
